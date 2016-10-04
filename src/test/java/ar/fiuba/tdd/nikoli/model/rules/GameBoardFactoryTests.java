package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.OldCell;
import ar.fiuba.tdd.nikoli.model.board.OldGameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ltessore on 29/09/16.
 */
public class GameBoardFactoryTests {

    @Test(expected = IOException.class)
    public void testInsertCellNoOK() throws Exception {
        List<List<OldCell>> matrix = new ArrayList<List<OldCell>>();
        List<OldCell> rowColumns = new ArrayList<OldCell>();
        OldCell cell = new OldCell(new Position(0,0),10,0,0);
        rowColumns.add(cell);
        matrix.add(rowColumns);
        OldGameBoard gameBoard = new OldGameBoard();
        gameBoard.setGameMatrix(matrix);
        gameBoard.insert(new Move(new Position(0,0),11));
    }

}
