package ar.fiuba.tdd.nikoli.model.board;

/**
 * Clase para el modelado de una celda del tablero.
 */
public class Cell {
    private static final int BORDER_VALUE = -1;
    private Position position;
    private int value;
    private int columnValue;
    private int rowValue;

    public Cell(Position position, int value, int columnValue, int rowValue) {
        this.position = position;
        this.value = value;
        this.columnValue = columnValue;
        this.rowValue = rowValue;
    }

    public Position getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public int getColumnValue() {
        return columnValue;
    }

    public int getRowValue() {
        return rowValue;
    }

    public boolean isBorder() {
        return (value == BORDER_VALUE);
    }

    public boolean isFull() {
        return (value != 0 || columnValue != 0 || rowValue != 0);
    }
}
