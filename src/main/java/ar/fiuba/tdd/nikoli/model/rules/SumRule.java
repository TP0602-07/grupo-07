package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;
import ar.fiuba.tdd.nikoli.model.rules.sets.SumCellSet;

import java.util.List;

/**
 * Clase que representa la regla de sumar una cantidad determinada en una fila.
 */
public abstract class SumRule extends Rule {


    @Override
    public boolean isRuleBroken(List<CellSet> cellSets, Move move) {
        //TODO: implement!
        return true;
    }

    public List<CellSet> buldRuleCellSets(GameBoardIterator board) {
        //TODO: implement!
        return null;
    }

}
