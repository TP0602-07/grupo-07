package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.SetBuilder;
import ar.fiuba.tdd.nikoli.model.rules.sets.BoardGuide;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellNegotiator;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;
import ar.fiuba.tdd.nikoli.model.rules.sets.SumCellSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishilkov on 9/28/16.
 */
public class KakuroSetBuilder implements SetBuilder<SumCellSet> {

    @Override
    public List<SumCellSet> buildRuleCellSets(GameBoardIterator board) {

        List<SumCellSet> cellSets = new ArrayList<>();

        buildSetsFromLines(
                board,
                cellSets,
                new BoardGuide(new Position(0, 1), new Position(1, 0)),
                new CellNegotiator(CellValue.Column));

        buildSetsFromLines(
                board,
                cellSets,
                new BoardGuide(new Position(1, 0), new Position(0, 1)),
                new CellNegotiator(CellValue.Row));

        return cellSets;
    }

    private void buildSetsFromLines(GameBoardIterator board,
                                    List<SumCellSet> cellSets,
                                    BoardGuide boardGuide,
                                    CellNegotiator cellNegotiator) {

        boolean buildSet = true;
        Cell cell = board.getOriginCell();

        while (buildSet) {

            buildSetsFromLine(board, cellSets, boardGuide, cellNegotiator, cell);

            buildSet = false;

            if (board.hasNeighborCell(cell, boardGuide.getNextStructurePosition())) {

                cell = board.getNeighborCell(cell, boardGuide.getNextStructurePosition());
                buildSet = true;
            }
        }
    }

    private void buildSetsFromLine(GameBoardIterator board,
                                   List<SumCellSet> cellSets,
                                   BoardGuide boardGuide,
                                   CellNegotiator cellNegotiator,
                                   Cell cell) {

        while (board.hasNeighborCell(cell, boardGuide.getNextCellPosition())) {

            cell = buildSetFromLine(board, cellSets, boardGuide, cellNegotiator, cell);
        }
    }

    private Cell buildSetFromLine(GameBoardIterator board,
                                  List<SumCellSet> cellSets,
                                  BoardGuide boardGuide,
                                  CellNegotiator cellNegotiator,
                                  Cell startCell) {

        Cell cell = skipCell(board, boardGuide, cellNegotiator, startCell);
        Cell endCell = cell;

        if (cellNegotiator.hasSetValue(cell)) {

            int sum = cellNegotiator.getSetValue(cell);
            List<Cell> cells = new ArrayList<>();

            boolean setEnd = false;

            while (!setEnd) {

                cell = board.getNeighborCell(cell, boardGuide.getNextCellPosition());
                cells.add(cell);

                endCell = cell;

                if (!board.hasNeighborCell(cell, boardGuide.getNextCellPosition())) {
                    setEnd = true;
                } else {
                    endCell = board.getNeighborCell(cell, boardGuide.getNextCellPosition());
                    setEnd = cellNegotiator.isEmpty(endCell) || cellNegotiator.hasSetValue(endCell);
                }
            }

            cellSets.add(new SumCellSet(sum, cells));
        }

        return endCell;
    }

    private Cell skipCell(GameBoardIterator board,
                          BoardGuide boardGuide,
                          CellNegotiator cellNegotiator,
                          Cell cell) {

        while (!cellNegotiator.isEmpty(cell) && board.hasNeighborCell(cell, boardGuide.getNextCellPosition())) {
            cell = board.getNeighborCell(cell, boardGuide.getNextCellPosition());
        }

        return cell;
    }

}
