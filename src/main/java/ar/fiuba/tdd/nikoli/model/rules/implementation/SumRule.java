package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.SumCellSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la regla de sumar una cantidad determinada en una fila.
 */
public class SumRule extends Rule {

    private List<SumCellSet> sumCellSets;

    private int sum(SumCellSet set) {
        int sum = 0;

        for (Cell cell : set.getCells()) {
            sum += cell.getValue();
        }

        return sum;
    }

    private boolean isSumIncorrect(int sum, int sumExpected) {
        return sum != sumExpected;
    }


    @Override
    public boolean isRuleBroken() {

        boolean isBroken = false;

        for (SumCellSet set : sumCellSets) {
            int sum = sum(set);

            if (isSumIncorrect(sum, set.getSum())) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }

    @Override
    public void buildRuleCellSets(GameBoardIterator board) {
        //TODO: lo agrego para que no explote por el findbugs
        sumCellSets = new ArrayList<>();
    }

}
