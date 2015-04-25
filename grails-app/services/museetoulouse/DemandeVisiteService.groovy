package museetoulouse

import grails.transaction.Transactional

@Transactional
class DemandeVisiteService {

    def ajouterDemandeVisite(DemandeVisite demandeVisite,params) {
        params.list("museesPreferees").each {
            Musee m = Musee.findById(it)
            m.addToDemandesVisites(demandeVisite)
            demandeVisite.addToMusees(m)
            m.save flush: true
            DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(musee: m,demandeVisite: demandeVisite,dateDemande: new Date())
            demandeVisiteMusee.save()
        }
    }
}
