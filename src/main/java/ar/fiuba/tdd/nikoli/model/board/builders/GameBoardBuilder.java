package ar.fiuba.tdd.nikoli.model.board.builders;

import ar.fiuba.tdd.nikoli.conf.board.BoardJson;
import ar.fiuba.tdd.nikoli.conf.board.RegionLinkJson;
import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.RegionLink;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contruye un @{@link GameBoard}
 * a partir de los datos leidos desde el json.
 */
public class GameBoardBuilder {
    public static GameBoard build(BoardJson json) {
        GameBoard gameBoard = buildGameBoard(json);

        gameBoard.setIsCompleteBoard(json.isCompleteBoard());
        gameBoard.setRegions(json.getRegions());
        gameBoard.setRegionsLink(buildRegionsLink(json));

        return gameBoard;
    }

    private static List<RegionLink> buildRegionsLink(BoardJson json) {
        List<RegionLink> regions = new ArrayList<>();

        for (RegionLinkJson region: json.getRegionsLinkJson()) {
            RegionLink regionLink = RegionLinkBuilder.build(region);
            regions.add(regionLink);
        }

        return regions;
    }

    private static GameBoard buildGameBoard(BoardJson json) {
        Cell[][] matrix = buildMatrix(json.getRows(), json.getColumns());

        matrix = buildClueCells(matrix, json.getClueCells());

        GameBoard gameBoard = new GameBoard(matrix);

        return gameBoard;
    }

    /**
     * Construye las matriz con sus celdas a partir de la cantidad de filas y columnas ya establecidas.
     */
    private static Cell[][] buildMatrix(int rows, int columns) {
        Cell[][] matrix = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new Cell(new Position(i,j));
            }
        }

        return matrix;
    }


    private static Cell[][] buildClueCells(Cell[][] matrix, List<Cell> clueCells) {

        for (Cell cell: clueCells) {
            matrix[cell.getPosition().getX()][cell.getPosition().getY()] = cell;
        }

        return matrix;
    }
}
