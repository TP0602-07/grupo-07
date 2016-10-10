package ar.fiuba.tdd.nikoli.model.ui;

import ar.fiuba.tdd.nikoli.conf.GameConfigurationReader;
import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.conf.exception.InvalidMoveException;
import ar.fiuba.tdd.nikoli.conf.exception.InvalidUserInputException;
import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Ui {
    private GameConfigurationReader reader;
    private BufferedReader in;
    private Monitor monitor;
    private Game game;
    private static String selectGame = "Which game you want to choose?\n"
                                        + "  1) Sudoku\n"
                                        + "  2) Kakuro\n"
                                        + "  3) Country Road\n"
                                        + "  4) SlitherLink\n"
                                        + "  5) Gogiken Naname\n"
                                        + "  6) Ishi No Heya.\n";
    private static String inputSeparator = " ";


    public Ui(Monitor monitor) {
        this.monitor = monitor;
        in = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));
        reader = new GameConfigurationReader();
    }

    public int startGame() {
        while (true) {
            try {
                monitor.viewBoard(this.game.getGameBoard());
                monitor.show("Insert the movement that you want to: ");
                String moveString = in.readLine();
                if ( moveString != null) {
                    if (moveString.equals("Q") || moveString.equals("q")) {
                        monitor.show("End the game\n");
                        return -1;
                    }
                    Move move = getMove(moveString);
                    this.game.play(move);
                    monitor.viewBoard(this.game.getGameBoard());
                    if (this.game.isFullBoard()) {
                        monitor.show(this.game.checkVictory());
                        return 0;
                    }
                }
            } catch (InvalidMoveException | InvalidUserInputException e ) {
                monitor.show(e.getMessage());
            } catch (IOException e) {
                monitor.show("Input error. Please try again\n");
            }
        }
    }

    public int run() {
        while (true) {
            try {
                monitor.show(selectGame);
                String userInput = in.readLine();
                if (userInput != null && isValidGame(userInput)) {
                    this.buildGame(userInput);
                    return startGame();
                } else {
                    monitor.show("Incorrect selection. Please try again\n");
                }
            } catch (IOException ioe) {
                monitor.show("Invalid user input. Please try again\n");
                return -1;
            } catch (GameConfigurationException gce) {
                monitor.show(gce.getMessage());
                return -1;
            }
        }
    }

    private String getNameFromOption(String option) {
        String gameName = "";
        if (option.equals("1")) {
            gameName = "sudoku";
        } else if (option.equals("2")) {
            gameName = "kakuro";
        } else if (option.equals("3")) {
            gameName = "country-road";
        } else if (option.equals("4")) {
            gameName = "slither-link";
        } else if (option.equals("5")) {
            gameName = "gogiken-naname";
        } else if (option.equals("6")) {
            gameName = "ishi-no-heya";
        }
        return gameName;
    }

    private void buildGame(String option) throws GameConfigurationException {
        String gameName = this.getNameFromOption(option);
        GameRules rules = reader.readGameRulesConfiguration(gameName);
        GameBoard board = reader.readGameBoardConfiguration(gameName);
        this.game = new Game(rules, board);
    }

    private Move getMoveFromInput(String input) throws InvalidUserInputException {
        String[] values = input.split(inputSeparator);
        int posX = 0;
        int posY = 0;
        int value = 0; //default
        if (values.length == 3) {
            posX = Integer.parseInt(values[0]);
            posY = Integer.parseInt(values[1]);
            value = Integer.parseInt(values[2]);
        } else if (values.length == 2) {
            posX = Integer.parseInt(values[0]);
            posY = Integer.parseInt(values[1]);
        }
        if (isValidEntry(posX) && isValidEntry(posY) && (value == 0 | isValidEntry(value))) {
            return new Move(new Position(posX, posY), value);
        } else {
            throw new InvalidUserInputException("Invalid input. Please try again\n");
        }
    }

    private boolean isValidEntry(int val) {
        return ( val > 0 && val < 10 );
    }

    private boolean isValidGame(String input) {
        return (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")
                || input.equals("5") || input.equals("6"));
    }

    public Move getMove(String moveString) throws InvalidUserInputException {
        return getMoveFromInput(moveString);
    }

}
