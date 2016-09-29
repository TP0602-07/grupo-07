package ar.fiuba.tdd.nikoli.model.ui;


import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;

import java.util.List;

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
        List<List<Cell>> matrix = gameBoard.getGameMatrix();

        for (List<Cell> rows : matrix) {
            StringBuilder rowString = new StringBuilder();
            rowString.append("|");

            for (Cell cell : rows) {
                rowString.append(cell.getValue(CellValue.Cell));
                rowString.append("|");
            }
            System.out.println(rowString);

            System.out.println("---------------------------------------------------------------------");
        }
    }
}
