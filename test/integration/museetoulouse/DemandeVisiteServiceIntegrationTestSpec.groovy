package museetoulouse

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import spock.lang.*

/**
 *
 */
class DemandeVisiteServiceIntegrationTestSpec extends Specification {

    DemandeVisiteService demandeVisiteService
    MuseeController museeController = new MuseeController()

    void "test de l'ajout des demandevisitemusees avec de musees et d'une demandevisite" () {

        given:"une demandevisite"
        DemandeVisite demandeVisite = new DemandeVisite(dateDebutPeriode: new Date(),dateFinPeriode: new Date(),nbPersonnes: 5)
        demandeVisite.save flush: true

        and:"une liste de musees"
        List<Musee> musees = Musee.findAll()
        System.out.println("musees"+musees)
        museeController.params["museesPreferees"] = musees.id
        System.out.println("rfrefreferferfer"+museeController.params.list("museesPreferees"))


        when:"j'appelle le service"
        demandeVisiteService.ajouterDemandeVisite(demandeVisite,museeController.params)

        then:"la demandevisite a la liste musees en musees"
        demandeVisite.musees.containsAll(musees)

        and:"chaque musee a la demandevisite"
        musees.each {it.demandesVisites.contains(demandeVisite)}
    }
}
