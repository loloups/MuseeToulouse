package museetoulouse

class Musee {
    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus
    boolean prefere

    Gestionnaire responsable
    Adresse adresse
    static hasMany = [demandesVisites: DemandeVisite]
    static constraints = {
        //telephone matches: "d{10}"
        prefere default: false
    }

    static mapping = {
        adresse fetch: 'join'
    }
}
