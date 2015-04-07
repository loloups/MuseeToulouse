import friendsofmine.JeuTestService
import friendsofmine.Utilisateur

class BootStrap {

    JeuTestService jeuTestService

    def init = { servletContext ->

        jeuTestService.createJeuTestForUtilisateurs()
        jeuTestService.createJeuTestFoActivite()
        jeuTestService.createJeuTestForInscription()

    }
    def destroy = {
    }
}
