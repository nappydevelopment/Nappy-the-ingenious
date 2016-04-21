package nappydevelopment.nappy_the_ingenious.data;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marc on 13.04.2016.
 */
public class SaveStatisticInfos {

    public static void createAndSavePlayer(String spielerName, Game game) {
        Player player = new Player(spielerName, game.getNoOfQuestionsNappy(), game.getNoOfQuestionsPlayer(), 12345);

        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "Insert into highscores(player_name,win_mode1,win_mode2,questions_nappy,questions_player, score) values('" +
                            player.getAnzeigeName() + "', '" +
                            game.isWinNappy() + "', '" +
                            game.isWinPlayer() + "', '" +
                            player.getFragen_nappy() + "', '" +
                            player.getFragen_spieler() + "', '" +
                            player.getGesamtPunktzahl() + "');"
            );
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createAndSaveCharakter(WikiCharacter character){
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "UPDATE Simpsons SET counter = counter + 1 WHERE name='" + character.getName() + "';"
            );
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
