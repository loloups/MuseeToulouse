package museetoulouse

class Gestionnaire {

    String nom;
    static hasMany = [ musees : Musee]

    static constraints = {
        nom blank:false
    }
}
