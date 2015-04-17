package museetoulouse

import grails.transaction.Transactional

@Transactional
class MuseeService {

    def serviceMethod() {

    }

    /**
     * Cherche les musees correspondant aux critères
     * @param inNomMusee chaîne de caractère présente dans le nom du musee
     * @param inCodePostal chaîne de caractère presente dans le codepostal
     * @param inNomRue chaîne de caractère presente dans la rue du musee
     * @return
     */
    List<Musee> searchMusees(String inNomMusee, String inCodePostal, String inNomRue,params) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list {
            if (inNomMusee) {
                    like 'nom', "%${inNomMusee}%"
            }
            if (inCodePostal) {
                adresse {
                        eq 'codePostal', Integer.decode(inCodePostal)
                }
            }
            if (inNomRue) {
                adresse {
                    like 'rue', "%${inNomRue}%"
                }
            }
            order 'nom'
        }
        res
    }

    /** Ajouter un musée aux musées préféré
     *
     * @param musee
     * @return la liste des musees préférées
     */
    List<Musee> addMuseePrefere(Musee musee) {
        musee.setPrefere(true)
        musee.save(flush: true)
        Musee.findAllByPrefere(true)
    }
}
