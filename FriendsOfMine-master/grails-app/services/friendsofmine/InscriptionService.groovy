package friendsofmine

import grails.transaction.Transactional

@Transactional
class InscriptionService {

    /**
     * Insert ou update une inscription
     * @param inscription
     * @return l'inscription
     */
    Inscription insertOrUpdateInscription(Inscription inscription) {
        inscription.dateInscription = new Date()
        inscription.save(flush: true)
        inscription
    }

    /**
     * Supprime une inscription
     * @param uneInscription l'inscription à supprimer
     */
    void deleteInscription(Inscription uneInscription) {
        uneInscription.delete()
    }

    /**
     * Cherche les inscriptions correspondant aux critères
     * @param inTitreAct chaîne de caractère présente dans le titre de l'activité
     * @param inNomPrenonResp chaîne de caractère presente dans le nom/prenom du resp
     * @param inNomPrenomUtilisateur chaîne de caractère presente dans le nom/prenom de l'inscrit
     * @return
     */
    List<Inscription> searchInscriptions(String inTitreAct, String inNomPrenonResp, String inNomPrenomUtilisateur) {
        def criteria = Inscription.createCriteria()
        List<Inscription> res = criteria.list {
            if (inTitreAct) {
                activite {
                    like 'titre', "%${inTitreAct}%"
                }
            }
            if (inNomPrenonResp) {
                activite {
                    responsable {
                        or {
                            like 'nom', "%${inNomPrenonResp}%"
                            like 'prenom', "%${inNomPrenonResp}%"
                        }
                    }
                }
            }
            if (inNomPrenomUtilisateur) {
                utilisateur {
                    or {
                        like 'nom', "%${inNomPrenomUtilisateur}%"
                        like 'prenom', "%${inNomPrenomUtilisateur}%"
                    }
                }
            }
            activite {
                order('titre')
            }
            join 'activite.responsable'
        }
        res
    }
}
