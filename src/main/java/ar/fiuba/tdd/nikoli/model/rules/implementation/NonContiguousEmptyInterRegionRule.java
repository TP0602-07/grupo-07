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

    private static Integer NO_PASSED = 1;

    private Cell lastCellNoPassed; //indica si la celda anterior no esta como PASSED

    public NonContiguousEmptyInterRegionRule() {
        this.setName("NonContiguousEmptyInterRegionRule");
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

    /**
     * Compara celda con unna contigua, y chequea que si estan las dos sin marcar
     * pertenezcan a la misma region.
     * @param board tablero
     * @param cell celda a controlar
     * @return boolean true si no es valido, false caso contrario
     */
    public boolean isNotValid(GameBoard board, Cell cell) {
        if (cell != null && cell.getValue().equals(NO_PASSED) && lastCellNoPassed == null) {
            this.lastCellNoPassed = cell;
        } else if (cell != null && cell.getValue().equals(NO_PASSED) && lastCellNoPassed != null) {
            Region regionCell = board.getRegionsForPosicion(cell.getPosition()).get(0);
            Region regionLastCellNoPassed = board.getRegionsForPosicion(lastCellNoPassed.getPosition()).get(0);
            if (regionCell != regionLastCellNoPassed) {
                return true;
            } else {
                lastCellNoPassed = cell;
            }
        } else {
            this.lastCellNoPassed = null;
        }
        return false;
    }

    /**
     * Recorre la matriz como filas (si isRowsControl=true) o como columnas (si isRowsControl=false).
     * @param board tablero
     * @param index1 indica cant filas si isRowsControl=true, cant cols caso contrario
     * @param index2 indica cant cols si isRowsControl=true, cant filas caso contrario
     * @param isRowsControl indica si se recorre por filas
     * @return boolean true si no hay celdas contiguas sin visitar de distintas regiones para el recorrido elegido.
     */
    public boolean isControlCellsNoOk(GameBoard board, int index1, int index2, boolean isRowsControl) {
        for (int i = 0; i < index1; i++) {
            lastCellNoPassed = null;
            for (int j = 0; j < index2; j++) {
                Cell cell = null;
                if (isRowsControl) {
                    cell = board.getMatrix()[i][j];
                } else {
                    cell = board.getMatrix()[j][i];
                }
                if ( cell != null && cell.getValue() != null && isNotValid(board, cell) ) {
                    return true;
                }
            }
        }
        this.lastCellNoPassed = null;
        return false;
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        if (board.isFull() && board.isCompleteBoard()) {
            int indexRows = board.getRows();
            int indexCols = board.getColumns();
            if (isControlCellsNoOk(board, indexRows, indexCols, true)
                    || isControlCellsNoOk(board, indexCols, indexRows, false)) {
                return true;
            }
        }
        return false;
    }
}
