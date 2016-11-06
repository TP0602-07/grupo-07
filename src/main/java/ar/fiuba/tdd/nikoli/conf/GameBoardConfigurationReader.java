package ar.fiuba.tdd.nikoli.conf;

import ar.fiuba.tdd.nikoli.conf.board.BoardJson;
import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.builders.GameBoardBuilder;

/**
 * Clase encargada de la lectura de configuracion del tablero de un juego.
 */
public class GameBoardConfigurationReader extends GameConfigurationReader<BoardJson,GameBoard> {

    private static final String BOARD_CONFIGURATION_TYPE = "board";


    public GameBoardConfigurationReader() {
        this.clazz = BoardJson.class;
    }


    @Override
    protected GameBoard process(BoardJson json) throws GameConfigurationException {
        return GameBoardBuilder.build(json);
    }


    @Override
    protected String getConfigurationType() {
        return BOARD_CONFIGURATION_TYPE;
    }
}
