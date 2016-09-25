package ar.fiuba.tdd.nikoli.model.builder;

import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.rules.Rule;
import java.util.Iterator;
import java.util.List;


class Builder {

    protected Game game;

    public Builder(Game game) {
        this.game = game;
    }

    public void createConditions(List<Rule> rules) {
        Iterator<Rule> rulesIterator = rules.iterator();
        while (rulesIterator.hasNext()) {
            game.addCondition(rulesIterator.next());
        }
    }
    public void createRules(String rules) {
        game.setRules(rules);
    }
}