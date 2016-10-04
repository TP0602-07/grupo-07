package ar.fiuba.tdd.nikoli.model.board;

/**
 * Cell base.
 */
public class Cell {

    private Integer value;
    private Position position;
    private boolean editable;

    public Cell(Position position, Integer value, boolean editable) {
        this.position = position;
        this.value = value;
        this.editable = editable;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isEditable() {
        return editable;
    }

}
