package ar.fiuba.tdd.nikoli;


import ar.fiuba.tdd.nikoli.handlers.NikoliUiHandler;

public class NikoliMain {

    public static void main(String[] args) {
        NikoliUiHandler gameHandler = new NikoliUiHandler();
        gameHandler.runGame();
    }
}
