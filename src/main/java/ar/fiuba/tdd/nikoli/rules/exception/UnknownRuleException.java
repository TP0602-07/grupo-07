package ar.fiuba.tdd.nikoli.rules.exception;

/**
 * Exception que representa la falta de conocimiento de una regla de un juego.
 */
public class UnknownRuleException extends Exception {

    public UnknownRuleException(String message) {
        super(message);
    }
}
