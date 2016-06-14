package nappydevelopment.nappyTheIngenious.data;

import nappydevelopment.nappyTheIngenious.data.character.Character;

import java.sql.SQLException;
import java.sql.Statement;

public class SaveStatisticInfos {

    public static void createAndSavePlayer(String spielerName, Game game) {
        final double baseScore = 100000.0 / (game.getNoOfQuestionsPlayer()+6);
        final double nappyBonus = 0.25 * game.getNoOfQuestionsNappy();
        final double multiplicator = playerWin(game.isWinPlayer())*2 + nappyWin(game.isWinNappy()) + 1.0;
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
            st.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static int nappyWin(boolean winNappy) { return 1-boolToInt(winNappy); }

    private static int playerWin(boolean winPlayer) { return boolToInt(winPlayer); }

    private static int boolToInt(boolean b) {
        if(b){
            return 1;
        }
        return 0;
    }


    public static void createAndSaveCharakter(Character character){
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "UPDATE Simpsons SET counter = counter + 1 WHERE name='" + character.getName() + "';"
            );
            st.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
