package ar.fiuba.tdd.nikoli.model.rules.factory;

import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.implementation.CorrectCircuitRule;
import ar.fiuba.tdd.nikoli.model.rules.implementation.NotRepeatNumberRule;
import ar.fiuba.tdd.nikoli.model.rules.implementation.SumRule;

/**
 * Factory encargada de la creacion de objetos de diferentes clases de reglas.
 */
public class GameRulesFactory {

    private static final String NOT_REPEAT_NUMBER_RULE_NAME = "NotRepeatNumberRule";
    private static final String SUM_RULE_NAME = "SumRule";
    private static final String CORRECT_CIRCUIT_RULE_NAME = "CorrectCircuitRule";

    private static GameRulesFactory instance;

    private GameRulesFactory() { }


    public static GameRulesFactory getInstance() {
        if (instance == null) {
            instance = new GameRulesFactory();
        }

        return instance;
    }

    public Rule createRuleByName(String ruleName) throws UnknownRuleException {
        //TODO: We should use reflection here!
        if (NOT_REPEAT_NUMBER_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new NotRepeatNumberRule();
        } else if (SUM_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new SumRule();
        } else if (CORRECT_CIRCUIT_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new CorrectCircuitRule();
        } else {
            throw new UnknownRuleException(ruleName + " rule is unknown");
        }
    }

}
