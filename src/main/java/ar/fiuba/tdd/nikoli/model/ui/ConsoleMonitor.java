package ar.fiuba.tdd.nikoli.model.ui;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;

/**
 * Created by ltessore on 28/09/16.
 */
public class ConsoleMonitor extends Monitor {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BOLD = "\033[0;1m";

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
                if (column.isEditable()) {
                    rowString.append(ANSI_BLUE);
                } else {
                    rowString.append(ANSI_BOLD);
                }

                rowString.append((column.hasValue()) ? column.getValue() : " ");
                rowString.append(ANSI_RESET);
                rowString.append("|");
            }
            System.out.println(rowString);
        }
    }
}
