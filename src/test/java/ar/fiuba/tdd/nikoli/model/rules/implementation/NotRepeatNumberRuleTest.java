package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NotRepeatNumberRuleTest {

    private Rule rule;

    private final boolean editable = true;
    private final boolean notEditable = true;


    private List<Region> buildRegionsWithNotRepeatedNumbers() {

        List<Cell> cellsRegion1 = new ArrayList<Cell>();
        cellsRegion1.add(new Cell(new Position(0,1),5, editable));
        cellsRegion1.add(new Cell(new Position(0,2),1, editable));
        cellsRegion1.add(new Cell(new Position(0,3),6, editable));

        Region region1 = new Region();
        region1.setCells(cellsRegion1);


        List<Cell> cellsRegion2 = new ArrayList<Cell>();
        cellsRegion2.add(new Cell(new Position(1,1),8, editable));
        cellsRegion2.add(new Cell(new Position(1,2),4, notEditable));
        cellsRegion2.add(new Cell(new Position(1,3),5, editable));

        Region region2 = new Region();
        region2.setCells(cellsRegion2);


        List<Region> regionsWithNotRepeatedNumbers = new ArrayList<Region>();
        regionsWithNotRepeatedNumbers.add(region1);
        regionsWithNotRepeatedNumbers.add(region2);

        return regionsWithNotRepeatedNumbers;
    }

    private List<Region> buildRegionsWithRepeatedNumbers() {

        List<Cell> cellsRegion1 = new ArrayList<Cell>();
        cellsRegion1.add(new Cell(new Position(0,1),5, editable));
        cellsRegion1.add(new Cell(new Position(0,2),1, editable));
        cellsRegion1.add(new Cell(new Position(0,3),6, editable));

        Region region1 = new Region();
        region1.setCells(cellsRegion1);


        List<Cell> cellsRegion2 = new ArrayList<Cell>();
        cellsRegion2.add(new Cell(new Position(1,1),8, editable));
        cellsRegion2.add(new Cell(new Position(1,2),8, notEditable));
        cellsRegion2.add(new Cell(new Position(1,3),5, editable));

        Region region2 = new Region();
        region2.setCells(cellsRegion2);


        List<Region> regionsWithRepeatedNumbers = new ArrayList<Region>();
        regionsWithRepeatedNumbers.add(region1);
        regionsWithRepeatedNumbers.add(region2);

        return regionsWithRepeatedNumbers;
    }


    @Before
    public void setUp() {
        this.rule = new NotRepeatNumberRule();
    }

     /**
     * Chequea que efectivamente la regla no se rompa.
     */
    @Test
    public void isRuleBroken_NotBroken() {
        List<Region> regions = this.buildRegionsWithNotRepeatedNumbers();

        boolean result = this.rule.isRuleBroken(regions);

        Assert.assertFalse("La regla no debio haberse roto.",result);
    }

    /**
     * Chequea que efectivamente la regla se rompa.
     */
    @Test
    public void isRuleBroken_Broken() {
        List<Region> regions = this.buildRegionsWithRepeatedNumbers();

        boolean result = this.rule.isRuleBroken(regions);

        Assert.assertTrue("La regla debio haberse roto.",result);
    }

}