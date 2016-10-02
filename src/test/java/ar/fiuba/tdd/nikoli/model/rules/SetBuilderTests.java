package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.implementation.SudokuSetBuilder;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ishilkov on 9/29/16.
 */
public class SetBuilderTests {

    private List<List<Cell>> buildGameMatrix() {

        List<List<Cell>> gameMatrix = new ArrayList<>();

        gameMatrix.add(buildColumn(0, 1));
        gameMatrix.add(buildColumn(1, 2));
        gameMatrix.add(buildColumn(2, 3));
        gameMatrix.add(buildColumn(3, 4));
        gameMatrix.add(buildColumn(4, 5));
        gameMatrix.add(buildColumn(5, 6));
        gameMatrix.add(buildColumn(6, 7));
        gameMatrix.add(buildColumn(7, 8));
        gameMatrix.add(buildColumn(8, 9));

        return gameMatrix;
    }


    private List<Cell> buildColumn(int posX, int cellValue) {

        List<Cell> column = new ArrayList<>();
        column.add(new Cell(new Position(posX, 0), cellValue, 0, 0 ));
        column.add(new Cell(new Position(posX, 1), 0, 0, 0 ));
        column.add(new Cell(new Position(posX, 2), 0, 0, 0 ));
        column.add(new Cell(new Position(posX, 3), 0, 0, 0 ));
        column.add(new Cell(new Position(posX, 4), 0, 0, 0 ));
        column.add(new Cell(new Position(posX, 5), 0, 0, 0 ));
        column.add(new Cell(new Position(posX, 6), 0, 0, 0 ));
        column.add(new Cell(new Position(posX, 7), 0, 0, 0 ));
        column.add(new Cell(new Position(posX, 8), 0, 0, 0 ));

        return column;
    }

    @Test
    public void testBuildSudokuCellSets() {

        GameBoard board = new GameBoard();
        board.setGameMatrix(buildGameMatrix());

        SudokuSetBuilder setBuilder = new SudokuSetBuilder();

        List<CellSet> cellSets = setBuilder.buildRuleCellSets(board);

        CellSet cellSet = cellSets.get(0);

        assertEquals(cellSet.getCells().get(0).getValue(CellValue.Cell), 1);
    }

}
