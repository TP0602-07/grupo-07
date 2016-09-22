package ar.fiuba.tdd.nikoli.rules;

import ar.fiuba.tdd.nikoli.model.GameBoard;

/**
 * Clase abstracta que representa una regla de juego
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
     * Metodo que checkea si el tablero rompe la regla de juego
     * @param board
     * @return
     */
    public abstract boolean isRuleBroken(GameBoard board);
}
