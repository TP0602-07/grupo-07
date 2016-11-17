package ar.fiuba.tdd.nikoli.handlers;

import ar.fiuba.tdd.nikoli.plays.PlaysListResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NikoliJsonHandlerTests {

    private NikoliJsonHandler jsonHandler;

    @Before
    public void setUp() {
        jsonHandler = new NikoliJsonHandler();
    }
    
    
    @Test
    public void runGameInshiNoHeyaWin() {
        String gameName = "inshinoheya-COMPLETE-WIN";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertTrue(jsonHandler.checkVictory());

        assertEquals(25, result.getPlays().size());
    }

    @Test
    public void runGameInshiNoHeyaInvalidPlay() {
        String gameName = "inshinoheya-INCOMPLETE-INVALID";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(4, result.getPlays().size());
    }

    @Test
    public void runGameCountryRoadWin() {
        String gameName = "countryroad-COMPLETE-WIN";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertTrue(jsonHandler.checkVictory());

        assertEquals(11, result.getPlays().size());
    }

    @Test
    public void runGameCountryRoadLose() {
        String gameName = "countryroad-COMPLETE-LOSE";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(9, result.getPlays().size());
    }

    @Test
    public void runGameCountryRoadInvalidPlay() {
        String gameName = "countryroad-INCOMPLETE-INVALID";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(11, result.getPlays().size());
    }

    @Test
    public void runGameNiKoli2019Win() {
        String gameName = "niKoli2019";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertTrue(jsonHandler.checkVictory());

        assertEquals(16, result.getPlays().size());
    }

    @Test
    public void runGameNiKoli2019InvalidPlayNonContiguous() {
        String gameName = "niKoli2019-NONCONTIGUOUS-LOSE";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(16, result.getPlays().size());
    }

    @Test
    public void runGameNiKoli2019InvalidPlaySumRule() {
        String gameName = "niKoli2019-SUMRULE-LOSE";

        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(16, result.getPlays().size());
    }
}
