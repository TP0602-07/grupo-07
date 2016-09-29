package ar.fiuba.tdd.nikoli.model;

import ar.fiuba.tdd.nikoli.model.board.Position;

/**
 * Clase que modela la jugada ingresada por el usuario.
 */
public class Move {
    private Position position;
    private int value;

    public Move(Position position, int value) {
        this.position = position;
        this.value = value;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getValue() {
        return value;
    }
}
