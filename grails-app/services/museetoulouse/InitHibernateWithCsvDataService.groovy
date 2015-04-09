package museetoulouse

import grails.transaction.Transactional
import liquibase.util.csv.opencsv.CSVReader
import net.sf.ehcache.hibernate.HibernateUtil
import org.hibernate.Hibernate
import org.hibernate.Session

@Transactional
class InitHibernateWithCsvDataService {

    def serviceMethod() {



        String strfile = "C:\\Users\\Julien\\Documents\\ProjectJEE\\Musee.csv";
        CSVReader reader = new CSVReader(new FileReader(strfile));
        ArrayList<String> tab_col;


        String[] line;
        String[] column;
        line =reader.readNext();
        String strline;
        while((line =reader.readNext()) != null) {
            strline = "";
            for (int i = 0; i < line.length; i++) {
                strline += line[i];

            }
            column = strline.split(";");

            Musee musee = new Musee()
            musee.setNom(column[0])
            musee.setHorairesOuverture(column[2])
            musee.setTelephone(column[4])
            musee.setAccesMetro(column[5])
            musee.setAccesBus(column[6])
            Gestionnaire gestionnaire = new Gestionnaire()
            gestionnaire.setNom(column[1])
            musee.setResponsable(gestionnaire)
            Adresse adresse = new Adresse()
            adresse.setNumero(column[7])
            adresse.setRue(column[8])
            adresse.setCodePostal(Integer.parseInt(column[9]))
            adresse.setVille(column[10])
            musee.setAdresse(adresse)

            gestionnaire.save()
            adresse.save()
            musee.save()
        }



    }
}
