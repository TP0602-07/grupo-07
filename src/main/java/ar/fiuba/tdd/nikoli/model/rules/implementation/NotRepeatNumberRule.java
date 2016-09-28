package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase que representa la regla de no repetir numeros en una misma linea del tablero.
 */
public class NotRepeatNumberRule extends Rule {

    private List<CellSet> cellSets;

    private boolean areThereRepeated(CellSet set) {

        boolean thereAreRepeated = false;

        Set<Integer> hashSet = new HashSet<>();

        for (Cell cell : set.getCells()) {

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
    public boolean isRuleBroken() {

        boolean isBroken = false;

        for (CellSet set : cellSets) {

            if (areThereRepeated(set)) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }


    @Override
    public void buildRuleCellSets(GameBoardIterator board) {
        //TODO: lo agrego para que no explote por el findbugs
        cellSets = new ArrayList<>();
    }
}
