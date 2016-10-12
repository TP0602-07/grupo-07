package ar.fiuba.tdd.nikoli.conf;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;

/**
 * Clase encargada de la lectura de configuracion del tablero de un juego.
 */
public class GameBoardConfigurationReader extends GameConfigurationReader<GameBoard> {

    private static final String BOARD_CONFIGURATION_TYPE = "board";


    public GameBoardConfigurationReader() {
        this.clazz = GameBoard.class;
    }


    @Override
    protected void process(GameBoard gameBoard) throws GameConfigurationException {
        gameBoard.buildMatrix();
        gameBoard.buildClueCells();
    }


    @Override
    protected String getConfigurationType() {
        return BOARD_CONFIGURATION_TYPE;
    }
}