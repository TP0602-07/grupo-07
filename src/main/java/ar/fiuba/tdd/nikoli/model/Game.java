package ar.fiuba.tdd.nikoli.model;


import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import ar.fiuba.tdd.nikoli.model.rules.Rule;



public class Game {

    private GameRules gameRules;
    private GameBoard gameBoard;
    private Rule ruleBroken; //indicate that rule is broken

    public Game(GameRules gameRules, GameBoard gameBoard) {
        this.gameRules = gameRules;
        this.gameBoard = gameBoard;
        ruleBroken = null;
    }

    public void play(Move move) throws Exception { //TODO move es una Move (modificar)
        gameBoard.insert(move);
    }

    private boolean validate() {
        boolean isValid = true;
        for (Rule rule : gameRules.getRules()) {
        //    rule.buildRuleCellSets(gameBoard);
        //    if(rule.isRuleBroken()) {
            if (rule.isRuleBroken(gameBoard,new Move(new Position(1,1),1))) { //TODO borrar y descomentar arriba
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
        return "You lose!";
    }

    public Rule getRuleBroken() {
        return ruleBroken;
    }

    public boolean isFullBoard() {
        return gameBoard.isFull();
    }
}