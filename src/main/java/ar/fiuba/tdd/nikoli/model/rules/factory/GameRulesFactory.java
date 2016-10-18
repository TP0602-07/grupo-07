package ar.fiuba.tdd.nikoli.model.rules.factory;

import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.implementation.*;

/**
 * Factory encargada de la creacion de objetos de diferentes clases de reglas.
 */
public class GameRulesFactory {

    private static final String NOT_REPEAT_NUMBER_RULE_NAME = "NotRepeatNumberRule";
    private static final String SUM_RULE_NAME = "SumRule";
    private static final String CORRECT_CIRCUIT_RULE_NAME = "CorrectCircuitRule";
    private static final String REGION_MULTIPLICATION_RULE_NAME = "RegionMultiplicationRule";
    //TODO descomentar private static final String PASSED_REGION_RULE = "PassedRegionRule";
    //TODO descomentar private static final String NON_CONTIGUOUS_EMPTY_INTER_REGION = "NonContiguousEmptyInterRegionRule";

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
        } else if (REGION_MULTIPLICATION_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new RegionMultiplicationRule();
       //TODO decomentar, y arreglar error de duplicate code, o meter un ignore
            /* } else if (PASSED_REGION_RULE.equalsIgnoreCase(ruleName)) {
            return new PassedRegionRule();
        } else if (NON_CONTIGUOUS_EMPTY_INTER_REGION.equalsIgnoreCase(ruleName)) {
            return new NonContiguousEmptyInterRegionRule();*/
        } else {
            throw new UnknownRuleException(ruleName + " rule is unknown");
        }
    }

}
