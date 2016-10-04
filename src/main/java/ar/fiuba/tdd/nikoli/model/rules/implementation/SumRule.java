package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.OldCell;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.RuleValidator;
import ar.fiuba.tdd.nikoli.model.rules.SetBuilder;
import ar.fiuba.tdd.nikoli.model.rules.sets.*;

/**
 * Clase que representa la regla de sumar una cantidad determinada en una fila.
 */
public class SumRule implements RuleValidator<SumCellSet> {

    private int sum(SumCellSet set) {
        int sum = 0;

        for (OldCell cell : set.getCells()) {
            sum += cell.getValue(CellValue.Cell);
        }

        return sum;
    }

    private boolean isSumIncorrect(int sum, int sumExpected) {
        return sum != sumExpected;
    }

    @Override
    public boolean isRuleBroken(SetBuilder<? extends SumCellSet> setSetBuilder, GameBoardIterator board) {

        boolean isBroken = false;

        for (SumCellSet set : setSetBuilder.buildRuleCellSets(board)) {
            int sum = sum(set);

            if (isSumIncorrect(sum, set.getSum())) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }
}
