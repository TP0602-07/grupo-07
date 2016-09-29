package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.sets.BoardGuide;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellNegotiator;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase que representa la regla de no repetir numeros en una misma linea del tablero.
 */
public class NotRepeatNumberRule extends Rule {

    private List<CellSet> cellSets;

    public NotRepeatNumberRule() {
        this.cellSets = new ArrayList<>();
    }

    private boolean areThereRepeated(CellSet set) {

        boolean thereAreRepeated = false;

        Set<Integer> hashSet = new HashSet<>();

        for (Cell cell : set.getCells()) {

            int value = cell.getValue(CellValue.Cell);

            if (hashSet.contains(value)) {
                thereAreRepeated = true;
                break;
            } else {
                hashSet.add(value);
            }
        }

        return thereAreRepeated;
    }

    @Override
    public boolean isRuleBroken() {

        boolean isBroken = false;

        for (CellSet set : cellSets) {

            if (areThereRepeated(set)) {
                isBroken = true;
                break;
            }
        }

        return isBroken;
    }


    @Override
    public void buildRuleCellSets(GameBoardIterator board) {

        buildStructuresSets(board,
                new BoardGuide(new Position(0, 1), new Position(1, 0)));
        buildStructuresSets(board,
                new BoardGuide(new Position(1, 0), new Position(0, 1)));
    }

    private void buildStructuresSets(GameBoardIterator board,
                                     BoardGuide boardGuide) {

        boolean buildSet = true;
        Cell cell = board.getOriginCell();

        while (buildSet) {

            buildStructureSet(board, boardGuide, cell);

            buildSet = board.hasNeighborCell(cell, boardGuide.getNextStructurePosition());

            if (buildSet) {
                cell = board.getNeighborCell(cell, boardGuide.getNextStructurePosition());
            }
        }
    }

    private void buildStructureSet(GameBoardIterator board,
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

        this.cellSets.add(new CellSet(cells));
    }
}
