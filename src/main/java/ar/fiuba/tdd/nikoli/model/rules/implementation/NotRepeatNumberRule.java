package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase que representa la regla de no repetir numeros para un conjunto de celdas pertenecientes a una region.
 */
public class NotRepeatNumberRule extends Rule {

    private boolean areThereRepeated(Region region) {

        boolean thereAreRepeated = false;

        Set<Integer> hashSet = new HashSet<>();

        for (Cell cell : region.getCells()) {

            int value = cell.getValue();

            if (hashSet.contains(value)) {
                thereAreRepeated = true;
                break;
            } else {
                hashSet.add(value);
            }
        }

        return thereAreRepeated;
    }

    @Override
    public boolean isRuleBroken(List<Region> regions) {
        boolean isBroken = false;

        for (Region region : regions) {

            if (areThereRepeated(region)) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }
}
