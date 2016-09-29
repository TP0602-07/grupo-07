package ar.fiuba.tdd.nikoli.model.rules.factory;

import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.implementation.*;

/**
 * Factory encargada de la creacion de objetos de diferentes clases de reglas.
 */
public class GameRulesFactory {

    private static final String KAKURO_NOT_REPEAT_NUMBER_RULE_NAME = "KakuroNotRepeatNumberRule";
    private static final String KAKURO_SUM_RULE_NAME = "KakuroSumRule";
    private static final String SUDOKU_NOT_REPEAT_NUMBER_RULE_NAME = "SudokuNotRepeatNumberRule";

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
        if (KAKURO_NOT_REPEAT_NUMBER_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new KakuroNotRepeatNumberRule();
        } else if (KAKURO_SUM_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new KakuroSumRule();
        } else if (SUDOKU_NOT_REPEAT_NUMBER_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new SudokuNotRepeatNumberRule();
        } else {
            throw new UnknownRuleException(ruleName + " rule is unknown");
        }
    }

}
