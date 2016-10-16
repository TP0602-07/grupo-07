package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;


/**
 * Clase que representa la regla de multiplicar los valores de las celdas pertenecientes una region.
 */
public class RegionMultiplicationRule extends Rule {

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        boolean isBroken = false;

        for (Region region : board.getRegionsForPosicion(position)) {

            if (region.getValue() == 0) {
                /**
                 * Si la region tiene un valor igual a 0, entonces no corresponde checkear la
                 * multiplicacion de sus celdas => la regla no se rompe.
                 */
                isBroken = false;
            } else {
                if (!region.isRegionFull(board)) {
                    /**
                     * Si la region no esta completo => la regla no se rompe.
                      */
                    isBroken = false;
                } else {
                    /**
                     * Si la region esta completa se multiplican todos los valores de las
                     * celdas y se verifica si el producto es igual al valor de la region.
                     */
                    Integer product = 1;
                    for (Position regionCellPosition : region.getPositions()) {
                        Integer cellValue = board.getValueForPosition(regionCellPosition);
                        product = product * cellValue;
                    }

                    isBroken = !(product.equals(region.getValue()));
                }
            }

        }

        return isBroken;
    }


}
