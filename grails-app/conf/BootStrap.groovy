import liquibase.util.csv.opencsv.CSVReader
import museetoulouse.Adresse
import museetoulouse.Gestionnaire
import museetoulouse.InitHibernateWithCsvDataService
import museetoulouse.Musee

class BootStrap {

    InitHibernateWithCsvDataService init_hibernate

    def init = { servletContext ->
        if(Musee.count == 0)
        {

        }
    }
    def destroy = {
    }


}
