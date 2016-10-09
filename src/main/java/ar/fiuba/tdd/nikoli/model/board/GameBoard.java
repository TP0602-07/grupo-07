package ar.fiuba.tdd.nikoli.model.board;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela el tablero de un juego.
 */
public class GameBoard {

    private int rows;
    private int columns;
    private List<Cell> clueCells;
    private List<Region> regions;
    private Cell[][] matrix;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.clueCells = new ArrayList<Cell>();
        this.regions = new ArrayList<Region>();
        this.matrix = new Cell[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Cell> getClueCells() {
        return clueCells;
    }

    public void setClueCells(List<Cell> cells) {
        this.clueCells = cells;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }


    /**
     * Metodo que devuelve las regiones relacionadas a una posicion.
     * @param position posicion de la que se necesitan las regiones
     * @return regiones que se encuentren en una posicion
     */
    public List<Region> getRegionsForPosicion(Position position) {
        List<Region> regionsForPosition = new ArrayList<Region>();

        // TODO: puede reemplazarse usando streams api
        for (Region region : this.getRegions()) {
            if (region.containsPosition(position)) {
                regionsForPosition.add(region);
            }
        }

        return regionsForPosition;
    }

    /**
     * Agrego este metodo para que el findbugs no tire error.
     * @return todas las celdas del tablero.
     */
    public Cell[][] getMatrix() {
        // TODO si no sirve eliminarlo
        return this.matrix.clone();
    }

}
