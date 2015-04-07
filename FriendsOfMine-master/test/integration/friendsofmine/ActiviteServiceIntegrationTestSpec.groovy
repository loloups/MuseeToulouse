package friendsofmine


import spock.lang.*

/**
 *
 */
class ActiviteServiceIntegrationTestSpec extends Specification {

    ActiviteService activiteService

    void "test insertion ou mise à jour d'une  activité avec responsable"() {

        given:"une activité"
        Activite uneActivite = new Activite(titre: "act1")

        and: "un responsable"
        Utilisateur unResponsable = new Utilisateur(nom: "Dupont", prenom: "Jeanne",sexe: "F",email: "j@j.com")

        when: "on tente de répercuter en base la création ou la modification de l'activité"
        Activite resultActivite = activiteService.insertOrUpdateActiviteForResponsable(uneActivite,unResponsable)

        then: "l'activite resultante pointe sur l'activite initale"
        resultActivite == uneActivite

        and:"l'activité résultante n'a pas d'erreur"
        !resultActivite.hasErrors()

        and:"l'activité résultante a un id"
        resultActivite.id

        and:"l'activité est bien presente en base"
        Activite.findById(resultActivite.id) != null

        and: "l'activite a pour responsable le responsable passé en paramètre"
        resultActivite.responsable == unResponsable

        and:"le responsable a dans sa liste d'activité l'activité passé en paramètre"
        println ">>>>>>> classe pour activites : ${unResponsable.activites.class.name}"
        unResponsable.activites.contains(resultActivite)
    }

    void "test suppression d'une activité"() {

        given: "une activité existante en base"
        Activite uneActivite = new Activite(titre: "act1")
        Utilisateur unResponsable = new Utilisateur(nom: "Dupont", prenom: "Jeanne",sexe: "F",email: "j@j.com")
        uneActivite = activiteService.insertOrUpdateActiviteForResponsable(uneActivite,unResponsable)

        when:"on tente de supprimer l'activité"
        activiteService.deleteActivite(uneActivite)

        then:"l'activite n'existe plus en base"
        Activite.findById(uneActivite.id) == null

        and:"le responsable n'a plus l'activite dans sa liste d'activité"
        !unResponsable.activites.contains(uneActivite)
    }
}
