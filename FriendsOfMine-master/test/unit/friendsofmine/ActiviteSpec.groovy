package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Activite)
class ActiviteSpec extends Specification {

    @Unroll
    void "test la validite d'une activite valide"(String unDescriptif, def _) {

        given: "une activite initialise avec un titre non vide, un responsable et un descriptif"
        Activite activite = new Activite(titre: "un titre", responsable: Mock(Utilisateur), descriptif: unDescriptif)

        expect: "l'activite est valide"
        activite.validate() == true

        where:
        unDescriptif    | _
        null            | _
        ""              | _
        "un descriptif" | _

    }

    @Unroll
    void "test l'invalidite d'une activite non valide"(String unTitre, Utilisateur unResponsable) {

        given: "une activite initialise avec un titre vide ou sans responsable"
        Activite activite = new Activite(titre: unTitre, responsable: unResponsable)

        expect: "l'activite est invalide"
        activite.validate() == false

        where:
        unTitre    | unResponsable
        null       | Mock(Utilisateur)
        ""         | Mock(Utilisateur)
        "un titre" | null

    }
}
