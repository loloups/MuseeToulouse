package museetoulouse

class Gestionnaire {

    String nom;
    static hasMany = [ musees : Musee]

    String toString() {
        "$nom"
    }

    static constraints = {
        nom blank:false
    }
}
