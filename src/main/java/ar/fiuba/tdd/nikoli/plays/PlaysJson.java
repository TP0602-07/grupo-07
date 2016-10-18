package ar.fiuba.tdd.nikoli.plays;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que modela la base de JSONs de jugadas, ya sea de jugadas propiamente dichas
 * o de resultados.
 */
public abstract class PlaysJson<T> {

    private List<T> plays;

    public PlaysJson() {
        this.plays = new ArrayList<T>();
    }

    public List<T> getPlays() {
        return this.plays;
    }

    public void setPlays(List<T> plays) {
        this.plays = plays;
    }
}
