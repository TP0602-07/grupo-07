package ar.fiuba.tdd.nikoli.handlers;


import org.junit.Test;


public class NikoliJsonHandlerTests {

    private NikoliJsonHandler jsonHandler = new NikoliJsonHandler();

    @Test
    public void runGameInshiNoHeyaWin() {
        String gameName = "inshinoheya-COMPLETE-WIN";
        this.jsonHandler.runGame(gameName);
    }

    @Test
    public void runGameInshiNoHeyaInvalidPlay() {
        String gameName = "inshinoheya-INCOMPLETE-INVALID";
        this.jsonHandler.runGame(gameName);
    }


    @Test
    public void runGameCountryRoadWin() {
        String gameName = "countryroad-COMPLETE-WIN";
        this.jsonHandler.runGame(gameName);
    }

    @Test
    public void runGameCountryRoadLose() {
        String gameName = "countryroad-COMPLETE-LOSE";
        this.jsonHandler.runGame(gameName);
    }

    @Test
    public void runGameCountryRoadInvalidPlay() {
        String gameName = "countryroad-INCOMPLETE-INVALID";
        this.jsonHandler.runGame(gameName);
    }

}
