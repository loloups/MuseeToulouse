package museetoulouse

class Adresse {

    String numero
    String rue
    int codePostal
    String ville

    static constraints = {
        codePostal size: 5, matches: "[0-9]+"
        ville matches: "[A-Z]+"
    }
}
