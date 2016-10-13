package ar.fiuba.tdd.nikoli.conf;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationNotFoundException;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameConfigurationReaderTests {

    @Test
    public void testReadGameRulesOK() throws Exception {
        GameRulesConfigurationReader configReader = new GameRulesConfigurationReader();
        GameRules rules = configReader.readConfiguration("testGame");
        assertNotNull(rules);
    }

    @Test(expected = GameConfigurationNotFoundException.class)
    public void testReadGameRulesNotFoundedRules() throws Exception {
        GameRulesConfigurationReader configReader = new GameRulesConfigurationReader();
        configReader.readConfiguration("notFoundedGame");
    }

    @Test
    public void testReadGameBoardOK() throws Exception {
        GameBoardConfigurationReader configReader = new GameBoardConfigurationReader();
        GameBoard board = configReader.readConfiguration("testGame");
        assertNotNull(board);
    }

    @Test(expected = GameConfigurationNotFoundException.class)
    public void testReadGameBoardNotFoundedRules() throws Exception {
        GameConfigurationReader configReader = new GameBoardConfigurationReader();
        configReader.readConfiguration("notFoundedGame");
    }


}
