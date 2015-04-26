package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite de mus�e valide"(String nom, String horairesOuverture, String telephone,
            String accesMetro, String accesBus, Gestionnaire responsable, Adresse adresse) {

        given: "un musee initialisee avec ses param�tres"
        Musee musee = new Musee(nom:nom, horairesOuverture:horairesOuverture, telephone:telephone, accesMetro:accesMetro, accesBus:accesBus, responsable:responsable, adresse:adresse)

        expect: "le mus�e est valide"
        musee.validate() == true

        where:
        nom | horairesOuverture | telephone | accesMetro | accesBus | responsable | adresse
        "dfb" | "dfb" | "dfb" | "dfb" | "dfb" | new Gestionnaire() | new Adresse()
    }
}
