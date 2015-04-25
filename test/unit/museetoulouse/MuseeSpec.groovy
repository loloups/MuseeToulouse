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
    void "test la validite d'une demande de visite de musée valide"(String nom, String horairesOuverture, String telephone,
            String accesMetro, String accesBus, boolean prefere, Gestionnaire responsable, Adresse adresse) {

        given: "un musee initialisee avec ses paramètres"
        Musee musee = new Musee(nom, horairesOuverture, telephone, accesMetro, accesBus, prefere, responsable, adresse)

        expect: "le musée est valide"
        musee.validate() == true

        where:
        nom | horairesOuverture | telephone | accesMetro | accesBus | prefere | responsable | adresse
        "dfb" | "dfb" | "dfb" | "dfb" | "dfb" | true | new Gestionnaire() | "dfb"
        " " | " " | " " | " " | " " | true | new Gestionnaire() | " "
    }

    @Unroll
    void "test l'invalidite d'une demande de visite de musée valide"(String nom, String horairesOuverture, String telephone,
                                                                    String accesMetro, String accesBus, boolean prefere, Gestionnaire responsable, Adresse adresse) {

        given: "un musee initialisee avec ses paramètres"
        Musee musee = new Musee(nom, horairesOuverture, telephone, accesMetro, accesBus, prefere, responsable, adresse)

        expect: "le musée est invalide"
        musee.validate() == false

        where:
        nom | horairesOuverture | telephone | accesMetro | accesBus | prefere | responsable | adresse
        String | "dfb" | "dfb" | "dfb" | "dfb" | true | new Gestionnaire() | "dfb"
        " " | String | " " | " " | " " | true | new Gestionnaire() | " "
        " " | " " | String | " " | " " | true | new Gestionnaire() | " "
        " " | " " | " " | String | " " | true | new Gestionnaire() | " "
        " " | " " | " " | " " | String | true | new Gestionnaire() | " "
        " " | " " | " " | " " | " " | boolean | new Gestionnaire() | " "
        " " | " " | " " | " " | " " | true | Gestionnaire | " "
        " " | " " | " " | " " | " " | true | new Gestionnaire() | String
    }
}
