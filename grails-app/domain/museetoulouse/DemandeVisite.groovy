package museetoulouse

class DemandeVisite {

    int code;
    Date dateDebutPeriode
    Date dateFinPeriode;
    int nbPersonnes;
    String statut;
    static hasMany = [musees: Musee]
    static constraints = {
        code nullable: true
        dateDebutPeriode blank : false
        dateFinPeriode blank : false,validator : { val,obj -> val >= obj.dateDebutPeriode }
        statut defaultValue : "Traitement en cours", nullable: true
        nbPersonnes blank: false,min: 1,max: 6
    }

    static mapping = {
        id column: 'code',name: 'code', type: 'integer',generator: 'identity'
    }
    static belongsTo = [Musee]
}
