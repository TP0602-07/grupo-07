package ar.fiuba.tdd.nikoli.model.board;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una region dentro del tablero.
 */
public class Region {

    private List<Position> positions;
    private Integer value;


    public Region() {
        this.positions = new ArrayList<>();
    }

    public List<Position> getPositions() {
        return this.positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
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
        // TODO implementar
        return true;
    }

}
