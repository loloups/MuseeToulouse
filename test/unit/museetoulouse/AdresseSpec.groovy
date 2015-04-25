package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"(String unNumero,String uneRue,int unCodePostal,String uneVille) {

        given: "une adresse initialise avec un numero, une rue, un code postal et une ville"
        Adresse adresse = new Adresse(numero: unNumero, rue: uneRue,codePostal: unCodePostal, ville: uneVille)

        expect: "l'adresse est valide"
        adresse.validate() == true

        where:
        unNumero | uneRue | unCodePostal | uneVille
        "num"| "rue" | 34567 | "MONTECH"
    }

    @Unroll
    void "test l'invalidite d'une adresse invalide"(String unNumero,String uneRue,int unCodePostal,String uneVille) {

        given: "une adresse initialise avec un numero, une rue, un code postal et une ville"
        Adresse adresse = new Adresse(numero: unNumero, rue: uneRue,codePostal: unCodePostal, ville: uneVille)

        expect: "l'adresse est valide"
        adresse.validate() == false

        where:
        unNumero | uneRue | unCodePostal | uneVille
        ""| "rue" | 34567 | "MONTECH"
        "num"| "" | 34567 | "MONTECH"
        "num"| "rue" | 3456 | "MONTECH"
        "num"| "rue" | 34567 | "Montech"
    }
}
