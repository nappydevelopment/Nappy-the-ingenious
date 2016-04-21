package nappydevelopment.nappy_the_ingenious.data;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marc on 13.04.2016.
 */
public class SaveStatisticInfos {

    public static void createAndSavePlayer(String spielerName, Game game) {
        final double baseScore = 1000/game.getNoOfQuestionsPlayer();
        final double nappyBonus = 0.25*game.getNoOfQuestionsNappy();
        final double multiplicator = nappyWin(game.isWinNappy())*2 + playerWin(game.isWinPlayer()) +1;
        final double score = (baseScore+nappyBonus)*multiplicator;


        Player player = new Player(spielerName, game.getNoOfQuestionsNappy(), game.getNoOfQuestionsPlayer(), (int)score);

        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "Insert into highscores(player_name,win_mode1,win_mode2,questions_nappy,questions_player, score) values('" +
                            player.getPlayerName() + "', '" +
                            game.isWinNappy() + "', '" +
                            game.isWinPlayer() + "', '" +
                            player.getQuestions_nappy() + "', '" +
                            player.getQuestions_player() + "', '" +
                            player.getScore() + "');"
            );
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static int nappyWin(boolean winNappy) { return boolToInt(winNappy); }

    private static int playerWin(boolean winPlayer) { return 1-boolToInt(winPlayer); }

    private static int boolToInt(boolean b) {
        if(b){
            return 1;
        }
        return 0;
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
