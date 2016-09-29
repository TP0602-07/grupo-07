package ar.fiuba.tdd.nikoli.model.rules.factory;

import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.implementation.NotRepeatNumberRule;

/**
 * Factory encargada de la creacion de objetos de diferentes clases de reglas.
 */
public class GameRulesFactory {

    private static final String NOT_REPEAT_NUMBER_RULE_NAME = "not-repeat-number";

    private static GameRulesFactory instance;

    private GameRulesFactory() { }


    public static GameRulesFactory getInstance() {
        if (instance == null) {
            instance = new GameRulesFactory();
        }

        return instance;
    }

    public Rule createRuleByName(String ruleName) throws UnknownRuleException {
        // TODO ver si se puede implementar de otra forma
        if (NOT_REPEAT_NUMBER_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new NotRepeatNumberRule();
        } else {
            throw new UnknownRuleException(ruleName + " rule is unknown");
        }
    }

}
