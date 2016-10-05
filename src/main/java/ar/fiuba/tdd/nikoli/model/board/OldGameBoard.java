package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.model.Move;

import java.io.IOException;
import java.util.List;

/**
 * Clase que representa el tablero de juego.
 */
public class OldGameBoard {

    private static final int CELL_INIT = 0;
    private static final int ORIGIN = 0;
    private List<List<OldCell>> gameMatrix;

    public OldGameBoard() { }


    public List<List<OldCell>> getGameMatrix() {
        return gameMatrix;
    }

    public void setGameMatrix(List<List<OldCell>> gameMatrix) {
        this.gameMatrix = gameMatrix;
    }


    public OldCell getCell(Position position) {
        return gameMatrix.get(position.getX()).get(position.getY());
    }

    public OldCell getOriginCell() {
        return gameMatrix.get(ORIGIN).get(ORIGIN);
    }

    public boolean hasNeighborCell(OldCell cell, Position position) {
        return cell.getPosition().getX() + position.getX() < gameMatrix.size()
               && cell.getPosition().getY() + position.getY() < gameMatrix.size();
    }

    public OldCell getNeighborCell(OldCell cell, Position position) {
        return  gameMatrix.get(cell.getPosition().getX() + position.getX())
                          .get(cell.getPosition().getY() + position.getY());
    }


    /* Indicate that the matrix is Full */
    public boolean isFull() {
        boolean isFull = true;
        for (List<OldCell> row : gameMatrix) {
            for (OldCell cell : row) {
                if (!cell.hasValue(CellValue.Row) && cell.hasValue(CellValue.Column) && cell.hasValue(CellValue.Cell)) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    public void insert(Move move) throws IOException {
        OldCell cellSelect  = gameMatrix.get(move.getPosition().getX()).get(move.getPosition().getY());
        if (cellSelect.hasValue(CellValue.Row) || cellSelect.hasValue(CellValue.Column) || cellSelect.hasValue(CellValue.Cell) ) {
            throw new IOException();
        }
        OldCell newCell = new OldCell(move.getPosition(),move.getValue(), OldCell.UNASSIGNED_VALUE, OldCell.UNASSIGNED_VALUE);
        List<OldCell> field = gameMatrix.get(move.getPosition().getX());
        field.set(move.getPosition().getY(),newCell);
    }

}
