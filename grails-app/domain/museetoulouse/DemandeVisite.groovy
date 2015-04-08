package museetoulouse

class DemandeVisite {

    int code;
    Date dateDebutPeriode
    Date dateFinPeriode;
    int nbPersonnes;
    String statut;
    static hasMany = [gestionnaires: Gestionnaire]
    static constraints = {
        code blank : false
        dateDebutPeriode blank : false
        dateFinPeriode blank : false
        statut blank: true
    }
}
