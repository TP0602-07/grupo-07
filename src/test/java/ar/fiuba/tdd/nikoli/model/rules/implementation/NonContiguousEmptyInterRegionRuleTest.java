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

public class NonContiguousEmptyInterRegionRuleTest {

    private GameBoard board;

    private Rule rule;

    private static final int ROWS = 4;
    private static final int COLUMNS = 4;

    private GameBoard buildGameBoard() throws InvalidMoveException {
        //matriz 4x4
        this.board.insertValue(new Move(new Position(0,0), 1));
        this.board.insertValue(new Move(new Position(0,1), 1));
        this.board.insertValue(new Move(new Position(0,2), 1));
        this.board.insertValue(new Move(new Position(0,3), 1));
        this.board.insertValue(new Move(new Position(1,0), 1));
        this.board.insertValue(new Move(new Position(1,1), 1));
        this.board.insertValue(new Move(new Position(1,2), 1));
        this.board.insertValue(new Move(new Position(1,3), 1));
        this.board.insertValue(new Move(new Position(2,0), 1));
        this.board.insertValue(new Move(new Position(2,1), 1));
        this.board.insertValue(new Move(new Position(2,2), 1));
        this.board.insertValue(new Move(new Position(2,3), 1));
        this.board.insertValue(new Move(new Position(3,0), 1));
        this.board.insertValue(new Move(new Position(3,1), 1));
        this.board.insertValue(new Move(new Position(3,2), 1));
        this.board.insertValue(new Move(new Position(3,3), 1));
        this.board.setIsCompleteBoard(true);
        return this.board;
    }

    private List<Position> buildRegionFourPosition(Position p1, Position p2, Position p3,Position p4) {
        List<Position> positionsRegion = new ArrayList<>();
        positionsRegion.add(p1);
        positionsRegion.add(p2);
        positionsRegion.add(p3);
        positionsRegion.add(p4);
        return positionsRegion;
    }

    private List<Region> buildRegions() {
        List<Position> positionsRegion1 = buildRegionFourPosition(new Position(0, 0), new Position(0, 1),
                new Position(1, 0), new Position(1, 1));
        Region region1 = new Region();
        region1.setPositions(positionsRegion1);

        List<Position> positionsRegion2 = buildRegionFourPosition(new Position(2, 0), new Position(2, 1),
                                                                  new Position(3, 0), new Position(3, 1));
        Region region2 = new Region();
        region2.setPositions(positionsRegion2);

        List<Position> positionsRegion3 = buildRegionFourPosition(new Position(0, 2), new Position(0, 3),
                                                                 new Position(1, 2), new Position(1, 3));
        positionsRegion3.addAll(buildRegionFourPosition(new Position(2, 2), new Position(2, 3),
                new Position(3, 2), new Position(3, 3)));
        Region region3 = new Region();
        region3.setPositions(positionsRegion3);
        region2.setValue(5);

        List<Region> regions = new ArrayList<>();
        regions.add(region1);
        regions.add(region2);
        regions.add(region3);

        return regions;
    }

    public void playCorrect(GameBoard board) throws InvalidMoveException {
        //deja celdas contiguas sin recorrer pero de la misma region
        board.insertValue(new Move(new Position(2,1), 2));
        board.insertValue(new Move(new Position(3,1), 2));
        board.insertValue(new Move(new Position(3,0), 2));
        board.insertValue(new Move(new Position(2,0), 2));
        board.insertValue(new Move(new Position(1,0), 2));
        board.insertValue(new Move(new Position(0,0), 2));
        board.insertValue(new Move(new Position(0,1), 2));
        board.insertValue(new Move(new Position(0,2), 2));
        board.insertValue(new Move(new Position(1,2), 2));
        board.insertValue(new Move(new Position(2,2), 2));
    }

    public void playIncorrect(GameBoard board) throws InvalidMoveException {
        //deja las celdas (1,1) y (2,1) sin recorrer, siendo contiguas y de distinta region
        board.insertValue(new Move(new Position(3,1), 2));
        board.insertValue(new Move(new Position(3,0), 2));
        board.insertValue(new Move(new Position(2,0), 2));
        board.insertValue(new Move(new Position(1,0), 2));
        board.insertValue(new Move(new Position(0,0), 2));
        board.insertValue(new Move(new Position(0,1), 2));
        board.insertValue(new Move(new Position(0,2), 2));
        board.insertValue(new Move(new Position(1,2), 2));
        board.insertValue(new Move(new Position(2,2), 2));
        board.insertValue(new Move(new Position(3,2), 2));
    }


    @Before
    public void setUp() {
        this.rule = new NonContiguousEmptyInterRegionRule();

        this.board = new GameBoard(ROWS, COLUMNS);
        this.board.buildMatrix();
        this.board.setRegions(buildRegions());
    }


    /**
     * Chequea que no se rompa la regla al no dejar celdas contiguas de distinta region sin recorrer.
     */
    @Test
    public void isRuleBroken_NotBroken() throws Exception {
        GameBoard board = this.buildGameBoard();
        playCorrect(board);
        Assert.assertFalse(this.rule.isRuleBroken(board , new Position(0,0)));
    }

    /**
     * Chequea que se rompa la regla al dejar celdas contiguas de distinta region sin recorrer.
     */
    @Test
    public void isRuleBroken_Broken() throws Exception {
        GameBoard board = this.buildGameBoard();
        playIncorrect(board);
        Assert.assertTrue(this.rule.isRuleBroken(board, new Position(0, 0)));
    }



}