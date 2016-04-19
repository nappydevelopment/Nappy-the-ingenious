package nappydevelopment.nappy_the_ingenious.test.util;

import nappydevelopment.nappy_the_ingenious.data.DatabaseProvider;
import nappydevelopment.nappy_the_ingenious.data.Player;
import nappydevelopment.nappy_the_ingenious.data.StatisticCharacter;
import nappydevelopment.nappy_the_ingenious.util.statistics.StatisticStuffGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Marc on 18.04.2016.
 */
public class StatisticStuffGeneratorTest {

    ArrayList<Player> playerList;
    ArrayList<StatisticCharacter> charList;
    StatisticStuffGenerator gen;

    @Before
    public void setUp() throws Exception {
    gen = new StatisticStuffGenerator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetTopFivePlayers() throws Exception {
        playerList = gen.getTopFivePlayers();
    }

    @Test
    public void testGetTopFivePlayedCharacters() throws Exception {
        charList = gen.getTopFivePlayedCharacters();
    }
}