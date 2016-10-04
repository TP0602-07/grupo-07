package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.OldCell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.RuleValidator;
import ar.fiuba.tdd.nikoli.model.rules.SetBuilder;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa la regla de no repetir numeros en una misma linea del tablero.
 */
public class NotRepeatNumberRule implements RuleValidator<CellSet> {

    private boolean areThereRepeated(CellSet set) {

        boolean thereAreRepeated = false;

        Set<Integer> hashSet = new HashSet<>();

        for (OldCell cell : set.getCells()) {

            int value = cell.getValue(CellValue.Cell);

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
    public boolean isRuleBroken(SetBuilder<? extends CellSet> setSetBuilder, GameBoardIterator board) {

        boolean isBroken = false;

        for (CellSet set : setSetBuilder.buildRuleCellSets(board)) {

            if (areThereRepeated(set)) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }



}
