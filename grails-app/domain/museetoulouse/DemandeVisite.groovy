package museetoulouse

class DemandeVisite {

    int code;
    Date dateDebutPeriode
    Date dateFinPeriode;
    int nbPersonnes;
    String statut;
    static hasMany = [musees: Musee]
    static constraints = {
        code blank : false
        dateDebutPeriode blank : false
        dateFinPeriode blank : false
        statut blank: true
    }
    static belongsTo = [Musee]
}
