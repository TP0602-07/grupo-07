package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.List;

/**
 * Clase abstracta que representa una regla de juego.
 */
public abstract class Rule {

    private String name;

    /**
     *
     * @return Rule's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Rule's name.
     * @param name Rule's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checkes whenever specific rule is broken.
     * @param cellSets Collection of CellSets.
     * @param move Player's move.
     * @return true if rule checks otherwise false.
     */
    public abstract boolean isRuleBroken(List<CellSet> cellSets, Move move);

    /**
     * Builds cells set for each specific rule.
     * @param board Reprecentation of Board.
     * @return List of CellSet used by Rule.
     */
    public abstract List<CellSet> buldRuleCellSets(GameBoardIterator board);
}
