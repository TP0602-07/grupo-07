package ar.fiuba.tdd.nikoli.model.ui;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;

/**
 * Created by ltessore on 28/09/16.
 */
public class ConsoleMonitor extends Monitor {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_BOLD = "\033[0;1m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void viewBoard(GameBoard gameBoard) {
        Cell[][] matrix = gameBoard.getMatrix();

        for (Cell[] row : matrix) {
            StringBuilder rowString = new StringBuilder();
            rowString.append("|");

            for (Cell column : row) {
                rowString.append(getColorColumn(column));

                rowString.append((column.hasValue()) ? column.getValue() : " ");
                rowString.append(ANSI_RESET);
                rowString.append("|");
            }
            System.out.println(rowString);
        }
    }

    private String getColorColumn(Cell column) {
        String color;
        if (column.isEditable()) {
            color = ANSI_BLUE;
        } else {
            color = (column.hasValue()) ? ANSI_BOLD : ANSI_BLACK_BACKGROUND;
        }
        return color;
    }
}
