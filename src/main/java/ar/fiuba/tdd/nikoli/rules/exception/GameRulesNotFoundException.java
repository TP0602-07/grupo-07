package ar.fiuba.tdd.nikoli.rules.exception;

/**
 * Exception que representa la falta del archivo de reglas de un juego
 */
public class GameRulesNotFoundException extends Exception {

    public GameRulesNotFoundException(String message) {
        super(message);
    }
}
