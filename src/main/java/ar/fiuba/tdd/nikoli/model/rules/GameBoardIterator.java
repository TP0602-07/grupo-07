package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.board.OldCell;
import ar.fiuba.tdd.nikoli.model.board.Position;

/**
 * Declara un iterador para recorrer el tablero.
 */
public interface GameBoardIterator {

    OldCell getCell(Position position);

    OldCell getOriginCell();

    boolean hasNeighborCell(OldCell cell, Position position);

    OldCell getNeighborCell(OldCell cell, Position position);
}
