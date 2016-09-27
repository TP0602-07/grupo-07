package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.Position;

/**
 * Declara un iterador para recorrer el tablero.
 */
public interface GameBoardIterator {
    boolean hasCellTop(Cell cell);

    boolean hasCellBottom(Cell cell);

    boolean hasCellLeft(Cell cell);

    boolean hasCellRight(Cell cell);

    Cell getCell(Position position);

    Cell getCellTop(Cell cell);

    Cell getCellBottom(Cell cell);

    Cell getCellLeft(Cell cell);

    Cell getCellRight(Cell cell);

}
