package ar.fiuba.tdd.nikoli.rules;

import java.util.List;

/**
 * Objeto que contiene todas las reglas de un juego.
 */
public class GameRules {

    private String gameName;

    private List<String> rulesNames;

    private List<Rule> rules;


    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<String> getRulesNames() {
        return rulesNames;
    }

    public void setRulesNames(List<String> rulesNames) {
        this.rulesNames = rulesNames;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }


}
