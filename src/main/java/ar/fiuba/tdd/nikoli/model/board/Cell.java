package ar.fiuba.tdd.nikoli.model.board;

import java.util.Hashtable;
import java.util.Map;

/**
 * Clase para el modelado de una celda del tablero.
 */
public class Cell {
    private static final int UNASSIGNED_VALUE = 0;
    private Position position;
    private Map<CellValue, Integer> values;

    public Cell(Position position, Integer value, Integer columnValue, Integer rowValue) {
        this.position = position;
        values = new Hashtable<CellValue, Integer>();
        values.put(CellValue.Cell, value);
        values.put(CellValue.Column, columnValue);
        values.put(CellValue.Row, rowValue);
    }

    public Position getPosition() {
        return position;
    }

    public int getValue(CellValue cellValue) {
        return values.get(cellValue);
    }

    public boolean hasValue(CellValue cellValue) {
        return values.get(cellValue) == UNASSIGNED_VALUE;
    }
}
