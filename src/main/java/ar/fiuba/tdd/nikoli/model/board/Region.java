package ar.fiuba.tdd.nikoli.model.board;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una region dentro del tablero.
 */
public class Region {

    private List<Cell> cells;
    private Integer value;


    public Region() {
        this.cells = new ArrayList<>();
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    /**
     * Metodo que verifica que las celdas de la region tiene un valor definido.
     * @return true si las celdas estan completas, false en caso contrario.
     */
    public boolean isRegionFull() {
        return false;
    }


    /**
     * Metodo que verifica si una region contiene una celda de una posicion dada.
     * @param position posicion a verificar.
     * @return true si la region contiene una celda en una posicion dada, false en caso contrario.
     */
    public boolean containsPosition(Position position) {
        return true;
    }

}
