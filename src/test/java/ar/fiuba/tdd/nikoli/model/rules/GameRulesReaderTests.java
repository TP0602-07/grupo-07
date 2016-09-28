package ar.fiuba.tdd.nikoli.model.rules;


import ar.fiuba.tdd.nikoli.model.rules.exception.GameRulesNotFoundException;
import ar.fiuba.tdd.nikoli.model.rules.reader.GameRulesReader;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameRulesReaderTests {

    @Test
    public void testReadGameRulesOK() throws Exception {
        GameRules rules = GameRulesReader.getInstance().readGameRules("testGame");
        assertNotNull(rules);
    }

    @Test(expected = GameRulesNotFoundException.class)
    public void testReadGameRulesNotFoundedRules() throws Exception {
        GameRulesReader.getInstance().readGameRules("notFoundedGame");
    }


}
