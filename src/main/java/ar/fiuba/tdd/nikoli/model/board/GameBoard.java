package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.rules.GameBoardIterator;

import java.io.IOException;

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
        return cell.getPosition().getX() + position.getX() < gameMatrix.size()
               && cell.getPosition().getY() + position.getY() < gameMatrix.size();
    }

    @Override
    public Cell getNeighborCell(Cell cell, Position position) {
        return  gameMatrix.get(cell.getPosition().getX() + position.getX())
                          .get(cell.getPosition().getY() + position.getY());
    }


    /* Indicate that the matrix is Full */
    public boolean isFull() {
        boolean isFull = true;
        for (List<Cell> row : gameMatrix) {
            for (Cell cell : row) {
                if (!cell.hasValue(CellValue.Row) && cell.hasValue(CellValue.Column) && cell.hasValue(CellValue.Cell)) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    public void insert(Move move) throws IOException {
        Cell cellSelect  = gameMatrix.get(move.getPosition().getX()).get(move.getPosition().getY());
        if (cellSelect.hasValue(CellValue.Row) || cellSelect.hasValue(CellValue.Column) || cellSelect.hasValue(CellValue.Cell) ) {
            throw new IOException();
        }
        Cell newCell = new Cell(move.getPosition(),move.getValue(),Cell.UNASSIGNED_VALUE,Cell.UNASSIGNED_VALUE);
        List<Cell> field = gameMatrix.get(move.getPosition().getX());
        field.set(move.getPosition().getY(),newCell);
    }

}
