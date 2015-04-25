package museetoulouse



import spock.lang.*

/**
 *
 */
class MuseeServiceIntegrationTestSpec extends Specification {

    MuseeService museeService

    void "test de la recherche de musees"() {
        given:"params"
        String inNomMusee = "Musee"
        String inCodePostal = "31000"
        String inNomRue = ""

        when:"on lance la recherche avec ses paramètres"
        List<Musee> musees = museeService.searchMusees(inNomMusee,inCodePostal,inNomRue,[max:5])

        then:"la liste de musees n'est pas nulle "
        musees

        and: "le resultat de la recherche est correct"
        musees.size() == 4
    }
}
