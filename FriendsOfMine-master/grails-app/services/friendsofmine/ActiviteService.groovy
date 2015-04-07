package friendsofmine

import org.springframework.transaction.annotation.Transactional


@Transactional
class ActiviteService {

    /**
     * Cree une nouvelle activite
     * @param unResponsable le responsable de l'activité
     * @param unTitre le titre
     * @param unDescriptif le descriptif
     * @return l'activité créée
     */
    Activite insertOrUpdateActiviteForResponsable(Activite uneActivite, Utilisateur unResponsable) {
        unResponsable.addToActivites(uneActivite)
        // note
        // le flush: true n'est pas nécessaire pour que le test d'intégration passe mais est
        // nécessaire pour que l'appel venant du contrôleur fonctionne comme attendu
        unResponsable.save(flush: true)
        uneActivite
    }

    /**
     * Supprime une activité
     * @param uneActivite l'activite à supprimer
     */
    void deleteActivite(Activite uneActivite) {
        uneActivite.responsable.removeFromActivites(uneActivite)
        uneActivite.delete()
    }
}
