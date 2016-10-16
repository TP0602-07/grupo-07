package ar.fiuba.tdd.nikoli.ui;

import ar.fiuba.tdd.nikoli.plays.Play;
import ar.fiuba.tdd.nikoli.ui.exception.InvalidUserInputException;

import org.junit.Test;


/**
 * Created by ltessore on 10/10/16.
 */
public class UiTest {

    private Ui getGenericUi() {
        Monitor monitor = new ConsoleMonitor();
        Ui ui = new Ui(monitor);
        return ui;
    }

    @Test(expected = InvalidUserInputException.class)
    public void testGetMoveByInputOutOfLimits1() throws Exception {
        Ui ui = getGenericUi();
        Play play = ui.getPlay("-1 1 1");
    }

    @Test(expected = InvalidUserInputException.class)
    public void testGetMoveByInputIncorrectAmountParameters1() throws Exception {
        Ui ui = getGenericUi();
        Play play = ui.getPlay("1 10 1 5");
    }

    @Test(expected = InvalidUserInputException.class)
    public void testGetMoveByInputIncorrectAmountParameters2() throws Exception {
        Ui ui = getGenericUi();
        Play play = ui.getPlay("1");
    }
}
