package ar.fiuba.tdd.nikoli.model.rules;

import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.factory.GameRulesFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class GameRulesFactoryTests {

    @Test
    public void testCreateRuleByNameOK() throws Exception {
        Rule rule = GameRulesFactory.getInstance().createRuleByName("NotRepeatNumberRule");
        assertNotNull(rule);
    }

    @Test(expected = UnknownRuleException.class)
    public void testCreateRuleByNameUnknownName() throws Exception {
        GameRulesFactory.getInstance().createRuleByName("SSumRule");
    }
}
