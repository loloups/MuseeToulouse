package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    @Unroll
    void "test la validite d'un gestionnaire"(String unNom) {

        given: "un gestionnaire initialisee avec son nom"
        Gestionnaire gestionnaire = new Gestionnaire(unNom)

        expect: "le gestionnaire est valide"
        gestionnaire.validate() == true

        where:
        unNom << ["azegs", "1234"]

    }

    @Unroll
    void "test l'invalidite d'un gestionnaire"(String unNom) {

        given: "un gestionnaire initialisee avec son nom"
        Gestionnaire gestionnaire = new Gestionnaire(unNom)

        expect: "le gestionnaire est valide"
        gestionnaire.validate() == false

        where:
        unNom << ["", 1234]
    }
}

