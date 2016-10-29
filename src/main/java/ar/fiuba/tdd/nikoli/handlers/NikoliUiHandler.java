package ar.fiuba.tdd.nikoli.handlers;

import ar.fiuba.tdd.nikoli.ui.ConsoleMonitor;
import ar.fiuba.tdd.nikoli.ui.Monitor;
import ar.fiuba.tdd.nikoli.ui.Ui;

/**
 * Clase encargada de correr el juego utilizando la UI e interactuando con el usuario.
 */
public class NikoliUiHandler {

    private Ui ui;


    public NikoliUiHandler() {
        Monitor monitor = new ConsoleMonitor();
        this.ui = new Ui(monitor);
    }

    public String runGameSelector() {
        return this.ui.runGameSelector();
    }

    public void runGame(String gameName) {
        ui.run(gameName);
    }
}
