package ar.fiuba.tdd.nikoli.model;


import ar.fiuba.tdd.nikoli.rules.GameRules;
import ar.fiuba.tdd.nikoli.rules.Rule;

import java.util.List;


public class Game {

    private GameRules gameRules;
    private GameBoard gameBoard;
    private Rule ruleBroken; //indica que regla se rompio al final del juego

    public Game (GameRules gameRules, GameBoard gameBoard) {
        this.gameRules = gameRules;
        this.gameBoard = gameBoard;
        ruleBroken = null;
    }
    public boolean play (int move) { //TODO move es una Move (modificar)
        return gameBoard.insert(move);
    }

    private boolean validate() {
        boolean isValid = true;
        for (Rule rule : gameRules.getRules()) {
            if (rule.isRuleBroken(gameBoard)){
                isValid = false;
                ruleBroken = rule;
            }
        }
        return isValid;
    }

    public boolean checkVictory() {
        if (gameBoard.isFull() && this.validate()) {
            return true;
        }
        return false;
    }

}