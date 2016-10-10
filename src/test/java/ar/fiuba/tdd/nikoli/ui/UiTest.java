package ar.fiuba.tdd.nikoli.ui;

import ar.fiuba.tdd.nikoli.conf.exception.InvalidUserInputException;
import ar.fiuba.tdd.nikoli.model.Move;
import ar.fiuba.tdd.nikoli.model.ui.ConsoleMonitor;
import ar.fiuba.tdd.nikoli.model.ui.Monitor;
import ar.fiuba.tdd.nikoli.model.ui.Ui;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ltessore on 10/10/16.
 */
public class UiTest {

    private Ui getGenericUi() {
        Monitor monitor = new ConsoleMonitor();
        Ui ui = new Ui(monitor);
        return ui;
    }

    @Test
    public void testGetMoveByInputOKCase1() throws Exception {
        Ui ui = getGenericUi();
        Move move = ui.getMove("1 1");
        assertNotNull(move);
    }

    @Test
    public void testGetMoveByInputOKCase2() throws Exception {
        Ui ui = getGenericUi();
        Move move = ui.getMove("1 1 1");
        assertNotNull(move);
    }

    @Test(expected = InvalidUserInputException.class)
    public void testGetMoveByInputOutOfLimits1() throws Exception {
        Ui ui = getGenericUi();
        Move move = ui.getMove("-1 1 1");
    }

    @Test(expected = InvalidUserInputException.class)
    public void testGetMoveByInputOutOfLimits2() throws Exception {
        Ui ui = getGenericUi();
        Move move = ui.getMove("1 10 1");
    }

    @Test(expected = InvalidUserInputException.class)
    public void testGetMoveByInputIncorrectAmountParameters1() throws Exception {
        Ui ui = getGenericUi();
        Move move = ui.getMove("1 10 1 5");
    }

    @Test(expected = InvalidUserInputException.class)
    public void testGetMoveByInputIncorrectAmountParameters2() throws Exception {
        Ui ui = getGenericUi();
        Move move = ui.getMove("1");
    }


}
