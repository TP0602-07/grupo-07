package ar.fiuba.tdd.nikoli.model.ui;


/**
 * Created by ltessore on 28/09/16.
 */
public class ConsoleMonitor extends Monitor {

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    public void viewBoard() {
        //TODO
        System.out.println("aca se imprime el tablero");
    }
}
