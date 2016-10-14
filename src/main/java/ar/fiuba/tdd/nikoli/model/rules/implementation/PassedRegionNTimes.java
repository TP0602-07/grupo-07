package ar.fiuba.tdd.nikoli.model.rules.implementation;


import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.List;

/**
 * Created by ltessore on 13/10/16.
 */
public class PassedRegionNTimes extends Rule {

    private PassedRegionRule passedRegionRule;
    // cantidad de veces por la que debe pasar por la region (debera setearsele con cada region)
    private List<Integer> ntimes;

    public PassedRegionNTimes() {
        passedRegionRule = new PassedRegionRule();
    }


    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        if (!passedRegionRule.isRuleBroken(board,position)) {
            int index = 0;
            while (index < ntimes.size()){
                /* TODO if (passedRegionRule.getAmountPasses()[index] != nTimes[index]){
                    //Como pasa por una cantidad distinta a la que se pide, la regla se rompe
                    return true;
                }
                index++;*/
            }
            return false;
        }
        return false;
    }

    public List<Integer> getntimes() {
        return ntimes;
    }

    public void setntimes(List<Integer> ntimes) {
        this.ntimes = ntimes;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }


}