package ar.fiuba.tdd.nikoli.conf;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.factory.GameRulesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la lectura de configuracion de las reglas de un juego.
 */
public class GameRulesConfigurationReader extends GameConfigurationReader<GameRules> {

    private static final String RULES_CONFIGURATION_TYPE = "rules";


    public GameRulesConfigurationReader() {
        this.clazz = GameRules.class;
    }


    @Override
    protected void process(GameRules gameRules) throws GameConfigurationException {
        List<Rule> rules = new ArrayList<Rule>();

        for (String name: gameRules.getRulesNames()) {
            try {
                Rule rule = GameRulesFactory.getInstance().createRuleByName(name);
                rules.add(rule);
            } catch (UnknownRuleException e) {
                throw new GameConfigurationException(e.getMessage());
            }
        }

        gameRules.setRules(rules);
    }

    @Override
    protected String getConfigurationType() {
        return RULES_CONFIGURATION_TYPE;
    }
}
