package ar.fiuba.tdd.nikoli.model.rules.sets;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;

/**
 * Created by ishilkov on 9/28/16.
 */
public class CellNegotiator {

    private CellValue cellValue;

    public CellNegotiator(CellValue cellValue) {
        this.cellValue = cellValue;
    }

    public int getSetValue(Cell cell) {
        return cell.getValue(this.cellValue);
    }

    public boolean hasSetValue(Cell cell) {
        return cell.hasValue(this.cellValue);
    }

    public boolean isEmpty(Cell cell) {
        return !(hasSetValue(cell) || cell.hasValue(CellValue.Cell));
    }
}
