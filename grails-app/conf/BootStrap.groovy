import liquibase.util.csv.opencsv.CSVReader
import museetoulouse.Adresse
import museetoulouse.Gestionnaire
import museetoulouse.InitHibernateWithCsvDataService
import museetoulouse.Musee

class BootStrap {

    InitHibernateWithCsvDataService initHibernateWithCsvDataService

    def init = { servletContext ->
        if(Musee.count == 0)
        {
            initHibernateWithCsvDataService.serviceMethod()
        }
    }
    def destroy = {
    }


}
