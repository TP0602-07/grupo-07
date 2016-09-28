package ar.fiuba.tdd.nikoli.model.rules.sets;

import ar.fiuba.tdd.nikoli.model.board.Position;

/**
 * Created by ishilkov on 9/28/16.
 */
public class BoardGuide {

    private Position nextCellPosition;
    private Position nextStructurePosition;

    public BoardGuide(Position nextCellPosition,
                      Position nextStructurePosition) {

        this.nextCellPosition = nextCellPosition;
        this.nextStructurePosition = nextStructurePosition;
    }

    public Position getNextCellPosition() {
        return nextCellPosition;
    }

    public Position getNextStructurePosition() {
        return nextStructurePosition;
    }
}
