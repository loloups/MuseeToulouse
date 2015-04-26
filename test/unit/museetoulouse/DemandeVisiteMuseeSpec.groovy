package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite de musée valide"(DemandeVisite demandeVisite,Musee musee,Date date) {

        given: "une demande initialisee avec musee, demandeVisite et date"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(demandeVisite, musee, date)

        expect: "la demande est valide"
        demandeVisiteMusee.validate() == true

        where:
        demandeVisite | musee | date
        new DemandeVisite()| new Musee() | new Date()
    }

    @Unroll
    void "test l'invalidite d'une demande de visite de musée valide"(DemandeVisite demandeVisite,Musee musee,Date date) {

        given: "une demande initialisee avec musee, demandeVisite et date"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(demandeVisite, musee, date)

        expect: "la demande est invalide"
        demandeVisiteMusee.validate() == false

        where:
        demandeVisite | musee | date
         " " | " " | " "
    }
}
