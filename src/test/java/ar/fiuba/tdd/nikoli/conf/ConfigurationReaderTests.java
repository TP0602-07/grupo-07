package ar.fiuba.tdd.nikoli.conf;


import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationNotFoundException;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConfigurationReaderTests {

    @Test
    public void testReadGameRulesOK() throws Exception {
        ConfigurationReader configReader = new ConfigurationReader();
        GameRules rules = configReader.readGameRulesConfiguration("testGame");
        assertNotNull(rules);
    }

    @Test(expected = GameConfigurationNotFoundException.class)
    public void testReadGameRulesNotFoundedRules() throws Exception {
        ConfigurationReader configReader = new ConfigurationReader();
        configReader.readGameRulesConfiguration("notFoundedGame");
    }

    @Test
    public void testReadGameBoardOK() throws Exception {
        ConfigurationReader configReader = new ConfigurationReader();
        GameBoard board = configReader.readGameBoardConfiguration("sudoku");
        assertNotNull(board);
    }

    @Test(expected = GameConfigurationNotFoundException.class)
    public void testReadGameBoardNotFoundedRules() throws Exception {
        ConfigurationReader configReader = new ConfigurationReader();
        configReader.readGameBoardConfiguration("notFoundedGame");
    }


}
