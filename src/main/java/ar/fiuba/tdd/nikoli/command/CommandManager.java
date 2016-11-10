package ar.fiuba.tdd.nikoli.command;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;

import java.util.Stack;

/**
 * Created by emmanuel on 07/11/16.
 */
public class CommandManager {
    private Stack<Command> commandStack = new Stack<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        commandStack.push(cmd);
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            Command cmd = commandStack.pop();
            cmd.undo();
        }
    }
}
