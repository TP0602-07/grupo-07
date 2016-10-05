package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.List;

/**
 * Clase que representa la regla de sumar una cantidad determinada para un conjunto de celdas pertenecientes a una region.
 */
public class SumRule extends Rule {

    private int sum(Region region) {
        int sum = 0;

        for (Cell cell : region.getCells()) {
            sum += cell.getValue();
        }

        return sum;
    }

    private boolean isSumIncorrect(int sum, int sumExpected) {
        return sum != sumExpected;
    }

    @Override
    public boolean isRuleBroken(List<Region> regions) {

        boolean isBroken = false;

        for (Region region : regions) {
            int sum = sum(region);

            if (isSumIncorrect(sum, region.getValue())) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }
}
