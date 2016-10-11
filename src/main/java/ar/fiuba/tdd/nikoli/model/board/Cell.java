package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.model.board.exception.CellNotEditableException;

/**
 * Cell base.
 */
public class Cell {

    private Integer value;
    private Position position;
    private Boolean editable;


    public Cell(Position position) {
        this.position = position;
        this.value = null;
        this.editable = Boolean.TRUE;
    }

    public Cell(Position position, Integer value, boolean editable) {
        this.position = position;
        this.value = value;
        this.editable = editable;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) throws CellNotEditableException {
        if (this.editable) {
            this.value = value;
        } else {
            throw new CellNotEditableException();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public Boolean isEditable() {
        return this.editable;
    }

    public boolean hasValue() {
        return value != null;
    }

}
