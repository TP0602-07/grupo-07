package ar.fiuba.tdd.nikoli.model.board.exception;

/**
 * Excepcion que es lanzada cuando se inserta un valor en una celda no editable.
 */
public class CellNotEditableException extends Exception {
    public CellNotEditableException() {
        super("Cell is not editable!");
    }
}
