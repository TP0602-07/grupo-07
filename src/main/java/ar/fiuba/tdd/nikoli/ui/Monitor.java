package ar.fiuba.tdd.nikoli.ui;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;

/**
 * Created by ltessore on 28/09/16.
 */
public abstract class Monitor {

    public abstract void show(String message);

    public abstract void viewBoard(GameBoard gameBoard);
}
