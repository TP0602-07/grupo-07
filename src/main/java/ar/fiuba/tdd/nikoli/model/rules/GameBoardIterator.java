package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.Position;

/**
 * Declara un iterador para recorrer el tablero.
 */
public interface GameBoardIterator {

    Cell getCell(Position position);

    Cell getOriginCell();

    boolean hasNeighborCell(Cell cell, Position position);

    Cell getNeighborCell(Cell cell, Position position);
}
