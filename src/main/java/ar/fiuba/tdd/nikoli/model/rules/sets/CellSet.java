package ar.fiuba.tdd.nikoli.model.rules.sets;

import ar.fiuba.tdd.nikoli.model.board.OldCell;

import java.util.List;

/**
 * Encapsulate specific collection of cells.
 */
public class CellSet {

    private List<OldCell> cells;

    public CellSet(List<OldCell> cells) {
        this.cells = cells;
    }

    public List<OldCell> getCells() {
        return this.cells;
    }
}
