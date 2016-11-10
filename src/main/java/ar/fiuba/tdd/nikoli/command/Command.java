package ar.fiuba.tdd.nikoli.command;

import ar.fiuba.tdd.nikoli.model.board.exception.InvalidPlayException;

/**
 * Created by emmanuel on 08/11/16.
 */
public abstract class Command {
    public abstract void execute();

    public abstract void undo();
}
