package ar.fiuba.tdd.nikoli.utils;

/**
 * Excepcion utilizada cuando no se puede crear un archivo JSON.
 */
public class JsonFileCanNotBeCreatedException extends Exception {

    public JsonFileCanNotBeCreatedException(String message) {
        super(message);
    }
}
