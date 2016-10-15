package ar.fiuba.tdd.nikoli.plays;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase usada para modelar una seria de jugadas realizadas por el usuario.
 */
public class PlaysList {

    private List<Play> plays;


    public PlaysList() {
        this.plays = new ArrayList<Play>();
    }

    public List<Play> getPlays() {
        return this.plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

}
