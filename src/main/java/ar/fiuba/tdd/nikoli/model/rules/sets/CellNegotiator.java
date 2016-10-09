package ar.fiuba.tdd.nikoli.model.rules.sets;

import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.OldCell;

/**
 * Created by ishilkov on 9/28/16.
 */
public class CellNegotiator {

    private CellValue cellValue;

    public CellNegotiator(CellValue cellValue) {
        this.cellValue = cellValue;
    }

    public int getSetValue(OldCell cell) {
        return cell.getValue(this.cellValue);
    }

    public boolean hasSetValue(OldCell cell) {
        return cell.hasValue(this.cellValue);
    }

    public boolean isEmpty(OldCell cell) {
        return !(hasSetValue(cell) || cell.hasValue(CellValue.Cell));
    }
}
