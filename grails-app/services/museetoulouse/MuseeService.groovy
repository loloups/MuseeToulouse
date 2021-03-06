package museetoulouse

import grails.transaction.Transactional

import javax.servlet.http.HttpSession

@Transactional
class MuseeService {

    /**
     * Cherche les musees correspondant aux critères
     * @param inNomMusee chaîne de caractère présente dans le nom du musee
     * @param inCodePostal chaîne de caractère presente dans le codepostal
     * @param inNomRue chaîne de caractère presente dans la rue du musee
     * @return
     */
    List<Musee> searchMusees(String inNomMusee, String inCodePostal, String inNomRue,params) {
        params.max  = Math.min(params.max?.toInteger() ?: 5, 100)
        params.offset = params.offset ? params.offset.toInteger() : 0
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list(params) {
            if (inNomMusee) {
                    like 'nom', "%${inNomMusee.toUpperCase()}%"
            }
            if (inCodePostal) {
                adresse {
                        eq 'codePostal', Integer.decode(inCodePostal)
                }
            }
            if (inNomRue) {
                adresse {
                    like 'rue', "%${inNomRue.toUpperCase()}%"
                }
            }
            order 'nom'
        }
        res
    }

    int numberSearchMusees(String inNomMusee, String inCodePostal, String inNomRue,params) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list() {
            if (inNomMusee) {
                like 'nom', "%${inNomMusee.toUpperCase()}%"
            }
            if (inCodePostal) {
                adresse {
                    eq 'codePostal', Integer.decode(inCodePostal)
                }
            }
            if (inNomRue) {
                adresse {
                    like 'rue', "%${inNomRue.toUpperCase()}%"
                }
            }
            order 'nom'
        }
        res.size()
    }

}
