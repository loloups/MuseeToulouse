package friendsofmine

import grails.transaction.Transactional

@Transactional
class JeuTestService {

    Activite activite1
    Activite activite2
    Activite activite3

    Utilisateur respIsabelle
    Utilisateur respRemi


    Utilisateur jeanne
    Utilisateur jacques
    Utilisateur viviana

    Inscription jeanneOnAct1
    Inscription jacquesOnAct1
    Inscription jacquesOnAct3


    ActiviteService activiteService
    InscriptionService inscriptionService

    def createJeuTestFoActivite() {
        if (Activite.count() == 0) {
            respIsabelle = new Utilisateur(
                    nom: "Dufrene",
                    prenom: "Isabelle",
                    sexe: "F",
                    email: "df@df.org"
            )
            activite1 = activiteService.insertOrUpdateActiviteForResponsable(new Activite(titre: "Act1"), respIsabelle)
            activite2 = activiteService.insertOrUpdateActiviteForResponsable(new Activite(titre: "Act2"), respIsabelle)

            respRemi = new Utilisateur(
                    nom: "Valo",
                    prenom: "Remi",
                    sexe: "M",
                    email: "rf@r.org"
            )
            activite3 = activiteService.insertOrUpdateActiviteForResponsable(new Activite(titre: "Act3"), respRemi)
        }
    }

    def createJeuTestForUtilisateurs() {
        if (Utilisateur.count() == 0) {
            jeanne = new Utilisateur(nom: "Dupond", prenom: "Jeanne", sexe: "F", email: "jd@jd.com", dateNaissance: new Date(1972, 06, 17)).save()
            jacques = new Utilisateur(nom: "Doe", prenom: "Jacques", sexe: "M", email: "jad@jad.com", dateNaissance: new Date(1973, 06, 17)).save()
            viviana = new Utilisateur(nom: "Durand", prenom: "Viviana", sexe: "F", email: "viv@viv.com", dateNaissance: new Date(1990, 06, 17)).save()
        }
    }

    def createJeuTestForInscription() {
        if (Inscription.count() == 0) {
            jeanneOnAct1 = inscriptionService.insertOrUpdateInscription(new Inscription(utilisateur: jeanne, activite: activite1))
            jacquesOnAct3 = inscriptionService.insertOrUpdateInscription(new Inscription(utilisateur: jacques, activite: activite3))
            jacquesOnAct1 = inscriptionService.insertOrUpdateInscription(new Inscription(utilisateur: jacques, activite: activite1))
        }
    }
}