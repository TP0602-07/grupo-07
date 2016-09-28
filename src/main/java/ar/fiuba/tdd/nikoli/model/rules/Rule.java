package ar.fiuba.tdd.nikoli.model.rules;

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
     * @return true if rule checks otherwise false.
     */
    public abstract boolean isRuleBroken();

    /**
     * Builds cells set for each specific rule.
     * @param board Reprecentation of Board.
     */
    public abstract void buildRuleCellSets(GameBoardIterator board);


}
