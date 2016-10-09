package ar.fiuba.tdd.nikoli.conf.exception;

/**
 * Exception que representa la falta del archivo de configuracion de un juego.
 */
public class GameConfigurationNotFoundException extends GameConfigurationException {

    public GameConfigurationNotFoundException(String gameName, String configurationType) {
        super(configurationType + " configuration file not found for game " + gameName);
    }
}
