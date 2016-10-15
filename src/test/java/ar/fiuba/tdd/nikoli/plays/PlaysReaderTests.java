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
    public void testReadPlaysNotFoundedRules() throws Exception {
        PlaysReader.readPlaysFromJson("notFoundedGame");
    }

}
