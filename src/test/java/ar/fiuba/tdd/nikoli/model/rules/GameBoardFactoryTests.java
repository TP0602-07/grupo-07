package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationNotFoundException;
import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.factory.GameRulesFactory;
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
        List<List<Cell>> matrix = new ArrayList<List<Cell>>();
        List<Cell> rowColumns = new ArrayList<Cell>();
        Cell cell = new Cell(new Position(0,0),10,0,0);
        rowColumns.add(cell);
        matrix.add(rowColumns);
        GameBoard gameBoard = new GameBoard();
        gameBoard.setGameMatrix(matrix);
        gameBoard.insert(new Move(new Position(0,0),11));
    }

}
