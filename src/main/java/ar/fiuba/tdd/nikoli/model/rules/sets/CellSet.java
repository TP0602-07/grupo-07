package ar.fiuba.tdd.nikoli.model.rules.sets;

import ar.fiuba.tdd.nikoli.model.board.Cell;

import java.util.List;

/**
 * Encapsulate specific collection of cells.
 */
public class CellSet {

    private List<Cell> cells;

    public CellSet(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return this.cells;
    }
}
