package ar.fiuba.tdd.nikoli.model.ui;

import ar.fiuba.tdd.nikoli.conf.GameConfigurationReader;
import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/**
 * Created by ltessore on 28/09/16.
 */
public class Ui {
    private GameConfigurationReader reader;
    private BufferedReader in;
    private Monitor monitor;
    private Game game;

    public Ui(Monitor monitor) {
        this.monitor = monitor;
        in = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));
        reader = new GameConfigurationReader();
    }

    public int start() {
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
            } catch (IOException ioe) {
                monitor.show("Incorrect Move. Please try again\n");
            }
        }

    }

    public int run() {
        while (true) {
            try {
                monitor.show("Which game you want to choose?\n  1) Sudoku \n  2) Kakuro ");
                String userInput = in.readLine();
                if (userInput != null && isValidGame(userInput)) {
                    buildGame(userInput);
                }
                return start();

            } catch (IOException ioe) {
                monitor.show("Incorrect selection. Please try again");
                return -1;
            } catch (GameConfigurationException gce) {
                monitor.show("Error loading game");
                return -1;
            }
        }
    }

    private void buildGame(String option) throws GameConfigurationException {
        String gameName = "";
        if (option.equals("1")) {
            gameName = "sudoku";
        } else {
            gameName = "kakuro";
        }
        //OldGameBoard board = reader.readGameBoardConfiguration(gameName);
        GameRules rules = reader.readGameRulesConfiguration(gameName);
        this.game = new Game(rules,null);

    }

    private Move getMoveFromInput(String input) throws IOException {
        String[] values = input.split(" ");
        int posX = Integer.parseInt(values[0]);
        int posY = Integer.parseInt(values[0]);
        int value = Integer.parseInt(values[0]);
        if (isValidEntry(posX) && isValidEntry(posY) && isValidEntry(value)) {
            return new Move(new Position(posX, posY), value);
        } else {
            throw new IOException();
        }
    }

    private boolean isValidEntry(int val) {
        return ( val > 0 && val < 10 );
    }

    private boolean isValidGame(String input) {
        return ( input.equals("1") || input.equals("2"));
    }

    private Move getMove(String moveString) throws IOException {
        Move move = getMoveFromInput(moveString);
        return move;
    }

}
