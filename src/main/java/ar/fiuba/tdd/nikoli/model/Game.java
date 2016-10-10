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
        this.validate(move);
        gameBoard.insertValue(move);
    }

    private void validate(Move move) throws InvalidMoveException {
        for (Rule rule : gameRules.getRules()) {
            if (rule.isRuleBroken(gameBoard, move.getPosition())) {
                ruleBroken = rule;
                throw new InvalidMoveException("Incorrect Move. Please try again\n");
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
}