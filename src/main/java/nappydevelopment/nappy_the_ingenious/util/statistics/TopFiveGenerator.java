package nappydevelopment.nappy_the_ingenious.util.statistics;

import com.sun.xml.internal.bind.v2.TODO;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.Spieler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Marc on 05.04.2016.
 */
public class TopFiveGenerator {

    ArrayList<Spieler> topFiveList = new ArrayList<Spieler>();

    public TopFiveGenerator(){
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                     /* TODO
                    * Select anhand zu erläuternder Kriterien erweitern */
                    "SELECT spieler_name, gesamtpunktzahl FROM SPIELER_HIGHSCORE ORDER BY gesamtpunktzahl LIMIT 5"
            );
            ResultSet res = st.getResultSet();

            while(res.next()){
                 /* TODO
            * Nötige Dinge anhand Absprache aus dem RS auslesen */
                String name = res.getString("spieler_name");
                int punktzahl = res.getInt("gesamtpunktzahl");
                topFiveList.add(new Spieler(name, punktzahl));
            }
            res.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        topFiveList.sort(new Comparator<Spieler>() {
            /* TODO
            * Comparator anhand zu ermittelnder Kriterien erweitern */
            @Override
            public int compare(Spieler spieler1, Spieler spieler2) {
                if(spieler1.getGesamtpunktzahl()<spieler2.getGesamtpunktzahl()){
                    return 0;
                }
                if(spieler1.getGesamtpunktzahl()>spieler2.getGesamtpunktzahl()){
                    return 1;
                }
                return 0;
            }
        });
    }

    public ArrayList<Spieler> getTopFiveList() {
        return topFiveList;
    }

}
