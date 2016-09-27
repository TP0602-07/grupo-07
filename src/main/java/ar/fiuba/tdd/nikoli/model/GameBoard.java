package ar.fiuba.tdd.nikoli.model;

import java.util.List;

/**
 * Clase que representa el tablero de juego.
 */
public class GameBoard {

    private List<List<Integer>> gameMatrix;

    public GameBoard() { }


    public List<List<Integer>> getGameMatrix() {
        return gameMatrix;
    }

    public void setGameMatrix(List<List<Integer>> gameMatrix) {
        this.gameMatrix = gameMatrix;
    }


}
