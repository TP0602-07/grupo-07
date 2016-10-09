package ar.fiuba.tdd.nikoli.model.board;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegionTests {

    private static Region region;

    @BeforeClass
    public static void configureTests() {
        region = new Region();

        Position position = new Position(1, 1);
        region.getPositions().add(position);

        Position otherPosition = new Position(2, 2);
        region.getPositions().add(position);
    }


    @Test
    public void testContainsPositionTrue() {
        assertTrue(this.region.containsPosition(new Position(1, 1)));
    }

    @Test
    public void testContainsPositionFalse() {
        assertFalse(this.region.containsPosition(new Position(3, 3)));
    }
}
