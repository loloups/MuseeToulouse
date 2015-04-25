package museetoulouse

class DemandeVisiteMusee {

    DemandeVisite demandeVisite
    Musee musee
    Date dateDemande
    static constraints = {
        dateDemande nullable: false
        musee nullable: false
        demandeVisite nullable: false
    }
}
