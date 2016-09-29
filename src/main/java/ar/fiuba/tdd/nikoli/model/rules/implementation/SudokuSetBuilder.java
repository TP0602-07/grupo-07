package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.SetBuilder;
import ar.fiuba.tdd.nikoli.model.rules.sets.BoardGuide;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishilkov on 9/28/16.
 */
public class SudokuSetBuilder implements SetBuilder<CellSet> {

    @Override
    public List<CellSet> buildRuleCellSets(GameBoardIterator board) {

        List<CellSet> cellSets = new ArrayList<>();

        buildSetsFromRegions(board,
                             cellSets,
                             new Position(3, 0), new Position(0, 3));

        buildSetsFromLines(
                board,
                cellSets,
                new BoardGuide(new Position(0, 1), new Position(1, 0)));

        buildSetsFromLines(
                board,
                cellSets,
                new BoardGuide(new Position(1, 0), new Position(0, 1)));

        return cellSets;
    }

    private void buildSetsFromLines(GameBoardIterator board,
                                    List<CellSet> cellSets,
                                    BoardGuide boardGuide) {

        boolean buildSet = true;
        Cell cell = board.getOriginCell();

        while (buildSet) {

            buildSetFromLine(board, cellSets, boardGuide, cell);

            buildSet = board.hasNeighborCell(cell, boardGuide.getNextStructurePosition());

            if (buildSet) {
                cell = board.getNeighborCell(cell, boardGuide.getNextStructurePosition());
            }
        }
    }

    private void buildSetFromLine(GameBoardIterator board,
                                  List<CellSet> cellSets,
                                  BoardGuide boardGuide,
                                  Cell startCell) {

        List<Cell> cells = new ArrayList<>();

        boolean setEnd = false;

        Cell cell = startCell;

        while (!setEnd) {

            cells.add(cell);

            if (!board.hasNeighborCell(cell, boardGuide.getNextCellPosition())) {
                setEnd = true;
            } else {
                cell = board.getNeighborCell(cell, boardGuide.getNextCellPosition());
                setEnd = false;
            }
        }

        cellSets.add(new CellSet(cells));
    }

    private void buildSetsFromRegions(GameBoardIterator board,
                                      List<CellSet> cellSets,
                                      Position posX,
                                      Position posY) {

        Cell startCell = board.getOriginCell();

        while (true) {

            buildSetsRegionsForColumn(board, cellSets, startCell, posY);

            if (!board.hasNeighborCell(startCell, posX)){
                break;
            }

            startCell = board.getNeighborCell(startCell, posX);
        }
    }

    private void buildSetsRegionsForColumn(GameBoardIterator board,
                                           List<CellSet> cellSets,
                                           Cell startCell,
                                           Position posY) {

        while (true) {

            buildSetFromRegion(board, cellSets, startCell);

            if (!board.hasNeighborCell(startCell, posY)) {
                break;
            }

            startCell = board.getNeighborCell(startCell, posY);
        }
    }

    private void buildSetFromRegion(GameBoardIterator board,
                                    List<CellSet> cellSets,
                                    Cell cell) {
        Cell startCell = cell;

        List<Cell> cells = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {

            buildLinearSetFromRegion(board, startCell, cells);
            if (board.hasNeighborCell(startCell, new Position(1, 0))) {
                startCell = board.getNeighborCell(startCell, new Position(1, 0));
            }
        }

        cellSets.add(new CellSet(cells));
    }

    private void buildLinearSetFromRegion(GameBoardIterator board, Cell cell, List<Cell> cells) {
        for (int i = 1; i <= 3; i++) {

            cells.add(cell);
            if (board.hasNeighborCell(cell, new Position(0, 1))) {
                cell = board.getNeighborCell(cell, new Position(0, 1));
            }
        }
    }
}
