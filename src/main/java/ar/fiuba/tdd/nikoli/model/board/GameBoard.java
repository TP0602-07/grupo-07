package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;

import java.util.List;

/**
 * Clase que representa el tablero de juego.
 */
public class GameBoard implements GameBoardIterator {

    private static final int CELL_INIT = 0;
    private List<List<Cell>> gameMatrix;

    public GameBoard() { }


    public List<List<Cell>> getGameMatrix() {
        return gameMatrix;
    }

    public void setGameMatrix(List<List<Cell>> gameMatrix) {
        this.gameMatrix = gameMatrix;
    }


    @Override
    public boolean hasCellTop(Cell cell) {
        return (cell.getPosition().getX() == CELL_INIT);
    }

    @Override
    public boolean hasCellBottom(Cell cell) {
        return (cell.getPosition().getX() < (gameMatrix.size() - 1));
    }

    @Override
    public boolean hasCellLeft(Cell cell) {
        return (cell.getPosition().getY() == CELL_INIT);
    }

    @Override
    public boolean hasCellRight(Cell cell) {
        return (cell.getPosition().getY() < (gameMatrix.size() - 1));
    }

    @Override
    public Cell getCell(Position position) {
        return gameMatrix.get(position.getX()).get(position.getY());
    }

    @Override
    public Cell getCellTop(Cell cell) {
        return gameMatrix.get(cell.getPosition().getX() - 1).get(cell.getPosition().getY());
    }

    @Override
    public Cell getCellBottom(Cell cell) {
        return gameMatrix.get(cell.getPosition().getX() + 1).get(cell.getPosition().getY());
    }

    @Override
    public Cell getCellLeft(Cell cell) {
        return gameMatrix.get(cell.getPosition().getX()).get(cell.getPosition().getY() - 1);
    }

    @Override
    public Cell getCellRight(Cell cell) {
        return gameMatrix.get(cell.getPosition().getX()).get(cell.getPosition().getY() + 1);
    }

    /* Indicate that the matrix is Full */
    public boolean isFull() {
        boolean isFull = true;
        for (List<Cell> row : gameMatrix) {
            for (Cell cell : row) {
                if (!cell.isFull()) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    public void insert(Move move) throws Exception {
        //TODO

    }
}
