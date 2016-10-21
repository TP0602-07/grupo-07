package ar.fiuba.tdd.nikoli.model.board;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PositionTests {

    @Test
    public void testContiguousHorizontalOrVerticalTrue() {
        Position pos = new Position(2,2);
        assertTrue(pos.isContiguouosHorizontalOrVertical(new Position(3,2)));
        assertTrue(pos.isContiguouosHorizontalOrVertical(new Position(2,3)));
        assertTrue(pos.isContiguouosHorizontalOrVertical(new Position(2,1)));
        assertTrue(pos.isContiguouosHorizontalOrVertical(new Position(1,2)));
    }

    @Test
    public void testContiguousHorizontalOrVerticalFalseHorizontal() {
        Position pos = new Position(2,2);
        assertFalse(pos.isContiguouosHorizontalOrVertical(new Position(5,2)));
    }

    @Test
    public void testContiguousHorizontalOrVerticalFalseVertical() {
        Position pos = new Position(2,2);
        assertFalse(pos.isContiguouosHorizontalOrVertical(new Position(2,6)));

    }

    @Test
    public void testContiguousHorizontalOrVerticalFalseSame() {
        Position pos = new Position(2,2);
        assertFalse(pos.isContiguouosHorizontalOrVertical(new Position(2,2)));
    }


}
