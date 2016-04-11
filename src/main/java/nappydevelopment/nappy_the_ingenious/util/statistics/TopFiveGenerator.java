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



    public TopFiveGenerator(){


//        topFiveList.sort(new Comparator<Spieler>() {
            /* TODO
            * Comparator anhand zu ermittelnder Kriterien erweitern */
//            @Override
//            public int compare(Spieler spieler1, Spieler spieler2) {
//                if(spieler1.getGesamtPunktzahl()<spieler2.getGesamtPunktzahl()){
//                    return 0;
//                }
//                if(spieler1.getGesamtPunktzahl()>spieler2.getGesamtPunktzahl()){
//                    return 1;
//                }
//                return 0;
//            }
//        });
    }

    public ArrayList<Spieler> getTopFivePlayers() {
        ArrayList<Spieler> topFiveList = new ArrayList<Spieler>();
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                     /* TODO
                    * Select anhand zu erläuternder Kriterien erweitern */
                    "SELECT * FROM HIGHSCORES ORDER BY score DESC LIMIT 5"
            );
            ResultSet res = st.getResultSet();

            while(res.next()){
                 /* TODO
            * Nötige Dinge anhand Absprache aus dem RS auslesen */
                String name = res.getString("player_name");
                System.out.print(name+ ", ");
                int nappy_fragen = res.getInt("questions_nappy");
                int spieler_fragen = res.getInt("questions_player");
                int punktzahl = res.getInt("score");
                topFiveList.add(new Spieler(name, nappy_fragen, spieler_fragen, punktzahl));
            }
            res.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.print("\n");
        return topFiveList;
    }



}
