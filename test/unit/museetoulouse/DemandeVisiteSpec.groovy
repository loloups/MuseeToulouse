package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite valide"(int code,Date dateDebutPeriode, Date dateFinPeriode, int nbPersonnes, String statut) {

        given: "une demande initialisee avec musee, demandeVisite et date"
        DemandeVisite demandeVisite = new DemandeVisite(code:code, dateDebutPeriode:dateDebutPeriode, dateFinPeriode:dateFinPeriode, nbPersonnes:nbPersonnes, statut:statut)

        expect: "la demande est valide"
        demandeVisite.validate() == true

        where:
        code | dateDebutPeriode | dateFinPeriode | nbPersonnes | statut
         3 | new Date(26, 4, 2015) |new Date(26, 4, 2015) | 5 | "efdsfb"
        3 | new Date(26, 4, 2015) |new Date(27, 4, 2015) | 5 | "efdsfb"

    }

    @Unroll
    void "test l'invalidite d'une demande de visite valide"(int code,Date dateDebutPeriode, Date dateFinPeriode, int nbPersonnes, String statut) {

        given: "une demande initialisee avec musee, demandeVisite et date"
        DemandeVisite demandeVisite = new DemandeVisite(code:code, dateDebutPeriode:dateDebutPeriode, dateFinPeriode:dateFinPeriode, nbPersonnes:nbPersonnes, statut:statut)

        expect: "la demande est invalide"
        demandeVisite.validate() == false

        where:
        code | dateDebutPeriode | dateFinPeriode | nbPersonnes | statut
        1 | new Date(26, 4, 2015) |new Date(25, 4, 2015) | 5 | "efdsfb"
        1 | new Date(26, 4, 2015) |new Date(27, 4, 2015) | 0 | "efdsfb"
        1 | new Date(26, 4, 2015) |new Date(27, 4, 2015) | 7 | "efdsfb"

    }
}
