package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.board.GameBoard;
import ar.fiuba.tdd.nikoli.model.board.Position;

/**
 * Clase abstracta que representa una regla de juego.
 */
public abstract class Rule {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Valida si la regla fue rota.
     * @return true si la regla fue rota sino false.
     */
    public abstract boolean isRuleBroken(GameBoard board, Position position);
}
