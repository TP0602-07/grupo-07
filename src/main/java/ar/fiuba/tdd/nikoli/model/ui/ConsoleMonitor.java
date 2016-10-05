package ar.fiuba.tdd.nikoli.model.ui;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;

/**
 * Created by ltessore on 28/09/16.
 */
public class ConsoleMonitor extends Monitor {

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void viewBoard(GameBoard gameBoard) {
        //TODO
        Cell[][] matrix = gameBoard.getMatrix();

        for (Cell[] row : matrix) {
            StringBuilder rowString = new StringBuilder();
            rowString.append("|");

            for (Cell column : row) {
                rowString.append(column.getValue());
                rowString.append("|");
            }
            System.out.println(rowString);

            System.out.println("---------------------------------------------------------------------");
        }
    }
}
