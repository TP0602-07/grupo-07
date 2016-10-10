package ar.fiuba.tdd.nikoli.model.board;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class GameBoardTests {

    private static GameBoard board = new GameBoard(5,5);

    @BeforeClass
    public static void configureTests() {
        List<Position> positionsReg1 = new ArrayList<Position>();
        positionsReg1.add(new Position(1,1));
        positionsReg1.add(new Position(2,2));
        positionsReg1.add(new Position(3,3));
        Region region1 = new Region();
        region1.setPositions(positionsReg1);

        List<Position> positionsReg2 = new ArrayList<Position>();
        positionsReg2.add(new Position(1, 1));
        positionsReg2.add(new Position(4, 4));
        Region region2 = new Region();
        region2.setPositions(positionsReg2);

        List<Region> boardRegions = new ArrayList<Region>();
        boardRegions.add(region1);
        boardRegions.add(region2);
        board.setRegions(boardRegions);
    }


    @Test
    public void testGetRegionsForPosicionZeroRegions() {
        List<Region> regions = board.getRegionsForPosicion(new Position(5, 5));
        assertNotNull(regions);
        assertEquals(0, regions.size());
    }

    @Test
    public void testGetRegionsForPosicionOneRegion() {
        List<Region> regions = board.getRegionsForPosicion(new Position(2, 2));
        assertNotNull(regions);
        assertEquals(1, regions.size());
    }

    @Test
    public void testGetRegionsForPosicionMultipleRegions() {
        List<Region> regions = board.getRegionsForPosicion(new Position(1, 1));
        assertNotNull(regions);
        assertEquals(2, regions.size());
    }

}
