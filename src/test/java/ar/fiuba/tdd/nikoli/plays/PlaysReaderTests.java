package ar.fiuba.tdd.nikoli.plays;

import ar.fiuba.tdd.nikoli.utils.JsonFileNotFoundException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PlaysReaderTests {

    @Test
    public void testReadPlaysOK() throws Exception {
        PlaysList playsList = PlaysReader.readPlaysFromJson("testGame");
        assertNotNull(playsList);
        assertNotNull(playsList.getPlays());
        assertEquals(4, playsList.getPlays().size());
    }

    @Test(expected = JsonFileNotFoundException.class)
    public void testReadPlaysNotFound() throws Exception {
        PlaysReader.readPlaysFromJson("notFoundedGame");
    }

    @Test
    public void testWritePlaysResultOK() throws Exception {
        PlaysListResult playsResult = new PlaysListResult();

        PlayResult result1 = new PlayResult();
        result1.setNumber(1);
        result1.setBoardStatus(PlayResult.BOARD_STATUS_VALID);
        playsResult.getPlays().add(result1);

        PlayResult result2 = new PlayResult();
        result2.setNumber(2);
        result2.setBoardStatus(PlayResult.BOARD_STATUS_INVALID);
        playsResult.getPlays().add(result2);

        PlaysReader.writePlaysResult("testGame", playsResult);
    }

}
