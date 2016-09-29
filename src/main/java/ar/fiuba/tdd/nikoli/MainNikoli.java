package ar.fiuba.tdd.nikoli;

import ar.fiuba.tdd.nikoli.model.ui.ConsoleMonitor;
import ar.fiuba.tdd.nikoli.model.ui.Monitor;
import ar.fiuba.tdd.nikoli.model.ui.Ui;

/**
 * Created by emmanuel on 29/09/16.
 */
public class MainNikoli {

    public static void main(String[] args) {
        Monitor monitor = new ConsoleMonitor();

        Ui ui = new Ui(monitor);

        ui.run();
    }
}
