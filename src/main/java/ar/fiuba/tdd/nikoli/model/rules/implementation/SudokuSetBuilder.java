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

        buildSetsFromRegions(board, cellSets);

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
                                      List<CellSet> cellSets) {

        boolean buildSet = true;
        Cell cell = board.getOriginCell();

        Position positionY = new Position(0, 3);

        while (buildSet) {

            buildSetFromRegion(board, cellSets, cell);

            if (board.hasNeighborCell(cell, positionY)) {
                cell = board.getNeighborCell(cell, positionY);
                buildSet = true;
            }
        }
    }

    private void buildSetFromRegion(GameBoardIterator board,
                                    List<CellSet> cellSets,
                                    Cell cell) {


    }
}
