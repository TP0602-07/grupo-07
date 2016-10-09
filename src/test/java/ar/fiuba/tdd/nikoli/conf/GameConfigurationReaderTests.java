package ar.fiuba.tdd.nikoli.conf;


import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationNotFoundException;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameConfigurationReaderTests {

    @Test
    public void testReadGameRulesOK() throws Exception {
        GameConfigurationReader configReader = new GameConfigurationReader();
        GameRules rules = configReader.readGameRulesConfiguration("testGame");
        assertNotNull(rules);
    }

    @Test(expected = GameConfigurationNotFoundException.class)
    public void testReadGameRulesNotFoundedRules() throws Exception {
        GameConfigurationReader configReader = new GameConfigurationReader();
        configReader.readGameRulesConfiguration("notFoundedGame");
    }

    @Test
    public void testReadGameBoardOK() throws Exception {
        GameConfigurationReader configReader = new GameConfigurationReader();
        GameBoard board = configReader.readGameBoardConfiguration("testGame");
        assertNotNull(board);
    }

    @Test(expected = GameConfigurationNotFoundException.class)
    public void testReadGameBoardNotFoundedRules() throws Exception {
        GameConfigurationReader configReader = new GameConfigurationReader();
        configReader.readGameBoardConfiguration("notFoundedGame");
    }


}
