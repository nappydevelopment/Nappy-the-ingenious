package nappydevelopment.nappy_the_ingenious.util.statistics;

import com.sun.xml.internal.bind.v2.TODO;
import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.Player;
import nappydevelopment.nappy_the_ingenious.data.StatisticCharacter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Marc on 05.04.2016.
 */
public class StatisticStuffGenerator {

    public ArrayList<Player> getTopFivePlayers() {
        ArrayList<Player> topFiveList = new ArrayList<Player>();
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "SELECT player_name, questions_nappy, questions_player, score FROM HIGHSCORES ORDER BY score DESC LIMIT 5"
            );
            ResultSet res = st.getResultSet();
            while(res.next()){
                String name = res.getString("player_name");
                System.out.print(name+ ", ");
                int nappy_fragen = res.getInt("questions_nappy");
                int spieler_fragen = res.getInt("questions_player");
                double punktzahl = res.getDouble("score");
                topFiveList.add(new Player(name, nappy_fragen, spieler_fragen, punktzahl));
            }
            res.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.print("\n");
        return topFiveList;
    }

    public ArrayList<StatisticCharacter> getTopFivePlayedCharacters(){
        ArrayList<StatisticCharacter> topFiveList = new ArrayList<StatisticCharacter>();
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "SELECT name, counter FROM SIMPSONS ORDER BY counter DESC LIMIT 5"
            );
            ResultSet res = st.getResultSet();
            while(res.next()){
                String name = res.getString("name");
                int counter = res.getInt("counter");
                topFiveList.add(new StatisticCharacter(name, counter));
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
