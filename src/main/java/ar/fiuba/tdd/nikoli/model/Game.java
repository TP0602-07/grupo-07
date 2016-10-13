package ar.fiuba.tdd.nikoli.model;


import ar.fiuba.tdd.nikoli.conf.exception.InvalidMoveException;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.io.IOException;

public class Game {

    private GameRules gameRules;
    private GameBoard gameBoard;
    private Rule ruleBroken; //indicate that rule is broken

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final String MOVE_INCORRECT =  ANSI_RED + "Incorrect Move. Please try again\n" + ANSI_RESET;

    public Game(GameRules gameRules, GameBoard gameBoard) {
        this.gameRules = gameRules;
        this.gameBoard = gameBoard;
        ruleBroken = null;
    }

    /**
     * Chequea validez de la jugada y lo inserta en el tablero en caso afirmativo.
     * @param move instancia de {@link Move}.
     * @throws InvalidMoveException si se produjo un error en el procesamiento de las reglas del juego.
     */
    public void play(Move move) throws InvalidMoveException {
        gameBoard.insertValue(move);
        this.validate(move);
    }

    private void validate(Move move) throws InvalidMoveException {
        for (Rule rule : gameRules.getRules()) {
            if (rule.isRuleBroken(gameBoard, move.getPosition())) {
                ruleBroken = rule;
                throw new InvalidMoveException(MOVE_INCORRECT);
            }
        }
    }

    public String checkVictory() {
        if (gameBoard.isFull()) {
            return "You win!";
        }
        return "You lose! The rule " + ruleBroken.getName() + " is broken! ";
    }

    public Rule getRuleBroken() {
        return ruleBroken;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public boolean isFullBoard() {
        return gameBoard.isFull();
    }

    public int getRows() {
        return this.gameBoard.getRows();
    }

    public int getColumns() {
        return this.gameBoard.getColumns();
    }
}