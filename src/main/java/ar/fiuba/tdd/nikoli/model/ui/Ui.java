package ar.fiuba.tdd.nikoli.model.ui;

import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.Position;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;


/**
 * Created by ltessore on 28/09/16.
 */
public class Ui {
    private BufferedReader in;
    private Monitor monitor;
    private Game game;

    public Ui(Monitor monitor) {
        this.monitor = monitor;
        in = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));
    }

    public int start() {
        while (true) {
            try {
                Move move = getMove();
                this.game.play(move);
                if (this.game.isFullBoard()) {
                    monitor.show(this.game.checkVictory());
                    return 0;
                }
            } catch (IOException ioe) {
                monitor.show("Movimiento incorrecto. Por favor intentelo de nuevo");
            } catch (Exception e) {
                monitor.show("Fallo la jugada");
            }
        }

    }

    public int run() {
        while (true) {
            try {
                monitor.show("A que juego queres jugar?\n  1) Sudoku \n  2) Kakuro ");
                String userInput = in.readLine();
                if (userInput != null && isValidGame(userInput)) {
                    //TODO cargar juego
                }
                return start();

            } catch (IOException ioe) {
                monitor.show("Error de entrada");
                return -1;
            }
        }
    }

    //TODO devolver una excepcion adecuada y catchearla en run
    private Move getMoveFromInput(String input) throws IOException {
        //TODO
        String[] values = input.split(" ");
        int posX = Integer.valueOf(values[0]);
        int posY = Integer.valueOf(values[0]);
        int value = Integer.valueOf(values[0]);
        if (isValidEntry(posX) && isValidEntry(posY) && isValidEntry(value)) {
            return new Move(new Position(posX, posY), value);
        }
    }

    private boolean isValidGame(String input) {
        return ( input.equals("1") || input.equals("2"));
    }

    private Move getMove() throws IOException {
        monitor.show("Inserte el movimiento que desea realizar");
        String moveString = in.readLine();
        Move move = getMoveFromInput(moveString);
        return move;
    }

}
