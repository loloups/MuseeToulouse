package museetoulouse


import spock.lang.*

/**
 *
 */
class InitHibernateWithCsvDataServiceIntegrationTestSpec extends Specification {

    InitHibernateWithCsvDataService initHibernateWithCsvDataService

    void "test de l'insertion en base a partir du fichier csv"() {
        given:"le fichier csv et la table musee vide"
        Musee.deleteAll()

        when:"on lance le service qui est lancé dans init"

        then:"les insertions ont marchés"
        Musee.count() == 12
    }
}
