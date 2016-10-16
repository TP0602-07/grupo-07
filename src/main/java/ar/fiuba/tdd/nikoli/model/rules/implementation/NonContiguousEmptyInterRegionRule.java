package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

/**
 * Regla que chequea que no hay celdas contiguas sin visitar que pertenezcan a distintas regiones.
 */
public class NonContiguousEmptyInterRegionRule extends Rule{

    private static Integer NO_PASSED = 1; //TODO unir con el de passedRegionRule

    private Cell lastCellNoPassed;

    public NonContiguousEmptyInterRegionRule() {
        lastCellNoPassed = null;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public boolean isNotValid(GameBoard board, Cell cell) {
        if (cell.getValue().equals(NO_PASSED) && lastCellNoPassed == null) {
            this.lastCellNoPassed = cell;
        } else if (cell.getValue().equals(NO_PASSED) && lastCellNoPassed != null) {
            Region regionCell = board.getRegions().get(0);
            Region regionLastCellNoPassed = board.getRegions().get(0);
            if (regionCell != regionLastCellNoPassed) {
                return true;
            }
        } else {
            this.lastCellNoPassed = null;
        }
        return false;
    }

    public boolean isControlOk(GameBoard board, int index1, int index2, boolean isRowsControl) {
        for (int i = 0; i < index1; i++) {
            for (int j = 0; j < index2; j++) {
                Cell cell;
                if (isRowsControl) {
                    cell = board.getMatrix()[i][j];
                } else {
                    cell = board.getMatrix()[j][i];
                }
                if ( isNotValid(board, cell)) {
                    return true;
                }
            }
        }
        this.lastCellNoPassed = null;
        return false;
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        if (board.isCompleteBoard()) {
            int indexRows = board.getRows();
            int indexCols = board.getColumns();
            if (isControlOk(board, indexRows, indexCols, true)
                    || isControlOk(board, indexCols, indexRows, false)) {
                return true;
            }
        }
        return false;
    }
}
