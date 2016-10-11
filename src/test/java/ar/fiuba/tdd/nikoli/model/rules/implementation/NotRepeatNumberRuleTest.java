package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.conf.exception.InvalidMoveException;
import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NotRepeatNumberRuleTest {

    private GameBoard board;

    private Rule rule;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;

    private GameBoard buildGameBoardWithNotRepeatedNumbers() throws InvalidMoveException {

        this.board.insertValue(new Move(new Position(0,0), 5));
        this.board.insertValue(new Move(new Position(0,1), 6));
        this.board.insertValue(new Move(new Position(0,2), 9));
        this.board.insertValue(new Move(new Position(1,0), 2));
        this.board.insertValue(new Move(new Position(2,0), 9));

        return this.board;
    }

    private GameBoard buildGameBoardWithRepeatedNumbers() throws InvalidMoveException {

        this.board.insertValue(new Move(new Position(0,0), 5));
        this.board.insertValue(new Move(new Position(0,1), 2));
        this.board.insertValue(new Move(new Position(0,2), 8));
        this.board.insertValue(new Move(new Position(1,0), 5));
        this.board.insertValue(new Move(new Position(2,0), 9));

        return board;
    }

    private List<Region> buildRegions() {
        List<Position> positionsRegion1 = new ArrayList<>();
        positionsRegion1.add(new Position(0,0));
        positionsRegion1.add(new Position(0,1));
        positionsRegion1.add(new Position(0,2));

        Region region1 = new Region();
        region1.setPositions(positionsRegion1);

        List<Position> positionsRegion2 = new ArrayList<>();
        positionsRegion2.add(new Position(0,0));
        positionsRegion2.add(new Position(1,0));
        positionsRegion2.add(new Position(2,0));

        Region region2 = new Region();
        region2.setPositions(positionsRegion2);

        List<Region> regions = new ArrayList<>();
        regions.add(region1);
        regions.add(region2);

        return regions;
    }

    @Before
    public void setUp() {
        this.rule = new NotRepeatNumberRule();

        this.board = new GameBoard(ROWS, COLUMNS);
        this.board.buildMatrix();
        this.board.setRegions(buildRegions());
    }

     /**
     * Chequea que efectivamente la regla no se rompa.
     */
    @Test
    public void isRuleBroken_NotBroken() throws Exception {
        GameBoard board = this.buildGameBoardWithNotRepeatedNumbers();

        boolean result = this.rule.isRuleBroken(board , new Position(0,0));

        Assert.assertFalse("La regla no debio haberse roto.",result);
    }

    /**
     * Chequea que efectivamente la regla se rompa.
     */
    @Test
    public void isRuleBroken_Broken() throws Exception {
        GameBoard board = this.buildGameBoardWithRepeatedNumbers();

        boolean result = this.rule.isRuleBroken(board , new Position(0,0));

        Assert.assertTrue("La regla debio haberse roto.",result);
    }

}