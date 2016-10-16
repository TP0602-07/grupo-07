package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.exception.CellNotEditableException;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

/**
 * Created by ltessore on 10/10/16.
 */
public class CorrectCircuitRule extends Rule {

    private static Integer NO_PASSED = 1;
    private static Integer PASSED = 2;

    private Position init;
    private Position last;

    public CorrectCircuitRule() {
        this.init = null;
        this.last = null;
    }


    public void setCellAndCheckEndCircuit(GameBoard board, Position position) throws CellNotEditableException {
        if (init == position) {
            board.setIsCompleteBoard(true);
        } else {
            //si no se cierra el circuito, se marca como ultimo el ingresado
            last = position;
        }
        board.getMatrix()[position.getX()][position.getY()].setValue(PASSED);
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        if (this.init == null ) {
            init = position; //el init no se marca como se paso, se marca cuando cierra el circuito
            last = position;
            return false;
        }
        try {
            //Si es contiguo y no esta marcada el movimiento es valido
            if (last.isContiguouosHorizontalOrVertical(position)
                    && board.getMatrix()[position.getX()][position.getY()].getValue().equals(NO_PASSED)) {
                setCellAndCheckEndCircuit(board,position);
                return false;
            }
            return true;
        } catch (CellNotEditableException e) {
            return true;
        }
    }


}
