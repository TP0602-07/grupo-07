package ar.fiuba.tdd.nikoli.utils;

/**
 * Excepcion utilizada cuando no se encuentra un archivo JSON en resources.
 */
public class JsonFileNotFoundException extends Exception {

    public JsonFileNotFoundException(String message) {
        super(message);
    }
}
