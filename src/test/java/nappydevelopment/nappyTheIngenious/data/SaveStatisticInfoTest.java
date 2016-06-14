package nappydevelopment.nappyTheIngenious.data;

import nappydevelopment.nappyTheIngenious.data.character.Character;
import nappydevelopment.nappyTheIngenious.util.statistics.StatisticStuffGenerator;
import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marc on 23.05.2016.
 */
public class SaveStatisticInfoTest {

     /*
    This Testclass ensures, that the SaveStatisticInfo writes the correct values into the database.
    The tests will fail, if something in the database for highscores gets changed. To be sure, that the tests
    are runnable all the time, the database gets resetted to set starting values
     */

    ArrayList<Player> playerList;
    ArrayList<StatisticCharacter> charList;
    StatisticStuffGenerator gen;

    @Before
    public void setUp() throws Exception {
        /*
        Reset the Database to the starting values:
        (1, 'Ali', TRUE, FALSE, 3, 15, 67.416),
        (2, 'Marvin', TRUE, FALSE, 4, 15, 67.666),
        (3, 'Manu', TRUE, FALSE, 4, 16, 63.25),
        (4, 'Marc', TRUE, FALSE, 2, 16, 63);
         */
        DatabaseProvider.resetDatabase();
    }


    @AfterClass
    public static void tearDownCompletely() throws Exception{
        //Datenbank in Ursprungszustand zurückversetzen
        DatabaseProvider.resetDatabase();
    }

    @Test
    public void createAndSavePlayerTest() throws Exception{

        Game game = new Game();

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(7);
        game.setNappyRight(Answer.YES);
        game.setPlayerRight(true);
        SaveStatisticInfos.createAndSavePlayer("4", game);

        game.setNoOfQuestionsNappy(7);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.YES);
        game.setPlayerRight(true);
        SaveStatisticInfos.createAndSavePlayer("6", game);

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.YES);
        game.setPlayerRight(true);
        SaveStatisticInfos.createAndSavePlayer("5", game);

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(7);
        game.setNappyRight(Answer.YES);
        game.setPlayerRight(false);
        SaveStatisticInfos.createAndSavePlayer("10", game);

        game.setNoOfQuestionsNappy(7);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.YES);
        game.setPlayerRight(false);
        SaveStatisticInfos.createAndSavePlayer("12", game);

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.YES);
        game.setPlayerRight(false);
        SaveStatisticInfos.createAndSavePlayer("11", game);

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(7);
        game.setNappyRight(Answer.NO);
        game.setPlayerRight(true);
        SaveStatisticInfos.createAndSavePlayer("1", game);

        game.setNoOfQuestionsNappy(7);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.NO);
        game.setPlayerRight(true);
        SaveStatisticInfos.createAndSavePlayer("3", game);

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.NO);
        game.setPlayerRight(true);
        SaveStatisticInfos.createAndSavePlayer("2", game);

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(7);
        game.setNappyRight(Answer.NO);
        game.setPlayerRight(false);
        SaveStatisticInfos.createAndSavePlayer("7", game);

        game.setNoOfQuestionsNappy(7);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.NO);
        game.setPlayerRight(false);
        SaveStatisticInfos.createAndSavePlayer("9", game);

        game.setNoOfQuestionsNappy(8);
        game.setNoOfQuestionsPlayer(8);
        game.setNappyRight(Answer.NO);
        game.setPlayerRight(false);
        SaveStatisticInfos.createAndSavePlayer("8", game);

        StringBuilder builder = new StringBuilder();
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "SELECT player_name, questions_nappy, questions_player, score FROM HIGHSCORES ORDER BY score DESC LIMIT 12"
            );
            ResultSet res = st.getResultSet();
            while(res.next()){
                String name = res.getString("player_name");
                double score = res.getDouble("score");
                builder.append(name);
                System.out.println(score);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(builder.toString());
        assertTrue(builder.toString().equals("123456789101112"));

    }

    @Test
    public void createAndSaveCharacterTest() throws Exception{
        List<Character> list;
        Character chara;
        list = CharacterProvider.getCharacters();
        chara = list.get(0);

        SaveStatisticInfos.createAndSaveCharakter(chara);
        String name = "";
        try{
            Statement st = DatabaseProvider.getStatement();
            st.execute(
                    "SELECT name, counter FROM SIMPSONS ORDER BY counter DESC LIMIT 1"
            );
            ResultSet res = st.getResultSet();
            int counter = 0;
            while(res.next()){
                name = res.getString("name");
                counter = res.getInt("counter");
            }

            assertTrue(counter == 1);

            res.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        assertTrue(chara.getName().equals(name));
    }


}
