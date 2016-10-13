package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.model.board.exception.CellNotEditableException;

/**
 * Cell base.
 */
public class Cell {

    private Integer value; // Naname (null:sin diagonal 1:diagonal derecha, 2:diagonal izquierda)
    private Position position;
    private Boolean editable;
    private Edge edge;


    public Cell(Position position) {
        this.position = position;
        this.value = null;
        this.editable = Boolean.TRUE;
        this.edge = new Edge(0,0,0,0);
    }

    public Cell(Position position, Edge edge) {
        this.position = position;
        this.value = null;
        this.editable = Boolean.TRUE;
        this.edge = edge;
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
        return (value != null && value != 0);
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

}
