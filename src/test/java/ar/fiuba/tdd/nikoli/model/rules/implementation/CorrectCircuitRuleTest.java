package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.conf.exception.InvalidMoveException;
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

public class CorrectCircuitRuleTest {

    private GameBoard board;

    private Rule rule;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;

    private GameBoard buildGameBoard() throws InvalidMoveException {

        this.board.insertValue(new Move(new Position(0,0), 1));
        this.board.insertValue(new Move(new Position(0,1), 1));
        this.board.insertValue(new Move(new Position(0,2), 1));
        this.board.insertValue(new Move(new Position(1,0), 1));
        this.board.insertValue(new Move(new Position(1,1), 1));
        this.board.insertValue(new Move(new Position(1,2), 1));
        this.board.insertValue(new Move(new Position(2,0), 1));
        this.board.insertValue(new Move(new Position(2,1), 1));
        this.board.insertValue(new Move(new Position(2,2), 1));

        return this.board;
    }

    private List<Position> buildRegionByPositions(Position p1, Position p2, Position p3) {
        List<Position> positionsRegion = new ArrayList<>();
        positionsRegion.add(p1);
        positionsRegion.add(p2);
        positionsRegion.add(p3);
        return positionsRegion;
    }

    private List<Region> buildRegions() {
        List<Position> positionsRegion1 = buildRegionByPositions(new Position(0,0), new Position(0,1),new Position(0,2));
        Region region1 = new Region();
        region1.setPositions(positionsRegion1);
        region1.setValue(3);

        List<Position> positionsRegion2 = buildRegionByPositions(new Position(1,0), new Position(1,1),new Position(1,2));
        Region region2 = new Region();
        region2.setPositions(positionsRegion2);
        region2.setValue(5);

        List<Position> positionsRegion3 = buildRegionByPositions(new Position(2,0), new Position(2,1),new Position(2,2));;
        Region region3 = new Region();
        region3.setPositions(positionsRegion3);
        region2.setValue(5);

        List<Region> regions = new ArrayList<>();
        regions.add(region1);
        regions.add(region2);
        regions.add(region3);

        return regions;
    }



    @Before
    public void setUp() {
        this.rule = new CorrectCircuitRule();

        this.board = new GameBoard(ROWS, COLUMNS);
        this.board.buildMatrix();
        this.board.setRegions(buildRegions());
    }

    /**
     * Chequea que efectivamente la regla no se rompa.
     */
    @Test
    public void isRuleBroken_NotBroken() throws Exception {
        GameBoard board = this.buildGameBoard();

        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(1,1)));
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(1,2)));
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(2,2)));
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(2,1)));
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(1,1)));
        Assert.assertTrue(board.isCompleteBoard());

    }

    /**
     * Chequea que efectivamente la regla se rompa cuando traza una linea diagonal.
     */
    @Test
    public void isRuleBroken_BrokenDiagonalLine() throws Exception {
        GameBoard board = this.buildGameBoard();
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(0,0)));
        Assert.assertTrue(this.rule.isRuleBroken(board, new Position(1, 1)));
    }

    /**
     * Chequea que efectivamente la regla se rompa cuando pasa por un punto que ya paso.
     */
    @Test
    public void isRuleBroken_BrokenRepeatLine() throws Exception {
        GameBoard board = this.buildGameBoard();
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(0,0)));
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(0,1)));
        Assert.assertFalse(this.rule.isRuleBroken(board, new Position(0,2)));
        Assert.assertTrue(this.rule.isRuleBroken(board, new Position(0, 1)));
    }



}