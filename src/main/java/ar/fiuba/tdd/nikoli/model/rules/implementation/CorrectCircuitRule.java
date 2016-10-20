package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.exception.CellNotEditableException;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

/**
 * Regla que chequea el circuito ingresado es correcto.
 */
public class CorrectCircuitRule extends Rule {

    private static Integer PASSED = 2;

    private Position init; //indica comienzo de circuito
    private Position last; //indica ultima posicion del circuito por la que se paso

    public CorrectCircuitRule() {
        this.setName("CorrectCircuitRule");
        this.init = null;
        this.last = null;
    }

    /**
     * Setea la celda como PASSED y si el circuito termino.
     * @param board tablero
     * @param position posicion a chequear
     * @throws CellNotEditableException si ya se paso por la celda
     */
    public void setCellAndCheckEndCircuit(GameBoard board, Position position) throws CellNotEditableException {
        if (init.getX() == position.getX() && init.getY() == position.getY()) {
            board.setIsCompleteBoard(true);
        } else {
            //si no se cierra el circuito, se marca como ultimo el ingresado
            last = position;
        }
        board.getMatrix()[position.getX()][position.getY()].setValue(PASSED);
        board.getMatrix()[position.getX()][position.getY()].setEditable(false);
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        try {
            if (this.init == null ) {
                init = position; //el init no se marca como se paso, se marca cuando cierra el circuito
                last = position;
                board.getMatrix()[position.getX()][position.getY()].setValue(PASSED);
                board.setIsCompleteBoard(false);
                return false;
            }
            //Si es contiguo y no esta marcada el movimiento es valido
            if (last.isContiguouosHorizontalOrVertical(position)) {
                setCellAndCheckEndCircuit(board,position);
                return false;
            }
            return true;
        } catch (CellNotEditableException e) {
            return true;
        }
    }


}
