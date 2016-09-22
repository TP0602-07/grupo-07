package ar.fiuba.tdd.nikoli.rules.factory;

import ar.fiuba.tdd.nikoli.rules.ColumnNotRepeatNumberRule;
import ar.fiuba.tdd.nikoli.rules.RowNotRepeatNumberRule;
import ar.fiuba.tdd.nikoli.rules.Rule;
import ar.fiuba.tdd.nikoli.rules.exception.UnknownRuleException;

/**
 * Factory encargada de la creacion de objetos de diferentes clases de reglas
 */
public class GameRulesFactory {

    private final static String ROW_NOT_REPEAT_NUMBER_RULE_NAME = "row-not-repeat-number";
    private final static String COLUMN_NOT_REPEAT_NUMBER_RULE_NAME = "column-not-repeat-number";

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
        if(ROW_NOT_REPEAT_NUMBER_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new RowNotRepeatNumberRule();
        } else if(COLUMN_NOT_REPEAT_NUMBER_RULE_NAME.equalsIgnoreCase(ruleName)) {
            return new ColumnNotRepeatNumberRule();
        } else {
            throw new UnknownRuleException(ruleName);
        }
    }

}
