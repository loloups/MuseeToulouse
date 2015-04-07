package friendsofmine

class Activite {

    String titre
    String descriptif

    Utilisateur responsable

    String toString() {
        "$titre (${responsable.toString()})"
    }

    static constraints = {
        titre blank: false
        descriptif nullable: true
    }
}
