package museetoulouse

class Musee {
    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus

    Gestionnaire responsable
    Adresse adresse

    static constraints = {
        //telephone matches: "d{10}"
    }
}
