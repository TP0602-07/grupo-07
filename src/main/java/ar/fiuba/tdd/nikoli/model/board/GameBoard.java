package ar.fiuba.tdd.nikoli.model.board;

import ar.fiuba.tdd.nikoli.conf.exception.InvalidMoveException;
import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.board.exception.CellNotEditableException;

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
        return this.matrix.clone();
    }

    /**
     * Indica si el tablero tiene completas todas sus celdas.
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
     * Insert el valor de la jugada en la posicion indicada por la jugada.
     * @param move jugada a insertar en el tablero.
     */
    public void insertValue(Move move) throws InvalidMoveException {

        try {
            matrix[move.getPosition().getX()][move.getPosition().getY()].setValue(move.getValue());
        } catch (CellNotEditableException e) {
            throw new InvalidMoveException(e.getMessage());
        }
    }

    /**
     * Obtiene el valor de la celda que esta en la posicion indicada.
     * @param position de la celda de que se quiere obtener su valor.
     * @return Devuelve el valor de la celda que esta en la posicion indicada.
     */
    public Integer getValueForPosition(Position position) {
        Cell cell = matrix[position.getX()][position.getY()];
        return cell.getValue();
    }

    /**
     * Construye las matriz con sus celdas a partir de la cantidad de filas y columnas ya establecidas.
     */
    public void buildMatrix() {
        this.matrix = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = new Cell(new Position(i,j));
            }
        }
    }

    /**
     * Inserta la celdas pistas en la matriz.
     */
    public void buildClueCells() {

        for (Cell cell: this.clueCells) {
            this.matrix[cell.getPosition().getX()][cell.getPosition().getY()] = cell;
        }
    }



}
