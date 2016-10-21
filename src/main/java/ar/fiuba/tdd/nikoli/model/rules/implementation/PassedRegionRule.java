package ar.fiuba.tdd.nikoli.model.rules.implementation;


import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule que chequea que pase por la region a lo sumo una vez.
 * Esta regla no controla que pase por todas las regiones, solo que no se repitan.
 *
 */
public class PassedRegionRule extends Rule{


    private List<Region> regionPasses;
    private Region lastRegion; //ultima region visitada
    private SumRule sumRule; //regla sumRule para controlar cantidad de veces por las que pasa

    public PassedRegionRule() {
        this.setName("PassedRegionRule");
        regionPasses = new ArrayList<Region>();
        sumRule = new SumRule();
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
     * Chequea si falla la cantidad de veces que tenia que pasar por la region.
     * @param board tabler
     * @return boolean false si no falla
     */
    public boolean controlPassedRegionFailed(GameBoard board) {
        boolean isAmountPassesFailed = false;
        if (this.lastRegion.getValue() != 0) {
            isAmountPassesFailed = sumRule.isRegionControlFail(board, this.lastRegion);
        }
        return isAmountPassesFailed;
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        if (!board.isCompleteBoard()) {
            if (this.lastRegion == null) {
                this.lastRegion = board.getRegionsForPosicion(position).get(0);
                return false;
            }
            Region actualRegion = board.getRegionsForPosicion(position).get(0);
            if (actualRegion != this.lastRegion && !regionPasses.contains(actualRegion)) {
                this.regionPasses.add(this.lastRegion);
                boolean isAmountPassesFailed = this.controlPassedRegionFailed(board);
                this.lastRegion = actualRegion;
                return isAmountPassesFailed;
            } else if (actualRegion != this.lastRegion && regionPasses.contains(actualRegion)) {
                return true;
            }
            return false;
        }
        return false;
    }


}