package ar.fiuba.tdd.nikoli.model;


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

    public void play(Move move) throws IOException {
        gameBoard.insertValue(move);
    }

    private boolean validate() {
        boolean isValid = true;
        for (Rule rule : gameRules.getRules()) {
            if (rule.isRuleBroken(gameBoard.getRegions())) {
                isValid = false;
                ruleBroken = rule;
            }
        }
        return isValid;
    }

    public String checkVictory() {
        if (gameBoard.isFull() && this.validate()) {
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