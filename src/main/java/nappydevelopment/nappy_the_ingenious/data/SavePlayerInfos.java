package nappydevelopment.nappy_the_ingenious.data;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marc on 13.04.2016.
 */
public class SavePlayerInfos {

    public static void createAndSavePlayer(String spielerName, boolean win_mode1, boolean win_mode2, int askedQuestions) {
        Player player = new Player(spielerName, askedQuestions, 20, 12345);

        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "Insert into highscores(player_name,win_mode1,win_mode2,questions_nappy,questions_player, score) values('" +
                            player.getAnzeigeName() + "', '" +
                            win_mode1 + "', '" +
                            win_mode2 + "', '" +
                            player.getFragen_nappy() + "', '" +
                            player.getFragen_spieler() + "', '" +
                            player.getGesamtPunktzahl() + "');"
            );
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
