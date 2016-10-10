package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SumRuleTest {
    private GameBoard board;

    private Rule rule;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;


    private GameBoard buildGameBoardWithNumbersEqualsToTheSum() {

        this.board.insertValue(new Move(new Position(0,0), 8));
        this.board.insertValue(new Move(new Position(0,1), 3));
        this.board.insertValue(new Move(new Position(0,2), 9));
        this.board.insertValue(new Move(new Position(1,0), 7));
        this.board.insertValue(new Move(new Position(2,0), 1));

        return this.board;
    }

    private GameBoard buildGameBoardWithNumbersNotEqualsToTheSum() {

        this.board.insertValue(new Move(new Position(0,0), 8));
        this.board.insertValue(new Move(new Position(0,1), 3));
        this.board.insertValue(new Move(new Position(0,2), 9));
        this.board.insertValue(new Move(new Position(1,0), 7));
        this.board.insertValue(new Move(new Position(2,0), 5));

        return board;
    }

    private List<Region> buildRegions() {
        List<Position> positionsRegion1 = new ArrayList<>();
        positionsRegion1.add(new Position(0,0));
        positionsRegion1.add(new Position(0,1));
        positionsRegion1.add(new Position(0,2));

        Region region1 = new Region();
        region1.setPositions(positionsRegion1);
        region1.setValue(20);

        List<Position> positionsRegion2 = new ArrayList<>();
        positionsRegion2.add(new Position(0,0));
        positionsRegion2.add(new Position(1,0));
        positionsRegion2.add(new Position(2,0));

        Region region2 = new Region();
        region2.setPositions(positionsRegion2);
        region2.setValue(16);

        List<Region> regions = new ArrayList<>();
        regions.add(region1);
        regions.add(region2);

        return regions;
    }


    @Before
    public void setUp() {
        this.rule = new SumRule();

        this.board = new GameBoard(ROWS, COLUMNS);
        this.board.setRegions(buildRegions());
    }

    /**
     * Chequea que efectivamente la regla no se rompa.
     */
    @Test
    public void isRuleBroken_NotBroken() {
        GameBoard board = this.buildGameBoardWithNumbersEqualsToTheSum();

        boolean result = this.rule.isRuleBroken(board, new Position(0,0));

        Assert.assertFalse("La regla no debio haberse roto.",result);
    }

    /**
     * Chequea que efectivamente la regla se rompa.
     */
    @Test
    public void isRuleBroken_Broken() {
        GameBoard board = this.buildGameBoardWithNumbersNotEqualsToTheSum();

        boolean result = this.rule.isRuleBroken(board, new Position(0,0));

        Assert.assertTrue("La regla debio haberse roto.",result);
    }

}