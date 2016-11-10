package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.conf.board.BoardJson;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.board.builders.GameBoardBuilder;
import ar.fiuba.tdd.nikoli.model.board.exception.InvalidPlayException;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.plays.Play;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CorrectCircuitRuleTest {

    private GameBoard board;

    private Rule rule;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;

    private GameBoard buildGameBoard() throws  InvalidPlayException {

        this.board.insertValue(new Play(0,0, 1));
        this.board.insertValue(new Play(0,1, 1));
        this.board.insertValue(new Play(0,2, 1));
        this.board.insertValue(new Play(1,0, 1));
        this.board.insertValue(new Play(1,1, 1));
        this.board.insertValue(new Play(1,2, 1));
        this.board.insertValue(new Play(2,0, 1));
        this.board.insertValue(new Play(2,1, 1));
        this.board.insertValue(new Play(2,2, 1));

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

        BoardJson json = mock(BoardJson.class);

        when(json.getRows()).thenReturn(ROWS);
        when(json.getColumns()).thenReturn(COLUMNS);
        when(json.getRegions()).thenReturn(buildRegions());

        this.board = GameBoardBuilder.build(json);
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