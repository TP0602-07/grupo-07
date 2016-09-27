package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.Move;

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
     * Metodo que checkea si el tablero rompe la regla de juego.
     * @param board tablero de juego
     * @return true si no se cumple la regla y false si se cumple
     */
    public abstract boolean isRuleBroken(GameBoardIterator board, Move move);
}
