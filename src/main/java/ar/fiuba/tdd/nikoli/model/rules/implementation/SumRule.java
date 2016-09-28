package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la regla de sumar una cantidad determinada en una fila.
 */
public class SumRule extends Rule {

    private List<SumCellSet> sumCellSets;

    public SumRule() {
        sumCellSets = new ArrayList<SumCellSet>();
    }

    private int sum(SumCellSet set) {
        int sum = 0;

        for (Cell cell : set.getCells()) {
            sum += cell.getValue(CellValue.Cell);
        }

        return sum;
    }

    private boolean isSumIncorrect(int sum, int sumExpected) {
        return sum != sumExpected;
    }


    @Override
    public boolean isRuleBroken() {

        boolean isBroken = false;

        for (SumCellSet set : sumCellSets) {
            int sum = sum(set);

            if (isSumIncorrect(sum, set.getSum())) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }

    @Override
    public void buildRuleCellSets(GameBoardIterator board) {

        buildStructuresSets(board,
                            new BoardGuide(new Position(0, 1), new Position(1, 0)),
                            new CellNegotiator(CellValue.Column));
        buildStructuresSets(board,
                            new BoardGuide(new Position(1, 0), new Position(0, 1)),
                            new CellNegotiator(CellValue.Row));
    }

    private void buildStructuresSets(GameBoardIterator board,
                                     BoardGuide boardGuide,
                                     CellNegotiator cellNegotiator) {

        boolean buildSet = true;
        Cell cell = board.getOriginCell();

        while (buildSet) {

            buildStructureSets(board, boardGuide, cellNegotiator, cell);

            buildSet = false;

            if (board.hasNeighborCell(cell, boardGuide.getNextStructurePosition())) {

                cell = board.getNeighborCell(cell, boardGuide.getNextStructurePosition());
                buildSet = true;
            }
        }
    }

    private void buildStructureSets(GameBoardIterator board,
                                    BoardGuide boardGuide,
                                    CellNegotiator cellNegotiator,
                                    Cell cell) {

        while (board.hasNeighborCell(cell, boardGuide.getNextCellPosition())) {

            cell = buildStructureSet(board, boardGuide, cellNegotiator, cell);
        }
    }

    private Cell buildStructureSet(GameBoardIterator board,
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

            this.sumCellSets.add(new SumCellSet(sum, cells));
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
