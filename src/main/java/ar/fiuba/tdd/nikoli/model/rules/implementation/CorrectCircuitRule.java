package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

/**
 * Created by ltessore on 10/10/16.
 */
public class CorrectCircuitRule extends Rule {

    private Position init;
    private Position last;

    public CorrectCircuitRule(Position init) {
        this.init = init;
        this.last = init;
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        //TODO cuando este implementada la celda, si no esta marcada el mov es valido
        if (last.isContiguouosHorizontalOrVertical(position) /*&& !board.getCell().isMarked()*/) {
            if (init == position) {
                //se cerro el circuito
                return false;
            } else {
                //si no se cierra el circuito se marca como ultimo el ingresado
                last = position;
            }
        } else {
            return true;
        }
        return false;
    }
}
