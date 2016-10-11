package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase que representa la regla de no repetir numeros para un conjunto de celdas pertenecientes a una region.
 */
public class NotRepeatNumberRule extends Rule {

    private boolean areThereRepeated(Region region, GameBoard board) {

        boolean thereAreRepeated = false;

        Set<Integer> hashSet = new HashSet<>();

        for (Position position : region.getPositions()) {

            Integer value = board.getValueForPosition(position);

            if (value != null) {
                if (hashSet.contains(value)) {
                    thereAreRepeated = true;
                    break;
                } else {
                    hashSet.add(value);
                }
            }
        }

        return thereAreRepeated;
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {

        List<Region> regions = board.getRegionsForPosicion(position);

        boolean isBroken = false;

        for (Region region : regions) {

            if (areThereRepeated(region, board)) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }
}
