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

public class SumRuleTest {
    private Rule rule;

    private final boolean editable = true;
    private final boolean notEditable = true;


    private List<Region> buildRegionsWithNumbersEqualsToTheSum() {

        List<Cell> cellsRegion1 = new ArrayList<Cell>();
        cellsRegion1.add(new Cell(new Position(0,1),5, editable));
        cellsRegion1.add(new Cell(new Position(0,2),1, editable));

        Region region1 = new Region();
        region1.setCells(cellsRegion1);
        region1.setValue(6);


        List<Cell> cellsRegion2 = new ArrayList<Cell>();
        cellsRegion2.add(new Cell(new Position(1,1),8, editable));
        cellsRegion2.add(new Cell(new Position(1,2),2, editable));
        cellsRegion2.add(new Cell(new Position(1,3),16, editable));

        Region region2 = new Region();
        region2.setCells(cellsRegion2);
        region2.setValue(26);


        List<Region> regionsWithNumbersEqualsToTheSum = new ArrayList<Region>();
        regionsWithNumbersEqualsToTheSum.add(region1);
        regionsWithNumbersEqualsToTheSum.add(region2);

        return regionsWithNumbersEqualsToTheSum;
    }

    private List<Region> buildRegionsWithNumbersNotEqualsToTheSum() {

        List<Cell> cellsRegion1 = new ArrayList<Cell>();
        cellsRegion1.add(new Cell(new Position(0,1),5, editable));
        cellsRegion1.add(new Cell(new Position(0,2),4, editable));

        Region region1 = new Region();
        region1.setCells(cellsRegion1);
        region1.setValue(9);

        List<Cell> cellsRegion2 = new ArrayList<Cell>();
        cellsRegion2.add(new Cell(new Position(1,1),8, editable));
        cellsRegion2.add(new Cell(new Position(1,2),4, editable));
        cellsRegion2.add(new Cell(new Position(1,3),25, editable));

        Region region2 = new Region();
        region2.setCells(cellsRegion2);
        region2.setValue(20);


        List<Region> regionsWithNumbersNotEqualsToTheSum = new ArrayList<Region>();
        regionsWithNumbersNotEqualsToTheSum.add(region1);
        regionsWithNumbersNotEqualsToTheSum.add(region2);

        return regionsWithNumbersNotEqualsToTheSum;
    }


    @Before
    public void setUp() {
        this.rule = new SumRule();
    }

    /**
     * Chequea que efectivamente la regla no se rompa.
     */
    @Test
    public void isRuleBroken_NotBroken() {
        List<Region> regions = this.buildRegionsWithNumbersEqualsToTheSum();

        boolean result = this.rule.isRuleBroken(regions);

        Assert.assertFalse("La regla no debio haberse roto.",result);
    }

    /**
     * Chequea que efectivamente la regla se rompa.
     */
    @Test
    public void isRuleBroken_Broken() {
        List<Region> regions = this.buildRegionsWithNumbersNotEqualsToTheSum();

        boolean result = this.rule.isRuleBroken(regions);

        Assert.assertTrue("La regla debio haberse roto.",result);
    }

}