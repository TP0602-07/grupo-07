package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.List;

/**
 * Clase que representa la regla de no repetir numeros en una misma columna del tablero.
 */
public class ColumnNotRepeatNumberRule extends Rule {

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
