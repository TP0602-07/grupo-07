package ar.fiuba.tdd.nikoli.rules;

import ar.fiuba.tdd.nikoli.model.board.Cell;

/**
 * Clase que modela la regla de sumar una cantidad determina para una fila
 */
public class RowSumRule extends SumRule {

    @Override
    protected Cell getPreviousCell(IGameBoardIterator gameBoardIterator, Cell cell) {
        return gameBoardIterator.getCellLeft(cell);
    }

    @Override
    protected int getSumExpected(Cell cell) {
        return cell.getRowValue();
    }

    @Override
    protected boolean hasNext(IGameBoardIterator gameBoardIterator, Cell cell) {
        return gameBoardIterator.hasCellRight(cell);
    }

    @Override
    protected Cell getNextCell(IGameBoardIterator gameBoardIterator, Cell cell) {
        return gameBoardIterator.getCellRight(cell);
    }
}
