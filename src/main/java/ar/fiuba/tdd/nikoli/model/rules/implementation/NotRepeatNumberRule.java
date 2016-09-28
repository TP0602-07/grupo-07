package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.List;

/**
 * Clase que representa la regla de no repetir numeros en una misma linea del tablero.
 */
public class NotRepeatNumberRule extends Rule {

    @Override
    public boolean isRuleBroken(List<CellSet> cellSets, Move move) {
        // TODO implementar logica
        return false;
    }

    public List<CellSet> buldRuleCellSets(GameBoardIterator board) {
        //TODO: implement!
        return null;
    }
}
