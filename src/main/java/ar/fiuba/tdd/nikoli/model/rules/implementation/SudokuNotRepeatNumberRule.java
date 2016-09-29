package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

/**
 * Rule for Sudoku not repeated numbers validation.
 */
public class SudokuNotRepeatNumberRule extends Rule<CellSet> {

    public SudokuNotRepeatNumberRule() {
        super(new SudokuSetBuilder(), new NotRepeatNumberRule());
    }
}
