package ar.fiuba.tdd.nikoli.model;


import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import ar.fiuba.tdd.nikoli.model.rules.Rule;



public class Game {

    private GameRules gameRules;
    private GameBoard gameBoard;
    private Rule ruleBroken; //indica que regla se rompio al final del juego

    public Game(GameRules gameRules, GameBoard gameBoard) {
        this.gameRules = gameRules;
        this.gameBoard = gameBoard;
        ruleBroken = null;
    }

    public boolean play(int move) { //TODO move es una Move (modificar)
        //return gameBoard.insert(move);
        return true;
    }

    private boolean validate() {
        boolean isValid = true;
        for (Rule rule : gameRules.getRules()) {
            if (rule.isRuleBroken(gameBoard,new Move(new Position(1,1),1))) { //TODO
                isValid = false;
                ruleBroken = rule;
            }
        }
        return isValid;
    }

    public boolean checkVictory() {
//        if (gameBoard.isFull() && this.validate()) { //TODO
        if (this.validate()) {
            return true;
        }
        return false;
    }

    public Rule getRuleBroken() {
        return ruleBroken;
    }
}