package friendsofmine


import spock.lang.*

/**
 *
 */
class InscriptionServiceIntegrationSpec extends Specification {

    Activite uneActivite
    Utilisateur unUtilisateur
    JeuTestService jeuTestService

    ActiviteService activiteService
    InscriptionService inscriptionService

    def setup() {
        // l'activité
        uneActivite = new Activite(titre: "act1")
        Utilisateur unResponsable = new Utilisateur(nom: "Dupont", prenom: "Jeanne", sexe: "F", email: "j@j.com")
        activiteService.insertOrUpdateActiviteForResponsable(uneActivite, unResponsable)

        // l'utilisateur
        unUtilisateur = new Utilisateur(nom: "Durand", prenom: "paul", sexe: "M", email: "p@j.com").save()
    }

    void "test la création ou la mise à jour d'une inscription"() {

        given: "une inscription"
        Inscription uneInscription = new Inscription(activite: uneActivite, utilisateur: unUtilisateur)


        when: "on insert ou met à jour l'inscription"
        Inscription resInscription = inscriptionService.insertOrUpdateInscription(uneInscription)

        then: "l'inscription isérée est bien celle retournée"
        resInscription == uneInscription

        and:"l'inscription a bien un id"
        uneInscription.id != null

        and:"elle est valide"
        uneInscription.validate()

        and:"elle est bien stockée en base"
        Inscription.findById(uneInscription.id) != null

        and :"les propriétes sont mises à jours comme attendues"
        uneInscription.activite == uneActivite
        uneInscription.utilisateur == unUtilisateur
        uneInscription.dateInscription != null
    }

    void "test de la suppression d'une inscription"() {

        given:"une inscription existante en base"
        Inscription uneInscription = new Inscription(activite: uneActivite, utilisateur: unUtilisateur)
        inscriptionService.insertOrUpdateInscription(uneInscription)

        when:"on déclenche la suppression de l'inscription"
        inscriptionService.deleteInscription(uneInscription)

        then:"l'inscription est supprimée de la base"
        Inscription.findById(uneInscription.id) == null

        and:"ni l'activité, ni l'utilisateur ne sont supprimés"
        Activite.findById(uneActivite.id) != null
        Utilisateur.findById(unUtilisateur.id) != null

    }

    void "test du moteur de recherche sur les inscriptions"() {

        given:"les activités, les utilisateurs et les inscriptions fournis par le jeu de test "
        jeuTestService

        when:"on cherche les inscriptions dont le titre de l'activité contient 'ct' "
        List<Inscription> res = inscriptionService.searchInscriptions("ct1",null,null)

        then:"on récupère uniquement les 2 inscriptions sur activité 1"
        res.size() == 2
        res*.id.contains(jeuTestService.jeanneOnAct1.id)
        res*.id.contains(jeuTestService.jacquesOnAct1.id)

        when:"on cherche les inscriptions dont les activités sont gérées par le responsable dont le nom ou le prenom contient 'Val'"
        res = inscriptionService.searchInscriptions(null,'Val',null)

        then:"on récupère uniquement l'inscription jacquesOnAct3"
        res.size() == 1
        res*.id.contains(jeuTestService.jacquesOnAct3.id)

        when:"on cherche les inscriptions sur lesquelles une personne dont le nom ou me prénom contient 'Jack' "
        res = inscriptionService.searchInscriptions(null,null,'Jacq')

        then:"on recupère les 2 inscriptions de Jacques"
        res.size() == 2
        res*.id.contains(jeuTestService.jacquesOnAct3.id)
        res*.id.contains(jeuTestService.jacquesOnAct1.id)

        and:"elle sont ordonnées suivant le titre de l'activité"
        res*.activite*.titre == [jeuTestService.activite1.titre, jeuTestService.activite3.titre]

        when:"on cherche les inscriptions sur lesquelles une personne dont le nom ou me prénom contient 'Jack'et dont les activités sont gérées par le responsable dont le nom ou le prenom contient 'Isa'  "
        res = inscriptionService.searchInscriptions(null,'Isa','Jacq')

        then:"on récupère uniquement l'inscription jacquesOnAct1"
        res.size() == 1
        res*.id.contains(jeuTestService.jacquesOnAct1.id)

        when:"on cherche les inscriptions dont le titre de l'activité contient 'Isa'"
        res = inscriptionService.searchInscriptions("Isa",null,null)

        then: "on ne récupère aucune inscription"
        res.size() == 0

        when:"on positionne tous les critères à null"
        res = inscriptionService.searchInscriptions(null, null, null)

        then: "on récupère toutes les inscriptions"
        res.size() == 3

        and:"elle sont ordonnées suivant le titre de l'activité"
        res*.activite*.titre == [jeuTestService.activite1.titre, jeuTestService.activite1.titre, jeuTestService.activite3.titre]
    }


}
