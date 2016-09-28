package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;

import java.util.List;

/**
 * Clase que representa el tablero de juego.
 */
public class GameBoard
        implements GameBoardIterator {

    private static final int CELL_INIT = 0;
    private static final int ORIGIN = 0;
    private List<List<Cell>> gameMatrix;

    public GameBoard() { }


    public List<List<Cell>> getGameMatrix() {
        return gameMatrix;
    }

    public void setGameMatrix(List<List<Cell>> gameMatrix) {
        this.gameMatrix = gameMatrix;
    }


    @Override
    public Cell getCell(Position position) {
        return gameMatrix.get(position.getX()).get(position.getY());
    }

    @Override
    public Cell getOriginCell() {
        return gameMatrix.get(ORIGIN).get(ORIGIN);
    }

    @Override
    public boolean hasNeighborCell(Cell cell, Position position) {
        return true;
    }

    @Override
    public Cell getNeighborCell(Cell cell, Position position) {
        return  gameMatrix.get(cell.getPosition().getX() + position.getX())
                          .get(cell.getPosition().getY() + position.getY());
    }

}
