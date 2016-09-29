package ar.fiuba.tdd.nikoli.model.ui;


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
        System.out.println("aca se imprime el tablero");
    }
}
