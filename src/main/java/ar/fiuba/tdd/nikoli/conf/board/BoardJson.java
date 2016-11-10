package ar.fiuba.tdd.nikoli.conf.board;

import ar.fiuba.tdd.nikoli.model.board.Cell;
import ar.fiuba.tdd.nikoli.model.board.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase tiene objetivo almacenar los datos leido desde el json.
 */
public class BoardJson {
    private int rows;
    private int columns;
    private List<Cell> clueCells;
    private List<Region> regions;
    private List<RegionLinkJson> regionsLinkJson = new ArrayList<>();
    private boolean isCompleteBoard;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<Cell> getClueCells() {
        return clueCells;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public List<RegionLinkJson> getRegionsLinkJson() {
        return regionsLinkJson;
    }

    public boolean isCompleteBoard() {
        return isCompleteBoard;
    }
}

