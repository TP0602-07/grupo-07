package ar.fiuba.tdd.nikoli.conf.exception;

/**
 * Excepcion que representa un error en el procesamiento de configuracion de los juegos.
 */
public class GameConfigurationException extends Exception {

    public GameConfigurationException(String message) {
        super(message);
    }
}
