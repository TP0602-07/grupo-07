package ar.fiuba.tdd.nikoli.rules;

import ar.fiuba.tdd.nikoli.model.board.Cell;

/**
 * Clase que modela la regla de sumar una cantidad determina para una columna
 */
public class ColumnSumRule extends SumRule {

    @Override
    protected Cell getPreviousCell(IGameBoardIterator gameBoardIterator, Cell cell) {
        return gameBoardIterator.getCellTop(cell);
    }

    @Override
    protected int getSumExpected(Cell cell) {
        return cell.getColumnValue();
    }

    @Override
    protected boolean hasNext(IGameBoardIterator gameBoardIterator, Cell cell) {
        return gameBoardIterator.hasCellBottom(cell);
    }

    @Override
    protected Cell getNextCell(IGameBoardIterator gameBoardIterator, Cell cell) {
        return gameBoardIterator.getCellBottom(cell);
    }
}

