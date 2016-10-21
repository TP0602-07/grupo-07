package ar.fiuba.tdd.nikoli.handlers;

import ar.fiuba.tdd.nikoli.ui.ConsoleMonitor;
import ar.fiuba.tdd.nikoli.ui.Monitor;
import ar.fiuba.tdd.nikoli.ui.Ui;

/**
 * Clase encargada de correr el juego utilizando la UI e interactuando con el usuario.
 */
public class NikoliUiHandler {

    public void runGame() {
        Monitor monitor = new ConsoleMonitor();
        Ui ui = new Ui(monitor);
        ui.run();
    }
}
