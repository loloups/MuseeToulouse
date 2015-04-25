package museetoulouse

import org.w3c.dom.ranges.Range

class Adresse {

    String numero
    String rue
    int codePostal
    String ville

    String toString() {
        "$numero $rue $codePostal $ville"
    }

    static constraints = {
        codePostal validator: { return (it.toString().size() == 5) }, matches: "[0-9]+"
        ville matches: "[A-Z]+"
    }
}
