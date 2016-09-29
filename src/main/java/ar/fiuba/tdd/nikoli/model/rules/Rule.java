package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.rules.sets.CellSet;

import java.util.List;
/**
 * Clase abstracta que representa una regla de juego.
 */
public abstract class Rule<T> {

    private SetBuilder<? extends T> setBuilder;
    private RuleValidator<T> ruleValidator;

    private String name;

    protected Rule(SetBuilder<? extends T> setBuilder,
                   RuleValidator<T> ruleValidator) {

        this.setBuilder = setBuilder;
        this.ruleValidator = ruleValidator;
    }

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
     * Checks whenever specific rule is broken.
     * @return true if rule checks otherwise false.
     */
    public boolean isRuleBroken(GameBoardIterator board) {

        return ruleValidator.isRuleBroken(setBuilder, board);
    }
}
