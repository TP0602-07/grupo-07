package ar.fiuba.tdd.nikoli.model.rules.sets;

import ar.fiuba.tdd.nikoli.model.board.OldCell;

import java.util.List;

/**
 * Encapsulate cells used by Summary Rule.
 */
public class SumCellSet
        extends CellSet {

    private int sum;

    public SumCellSet(int sum, List<OldCell> cells) {
        super(cells);
        this.sum = sum;
    }

    public int getSum() {
        return this.sum;
    }
}
