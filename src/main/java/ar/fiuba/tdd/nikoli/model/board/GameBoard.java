package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.model.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela el tablero de un juego.
 */
public class GameBoard {

    private int rows;
    private int columns;
    private List<Cell> cells;
    private List<Region> regions;
    private Cell[][] matrix;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.cells = new ArrayList<Cell>();
        this.regions = new ArrayList<Region>();

        this.matrix = new Cell[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
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
        // TODO implementar
        return new ArrayList<Region>();
    }

    /**
     * Agrego este metodo para que el findbugs no tire error.
     * @return todas las celdas del tablero.
     */
    public Cell[][] getMatrix() {
        // TODO si no sirve eliminarlo el metodo
        return this.matrix.clone();
    }

    /**
     * Indica si el tablero tiene completas todas sus celdas.
     *
     * @return true si la el tablero esta completo.
     */
    public boolean isFull() {
        boolean isFull = true;
        for (Cell[] row : matrix) {
            for (Cell column : row) {
                if (column.isEditable() && !column.hasValue()) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    /**
     * Insert el valor de la jugada en la posicion indicada por al juegada.
     *
     * @param move jugada a insertar en el tablero.
     */
    public void insertValue(Move move) {
        Cell cell = matrix[move.getPosition().getX()][move.getPosition().getY()];

        cell.setValue(move.getValue());
    }

}
