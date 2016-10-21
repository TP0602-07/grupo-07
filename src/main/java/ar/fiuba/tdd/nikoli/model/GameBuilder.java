package ar.fiuba.tdd.nikoli.model;

import ar.fiuba.tdd.nikoli.conf.GameBoardConfigurationReader;
import ar.fiuba.tdd.nikoli.conf.GameRulesConfigurationReader;
import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;

/**
 * Clase con metodos encargados de la construccion de los juegos.
 */
public class GameBuilder {

    private static GameRulesConfigurationReader rulesReader = new GameRulesConfigurationReader();
    private static GameBoardConfigurationReader boardReader = new GameBoardConfigurationReader();


    /**
     * Construye una instancia de un juego a partir de su nombre.
     * @param gameName nombre del juego.
     * @return una instancia de {@link Game}.
     * @throws GameConfigurationException si se produjo un problema en la configuracion del juego.
     */
    public static Game buildGame(String gameName) throws GameConfigurationException {
        GameRules rules = rulesReader.readConfiguration(gameName);
        GameBoard board = boardReader.readConfiguration(gameName);
        return new Game(rules, board);
    }
}
