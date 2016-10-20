package ar.fiuba.tdd.nikoli;

import ar.fiuba.tdd.nikoli.ui.ConsoleMonitor;
import ar.fiuba.tdd.nikoli.ui.Monitor;
import ar.fiuba.tdd.nikoli.ui.Ui;

/**
 * Created by emmanuel on 29/09/16.
 */
public class MainNikoliUi {

    public static void main(String[] args) {
        Monitor monitor = new ConsoleMonitor();

        Ui ui = new Ui(monitor);

        ui.run();
    }
}
