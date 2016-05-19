package nappydevelopment.nappyTheIngenious.util;

import nappydevelopment.nappyTheIngenious.data.DatabaseProvider;
import nappydevelopment.nappyTheIngenious.data.Player;
import nappydevelopment.nappyTheIngenious.data.StatisticCharacter;
import nappydevelopment.nappyTheIngenious.util.statistics.StatisticStuffGenerator;
import org.hamcrest.core.Is;
import org.junit.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StatisticStuffGeneratorTest {

    /*
    This Testclass ensures, that the StatisticStuffGenerator gets the correct Values from our database.
    The tests will fail, if something in the database for highscores gets changed. To be sure, that the tests
    are runnable all the time, the database gets resetted to set starting values
     */

    ArrayList<Player> playerList;
    ArrayList<StatisticCharacter> charList;
    StatisticStuffGenerator gen;

    @Before
    public void setUp() throws Exception {
        gen = new StatisticStuffGenerator();
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
    public void testGetTopFivePlayersEverythingCorrect() throws Exception {
        playerList = gen.getTopFivePlayers();
        assertFalse(playerList.isEmpty());
        assertThat(playerList.get(0).getPlayerName(), Is.is("Marvin"));
        assertThat(playerList.get(3).getPlayerName(), Is.is("Marc"));
        assertThat(playerList.get(2).getQuestions_nappy(), Is.is(4));
        assertEquals(63.25, playerList.get(2).getScore(), 0.001);
    }

    @Test
    public void testGetTopFivePlayersCatchingNull() throws Exception {
        playerList = gen.getTopFivePlayers();
        assertNotNull(playerList);
        assertTrue(!playerList.isEmpty());
        assertThat(playerList.get(2).getQuestions_player(), Is.is(16));
    }

    @Test
    public void testGetTopFivePlayedCharacters() throws Exception {
        charList = gen.getTopFivePlayedCharacters();
        assertEquals(5, charList.size());
        assertNotNull(charList);
        assertFalse(charList.isEmpty());
        for (StatisticCharacter each: charList
             ) {
            assertTrue(each.getAmount()==0);
        }
    }
}