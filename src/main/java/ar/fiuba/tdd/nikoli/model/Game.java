package ar.fiuba.tdd.nikoli.model;


import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.exception.InvalidPlayException;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.plays.Play;

public class Game {

    private GameRules gameRules;
    private GameBoard gameBoard;
    private Rule ruleBroken; //indicate that rule is broken

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final String MOVE_INCORRECT =  ANSI_RED + "Incorrect Play. Please try again\n" + ANSI_RESET;

    public Game(GameRules gameRules, GameBoard gameBoard) {
        this.gameRules = gameRules;
        this.gameBoard = gameBoard;
        ruleBroken = null;
    }

    /**
     * Chequea validez de la jugada y lo inserta en el tablero en caso afirmativo.
     * @param play instancia de {@link Play}.
     * @throws InvalidPlayException si se produjo un error en el procesamiento de las reglas del juego.
     */
    public void play(Play play) throws InvalidPlayException {
        gameBoard.insertValue(play);
        this.validate(play);
    }

    private void validate(Play play) throws InvalidPlayException {
        for (Rule rule : gameRules.getRules()) {
            if (rule.isRuleBroken(gameBoard, play.getPosition())) {
                ruleBroken = rule;
                if (!isFullBoard()) {
                    throw new InvalidPlayException(MOVE_INCORRECT);
                }
            }
        }
    }

    public String checkVictory() {
        if (ruleBroken == null) {
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
        return gameBoard.isFull() && gameBoard.isCompleteBoard();
    }

    public int getRows() {
        return this.gameBoard.getRows();
    }

    public int getColumns() {
        return this.gameBoard.getColumns();
    }
}