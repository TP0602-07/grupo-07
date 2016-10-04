package ar.fiuba.tdd.nikoli.model.ui;


import ar.fiuba.tdd.nikoli.model.board.OldCell;
import ar.fiuba.tdd.nikoli.model.board.CellValue;
import ar.fiuba.tdd.nikoli.model.board.OldGameBoard;

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
    public void viewBoard(OldGameBoard gameBoard) {
        //TODO
        List<List<OldCell>> matrix = gameBoard.getGameMatrix();

        for (List<OldCell> rows : matrix) {
            StringBuilder rowString = new StringBuilder();
            rowString.append("|");

            for (OldCell cell : rows) {
                rowString.append(cell.getValue(CellValue.Cell));
                rowString.append("|");
            }
            System.out.println(rowString);

            System.out.println("---------------------------------------------------------------------");
        }
    }
}
