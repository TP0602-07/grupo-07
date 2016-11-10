package ar.fiuba.tdd.nikoli;

import ar.fiuba.tdd.nikoli.handlers.NikoliJsonHandler;
import ar.fiuba.tdd.nikoli.handlers.NikoliUiHandler;

public class NikoliMain {

    public static void main(String[] args) {

        NikoliUiHandler uiHandler = new NikoliUiHandler();
      //  NikoliJsonHandler jsonHandler = new NikoliJsonHandler();

        String gameSelected = uiHandler.runGameSelector();
        uiHandler.runGame(gameSelected);
        //jsonHandler.runGame(gameSelected);
    }
}
