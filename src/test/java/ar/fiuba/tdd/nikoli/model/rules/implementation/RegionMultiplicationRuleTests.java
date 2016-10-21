package ar.fiuba.tdd.nikoli.model.rules.implementation;


import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.Region;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.plays.Play;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegionMultiplicationRuleTests {

    @Test
    public void checkIsRuleBrokenRegionWithouValue() throws Exception {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0,0));
        positions.add(new Position(1,0));

        Region regionWithoutValues = new Region();
        regionWithoutValues.setPositions(positions);
        regionWithoutValues.setValue(0);

        List<Region> boardRegions = new ArrayList<>();
        boardRegions.add(regionWithoutValues);

        GameBoard board = new GameBoard(5,5);
        board.setRegions(boardRegions);

        board.buildMatrix();
        board.insertValue(new Play(0,0,3));
        board.insertValue(new Play(1,0,2));

        Rule rule = new RegionMultiplicationRule();

        boolean isBroken = rule.isRuleBroken(board, new Position(0,0));

        assertFalse(isBroken);
    }

    @Test
    public void checkIsRuleBrokenIncompleteRegion() throws Exception {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0,0));
        positions.add(new Position(1,0));

        Region regionWithoutValues = new Region();
        regionWithoutValues.setPositions(positions);
        regionWithoutValues.setValue(6);

        List<Region> boardRegions = new ArrayList<>();
        boardRegions.add(regionWithoutValues);

        GameBoard board = new GameBoard(5,5);
        board.setRegions(boardRegions);

        board.buildMatrix();
        board.insertValue(new Play(0,0,3));

        Rule rule = new RegionMultiplicationRule();

        boolean isBroken = rule.isRuleBroken(board, new Position(0,0));

        assertFalse(isBroken);
    }

    @Test
    public void checkIsRuleBrokenCompleteRegionOK() throws Exception {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0,0));
        positions.add(new Position(1,0));

        Region regionWithoutValues = new Region();
        regionWithoutValues.setPositions(positions);
        regionWithoutValues.setValue(6);

        List<Region> boardRegions = new ArrayList<>();
        boardRegions.add(regionWithoutValues);

        GameBoard board = new GameBoard(5,5);
        board.setRegions(boardRegions);

        board.buildMatrix();
        board.insertValue(new Play(0,0,3));
        board.insertValue(new Play(1,0,2));

        Rule rule = new RegionMultiplicationRule();

        boolean isBroken = rule.isRuleBroken(board, new Position(0,0));

        assertFalse(isBroken);
    }

    @Test
    public void checkIsRuleBrokenCompleteRegionBroken() throws Exception {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0,0));
        positions.add(new Position(1,0));

        Region regionWithoutValues = new Region();
        regionWithoutValues.setPositions(positions);
        regionWithoutValues.setValue(6);

        List<Region> boardRegions = new ArrayList<>();
        boardRegions.add(regionWithoutValues);

        GameBoard board = new GameBoard(5,5);
        board.setRegions(boardRegions);

        board.buildMatrix();
        board.insertValue(new Play(0,0,3));
        board.insertValue(new Play(1,0,3));

        Rule rule = new RegionMultiplicationRule();

        boolean isBroken = rule.isRuleBroken(board, new Position(0,0));

        assertTrue(isBroken);
    }
}
