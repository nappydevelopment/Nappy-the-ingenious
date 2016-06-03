package nappydevelopment.nappyTheIngenious.data;

import nappydevelopment.nappyTheIngenious.util.statistics.StatisticStuffGenerator;
import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    }

    @Test
    public void createAndSaveCharacterTest() throws Exception{

    }


}
