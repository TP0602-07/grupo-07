package ar.fiuba.tdd.nikoli.plays;

import ar.fiuba.tdd.nikoli.model.board.Position;

/**
 * Clase que modela la jugada ingresada por el usuario.
 */
public class Play {
    private int number;
    private int[] position = new int[2];
    private int value;
    private String action;

    public Play(int row, int column , int value) {
        this.number = 0;
        this.position[0] = row;
        this.position[1] = column;
        this.value = value;
    }

    public Play(int number, int row, int column, int value) {
        this.number = number;
        this.position[0] = row;
        this.position[1] = column;
        this.value = value;
    }

    public int getNumber() {
        return this.number;
    }

    public Position getPosition() {
        return new Position(this.position[0], this.position[1]);
    }

    public int getValue() {
        return this.value;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
