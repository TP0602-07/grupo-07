package ar.fiuba.tdd.nikoli.ui;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.GameBuilder;
import ar.fiuba.tdd.nikoli.plays.Play;
import ar.fiuba.tdd.nikoli.ui.exception.InvalidUserInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


public class Ui {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String INPUT_ERROR = ANSI_RED + "Input error. Please try again\n" + ANSI_RESET;
    private static final String INPUT_INVALID = ANSI_RED + "Invalid input. Please try again\n" + ANSI_RESET;
    private static String selectGame = "Which game you want to choose?\n"
                                        + "  1) Sudoku\n"
                                        + "  2) Kakuro\n"
                                        + "  3) Ishi No Heya.\n"
                                        + "  4) Country Road\n"
                                        + "  5) SlitherLink\n"
                                        + "  6) Gogiken Naname\n"
                                        + "  7) NiKoli2019\n";
    private static String inputSeparator = " ";
    private BufferedReader in;
    private Monitor monitor;
    private Game game;
    private  HashMap<String,String> games;

    public Ui(Monitor monitor) {
        this.monitor = monitor;
        in = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));
        this.games = new HashMap<>(7);
        this.games.put("1","sudoku");
        this.games.put("2","kakuro");
        this.games.put("3","inshinoheya");
        this.games.put("4","countryroad");
        this.games.put("5","slitherlink");
        this.games.put("6","niKoli2019");
    }

    private int startGame() {
        while (true) {
            try {
                monitor.viewBoard(this.game.getGameBoard());
                monitor.show("Insert the movement that you want to: <position X> <position Y> <value> (enter zero value to delete)");
                String moveString = in.readLine();
                if ( moveString != null) {
                    if (moveString.equals("Q") || moveString.equals("q")) {
                        monitor.show("End the game\n");
                        return -1;
                    }
                    Play play = getPlay(moveString);
                    this.game.makePlay(play);
                    if (this.game.isFullBoard()) {
                        monitor.viewBoard(this.game.getGameBoard());
                        monitor.show(this.game.getMessageFinalResult());
                        return 0;
                    }
                }
            } catch ( InvalidUserInputException e ) {
                monitor.show(ANSI_RED + e.getMessage() + ANSI_RESET);
            } catch (IOException e) {
                monitor.show(INPUT_ERROR);
            }
        }
    }

    public int run(String gameName) {
        while (true) {
            try {
                this.buildGame(gameName);
                return startGame();
            } catch (GameConfigurationException gce) {
                monitor.show(gce.getMessage());
                return -1;
            }
        }
    }


    public String runGameSelector() {
        String gameName = null;
        while (gameName == null) {
            try {
                monitor.show(selectGame);
                String userInput = in.readLine();
                if (userInput != null && isValidGame(userInput)) {
                    gameName = this.getNameFromOption(userInput);
                } else {
                    monitor.show("Incorrect selection. Please try again\n");
                }
            } catch (IOException ioe) {
                monitor.show("Invalid user input. Please try again\n");
            }
        }

        return gameName;
    }

    private String getNameFromOption(String option) {
        String gameName = games.get(option);
        if (gameName == null) {
            return "";
        }
        return gameName;
    }


    private void buildGame(String gameName) throws GameConfigurationException {
        this.game = GameBuilder.buildGame(gameName);
    }

    private Play getPlayFromInput(String input) throws InvalidUserInputException {
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
        if (isValidCoordinate(posX) && isValidCoordinate(posY) && (value == 0 | isValidEntry(value))) {
            return new Play(posX - 1, posY - 1, value);
        } else {
            throw new InvalidUserInputException(INPUT_INVALID);
        }
    }

    private boolean isValidCoordinate(int val) {
        return ( val > 0 && val <= this.game.getColumns() );
    }

    private boolean isValidEntry(int val) {
        return ( val > 0 && val < 10 );
    }

    private boolean isValidGame(String input) {
        return (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")
                || input.equals("5") || input.equals("6") || input.equals("7"));
    }

    public Play getPlay(String moveString) throws InvalidUserInputException {
        return getPlayFromInput(moveString);
    }

}
