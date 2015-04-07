package friendsofmine

class Inscription {

    Utilisateur utilisateur
    Activite activite
    Date dateInscription

    static constraints = {
    }

    static mapping = {
        utilisateur fetch: 'join'
    }
}
