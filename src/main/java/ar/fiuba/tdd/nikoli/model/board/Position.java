package ar.fiuba.tdd.nikoli.model.board;

/**
 * Clase que modela una posicion en el tablero.
 */
public class Position {
    private int coordinateX;
    private int coordinateY;

    public Position(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }
}
