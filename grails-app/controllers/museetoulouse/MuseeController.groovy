package museetoulouse



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    MuseeService museeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 5, 100)
        respond Musee.list(params), model:[museeInstanceCount: Musee.count()]
    }

    def show(Musee museeInstance) {
        respond museeInstance
    }

    def create() {
        respond new Musee(params)
    }

    def doSearchMusees() {
        session.musees = []
        def museeList = museeService.searchMusees(params.nom,params.codepostal, params.rue,[max:5])
        def museeSize = museeService.numberSearchMusees(params.nom,params.codepostal, params.rue,[max:5])
        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeSize])
    }

    @Transactional
    def ajouterMuseePreferee(Musee museeInstance) {
        if(museeInstance)
            session.musees.add museeInstance
        def museesPreferees = session.musees
        //museeInstance.save(flush: true)
        params.max = 5;
        render(template: '../aa1', model: [museeInstanceList: Musee.list(params), museeInstanceCount: Musee.count(),museesPreferees: museesPreferees,museesPrefereesCount: museesPreferees.size()])
        //Put this at the top

//now in controllers when rendering use this.
//        render( { jq ->
//            jq("#encart").removeAttr('hidden');
//            jq("#museePrefere tbody").html( g.render( template:"list", model:[list:museesPreferees]) )
//        } as Javascript)
//        render text: """<script type="text/javascript">
//            alert(${museesPreferees.get(0).getNom()});
//        </script>""", contentType: 'application/javascript'
    }

    @Transactional
    def supprimerMuseePreferee(Musee museeInstance) {
        if(museeInstance) {
            Musee m
            def it = session.musees.iterator()
            while (it.hasNext()) {
                m = it.next()
                if(m.id == museeInstance.id){
                    it.remove()
                    break
                }
            }
        }
        def museesPreferees = session.musees
        //museeInstance.save(flush: true)
        params.max = 5;
        render(template: '../aa1', model: [museeInstanceList: Musee.list(params), museeInstanceCount: Musee.count(),museesPreferees: museesPreferees,museesPrefereesCount: museesPreferees.size()])
        //Put this at the top

//now in controllers when rendering use this.
//        render( { jq ->
//            jq("#encart").removeAttr('hidden');
//            jq("#museePrefere tbody").html( g.render( template:"list", model:[list:museesPreferees]) )
//        } as Javascript)
//        render text: """<script type="text/javascript">
//            alert(${museesPreferees.get(0).getNom()});
//        </script>""", contentType: 'application/javascript'
    }

    @Transactional
    def save(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view:'create'
            return
        }

        museeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*' { respond museeInstance, [status: CREATED] }
        }
    }

    def edit(Musee museeInstance) {
        respond museeInstance
    }

    @Transactional
    def update(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view:'edit'
            return
        }

        museeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*'{ respond museeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Musee museeInstance) {

        if (museeInstance == null) {
            notFound()
            return
        }

        museeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musee.label', default: 'Musee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
