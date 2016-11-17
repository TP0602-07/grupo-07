package ar.fiuba.tdd.nikoli.handlers;


import ar.fiuba.tdd.nikoli.plays.PlaysListResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class NikoliJsonHandlerTests {

    private NikoliJsonHandler jsonHandler;


    
    
    @Test
    public void runGameInshiNoHeyaWin() {
        String gameName = "inshinoheya-COMPLETE-WIN";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertTrue(jsonHandler.checkVictory());

        assertEquals(25, result.getPlays().size());
    }

    @Test
    public void runGameInshiNoHeyaInvalidPlay() {
        String gameName = "inshinoheya-INCOMPLETE-INVALID";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(4, result.getPlays().size());
    }

    @Test
    public void runGameCountryRoadWin() {
        String gameName = "countryroad-COMPLETE-WIN";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertTrue(jsonHandler.checkVictory());

        assertEquals(11, result.getPlays().size());
    }

    @Test
    public void runGameCountryRoadLose() {
        String gameName = "countryroad-COMPLETE-LOSE";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(9, result.getPlays().size());
    }

    @Test
    public void runGameCountryRoadInvalidPlay() {
        String gameName = "countryroad-INCOMPLETE-INVALID";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(11, result.getPlays().size());
    }

    @Test
    public void runGameCountryRoadWinUndo() {
        String gameName = "countryroad-COMPLETE-WIN-UNDO";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertTrue(jsonHandler.checkVictory());

        assertEquals(13, result.getPlays().size());
    }

    @Test
    public void runGameNiKoli2019Win() {
        String gameName = "niKoli2019";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertTrue(jsonHandler.checkVictory());

        assertEquals(16, result.getPlays().size());
    }

    @Test
    public void runGameNiKoli2019InvalidPlayNonContiguous() {
        String gameName = "niKoli2019-NONCONTIGUOUS-LOSE";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(16, result.getPlays().size());
    }

    @Test
    public void runGameNiKoli2019InvalidPlaySumRule() {
        String gameName = "niKoli2019-SUMRULE-LOSE";
        jsonHandler = new NikoliJsonHandler();
        PlaysListResult result = jsonHandler.runGame(gameName);

        assertFalse(jsonHandler.checkVictory());

        assertEquals(16, result.getPlays().size());
    }

}
