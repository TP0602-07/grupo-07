package ar.fiuba.tdd.nikoli.model.rules.factory;

import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.implementation.*;

import java.util.HashMap;

/**
 * Factory encargada de la creacion de objetos de diferentes clases de reglas.
 */
public class GameRulesFactory {

    private static final String NOT_REPEAT_NUMBER_RULE_NAME = "NotRepeatNumberRule";
    private static final String SUM_RULE_NAME = "SumRule";
    private static final String CORRECT_CIRCUIT_RULE_NAME = "CorrectCircuitRule";
    private static final String REGION_MULTIPLICATION_RULE_NAME = "RegionMultiplicationRule";
    private static final String PASSED_REGION_RULE = "PassedRegionRule";
    private static final String NON_CONTIGUOUS_EMPTY_INTER_REGION = "NonContiguousEmptyInterRegionRule";

    private static GameRulesFactory instance;
    private HashMap<String,Rule> rules;

    private GameRulesFactory() {
        rules = new HashMap<>(6);
        rules.put(NOT_REPEAT_NUMBER_RULE_NAME,new NotRepeatNumberRule());
        rules.put(SUM_RULE_NAME,new SumRule());
        rules.put(CORRECT_CIRCUIT_RULE_NAME,new CorrectCircuitRule());
        rules.put(REGION_MULTIPLICATION_RULE_NAME,new RegionMultiplicationRule());
        rules.put(PASSED_REGION_RULE,new PassedRegionRule());
        rules.put(NON_CONTIGUOUS_EMPTY_INTER_REGION,new NonContiguousEmptyInterRegionRule());
    }


    public static GameRulesFactory getInstance() {
        if (instance == null) {
            instance = new GameRulesFactory();
        }
        return instance;
    }

    public Rule createRuleByName(String ruleName) throws UnknownRuleException {
        Rule rule = rules.get(ruleName);
        if (rule == null) {
            throw new UnknownRuleException(ruleName + " rule is unknown");
        }
        return rule;

    }

}
