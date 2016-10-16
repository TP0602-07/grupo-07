package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.List;

/**
 * Clase que representa la regla de sumar una cantidad determinada para un conjunto de celdas pertenecientes a una region.
 */
public class SumRule extends Rule {

    private int sum(Region region, GameBoard board) {
        int sum = 0;

        for (Position position : region.getPositions()) {

            Integer value = board.getValueForPosition(position);

            if (value != null) {
                sum += board.getValueForPosition(position);
            }
        }

        return sum;
    }

    private boolean isSumIncorrect(int sum, int sumExpected, boolean isRegionFull) {
        boolean isIncorrect;

        if (isRegionFull) {
            isIncorrect = sum != sumExpected;
        } else {
            isIncorrect = sum >= sumExpected;
        }

        return isIncorrect;
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {

        List<Region> regions = board.getRegionsForPosicion(position);

        boolean isBroken = false;

        for (Region region : regions) {
            int sum = sum(region, board);

            boolean isRegionFull = region.isRegionFull(board);

            if (isSumIncorrect(sum, region.getValue(), isRegionFull)) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }

}
