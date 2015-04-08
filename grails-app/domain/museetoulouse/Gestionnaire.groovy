package museetoulouse

class Gestionnaire {

    String nom;
    static hasMany = [ gestionnaires : Gestionnaire]

    static constraints = {
        nom blank:false
    }
}
