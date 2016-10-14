package ar.fiuba.tdd.nikoli.model.rules.implementation;


import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule que chequea que pase por la region.
 *
 */
public class PassedRegionRule extends Rule{


    private List<Integer> amountPasses;

    public PassedRegionRule() {
        amountPasses = new ArrayList<Integer>();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }


    public int obtainPasses(GameBoard board,Region region, Position position) {
        int passes = 0;
        for (Position pos : region.getPositions()) {
            //Si no es editable, es porque paso por la celda
            if (!board.getMatrix()[pos.getX()][pos.getY()].isEditable()) {
                passes += 1;
            }
        }
        return passes;
    }

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        //TODO modificar el isFull por algo que tenga sentido con circuito cerrado (agregar otro atrribute)
        if (board.isFull()) {
            List<Region> regions = board.getRegions();
            for (Region region : regions) {
                int passes = this.obtainPasses(board,region,position);
                if (passes == 0) {
                    //No paso por ninguna celda de la region, por lo tanto se rompio la regla
                    return true;
                }
                amountPasses.add(passes);
            }
            return false;
        } else {
            //Si el circuito no se cerro no se valida
            return false;
        }
    }

    public List<Integer> getAmountPasses() {
        return amountPasses;
    }

    public void setAmountPasses(List<Integer> amountPasses) {
        this.amountPasses = amountPasses;
    }



}