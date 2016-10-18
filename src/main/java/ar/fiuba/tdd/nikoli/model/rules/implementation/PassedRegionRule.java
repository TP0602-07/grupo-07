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
    private Region lastRegion;
    private SumRule sumRule;

    public PassedRegionRule() {
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


    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        if (this.lastRegion == null) {
            this.lastRegion = board.getRegionsForPosicion(position).get(0);
            return false;
        }
        Region actualRegion = board.getRegionsForPosicion(position).get(0);
        if (actualRegion != this.lastRegion && !regionPasses.contains(actualRegion)) {
            this.regionPasses.add(this.lastRegion);
            boolean isAmountPassesFailed = sumRule.isRegionControlFail(board,this.lastRegion);
            this.lastRegion = actualRegion;
            return isAmountPassesFailed;
        } else if (actualRegion != this.lastRegion && regionPasses.contains(actualRegion)) {
            return true;
        }
        return false;
    }

}