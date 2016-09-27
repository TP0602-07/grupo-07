package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.Move;

/**
 * Clase que representa la regla de no repetir numeros en una misma linea del tablero.
 */
public class RowNotRepeatNumberRule extends Rule {

    @Override
    public boolean isRuleBroken(GameBoardIterator board, Move move) {
        // TODO implementar logica
        return false;
    }
}
