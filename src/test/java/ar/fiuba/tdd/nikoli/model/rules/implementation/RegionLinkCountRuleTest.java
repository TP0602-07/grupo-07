package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.conf.board.BoardJson;
import ar.fiuba.tdd.nikoli.conf.board.RegionLinkJson;
import ar.fiuba.tdd.nikoli.model.board.*;
import ar.fiuba.tdd.nikoli.model.board.builders.GameBoardBuilder;
import ar.fiuba.tdd.nikoli.model.board.builders.RegionLinkBuilder;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by emmanuel on 06/11/16.
 */
public class RegionLinkCountRuleTest {
    private GameBoard board;

    private Rule rule;

    private static final int ROWS = 7;
    private static final int COLUMNS = 7;


    private List<RegionLinkJson> buildRegionsLink() {
        RegionLinkJson json1 = mock(RegionLinkJson.class);
        when(json1.getPositionLinkGenerator()).thenReturn(new Position(0,0));
        when(json1.getValue()).thenReturn(3);

        RegionLinkJson json2 = mock(RegionLinkJson.class);
        when(json2.getPositionLinkGenerator()).thenReturn(new Position(0,1));
        when(json2.getValue()).thenReturn(0);


        List<RegionLinkJson> regions = new ArrayList<>();
        regions.add(json1);
        regions.add(json2);

        return regions;
    }

    @Before
    public void setUp() {
        this.rule = new RegionLinkCountRule();

        BoardJson json = mock(BoardJson.class);

        when(json.getRows()).thenReturn(ROWS);
        when(json.getColumns()).thenReturn(COLUMNS);

        List<RegionLinkJson> regionsLinkJson = buildRegionsLink();

        when(json.getRegionsLinkJson()).thenReturn(regionsLinkJson);

        this.board = GameBoardBuilder.build(json);
    }

    @Test
    public void isRuleBroken_NotBrokenWhitBoardIncompletedAndRegionIncompleted() throws Exception {
        //Tablero incompleto. No se cerro el circuito.
        this.board.setIsCompleteBoard(false);

        this.board.addLink(new Link(new Position(0,0),new Position(0,1)));
        this.board.addLink(new Link(new Position(1,0),new Position(1,1)));

        boolean result = this.rule.isRuleBroken(board, new Position(0,0));

        Assert.assertFalse("La regla no debio haberse roto.",result);
    }

    @Test
    public void isRuleBroken_BrokenWhitBoardCompletedAndRegionIncompleted() throws Exception {
        this.board.setIsCompleteBoard(true);

        this.board.addLink(new Link(new Position(0,0),new Position(0,1)));
        this.board.addLink(new Link(new Position(0,1),new Position(0,2)));

        boolean result = this.rule.isRuleBroken(board, new Position(0,0));

        Assert.assertTrue("La regla debio haberse roto.",result);
    }

    @Test
    public void isRuleBroken_BrokenWhitBoardIncompletedAndRegionCompleted() throws Exception {
        this.board.setIsCompleteBoard(false);

        this.board.addLink(new Link(new Position(0,0),new Position(0,1)));
        this.board.addLink(new Link(new Position(0,0),new Position(1,0)));
        this.board.addLink(new Link(new Position(0,1),new Position(1,1)));
        this.board.addLink(new Link(new Position(0,1),new Position(0,2)));
        this.board.addLink(new Link(new Position(1,1),new Position(1,2)));

        boolean result = this.rule.isRuleBroken(board, new Position(0,0));

        Assert.assertTrue("La regla debio haberse roto.",result);
    }

    @Test
    public void isRuleBroken_BrokenWhitBoardCompletedAndRegionCompleted() throws Exception {
        this.board.setIsCompleteBoard(true);

        this.board.addLink(new Link(new Position(0,0),new Position(0,1)));
        this.board.addLink(new Link(new Position(0,0),new Position(1,0)));
        this.board.addLink(new Link(new Position(0,1),new Position(1,1)));
        this.board.addLink(new Link(new Position(0,1),new Position(0,2)));
        this.board.addLink(new Link(new Position(1,1),new Position(1,2)));

        boolean result = this.rule.isRuleBroken(board, new Position(0,0));

        Assert.assertTrue("La regla debio haberse roto.",result);
    }

    @Test
    public void isRuleBroken_NotBrokenWhitBoardCompletedAndRegionCompleted() throws Exception {
        this.board.setIsCompleteBoard(true);

        this.board.addLink(new Link(new Position(0,0),new Position(0,1)));
        this.board.addLink(new Link(new Position(0,0),new Position(1,0)));
        this.board.addLink(new Link(new Position(1,0),new Position(1,1)));

        boolean result = this.rule.isRuleBroken(board, new Position(0,0));

        Assert.assertFalse("La regla debio haberse roto.",result);
    }

}