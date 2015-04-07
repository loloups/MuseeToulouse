package friendsofmine


import spock.lang.*

/**
 *
 */
class JeuTestServiceIntegrationSpec extends Specification {

    JeuTestService jeuTestService

    void "test creation jeu de tests pour activités"() {

        given: "une base ne contenant pas d'activités"
        Activite.count() == 0

        when: "on crée le jeu de test pour les activite"
        jeuTestService.createJeuTestFoActivite()

        then: "3 nouvelles activités ont été crées en base"
        Activite.count() == 3


        when:" des activites exitent deja dans la base"
        Activite.count() == 3

        and:"on déclenche à nouveau la création du jeu de test pour activité"
        jeuTestService.createJeuTestFoActivite()

        then:"aucune nouvelle activité n'est crée"
        Activite.count() == 3

    }
}
