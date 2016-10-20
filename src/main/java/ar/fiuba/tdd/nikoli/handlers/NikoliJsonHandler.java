package ar.fiuba.tdd.nikoli.handlers;


import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.GameBuilder;
import ar.fiuba.tdd.nikoli.model.board.exception.InvalidPlayException;
import ar.fiuba.tdd.nikoli.plays.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de correr el juego utilizando el modo de lectura de jugadas con su ejecucion.
 */
public class NikoliJsonHandler {

    public void runGame() {

        String gameName = "inshinoheya";

        try {
            Game game = GameBuilder.buildGame(gameName);

            PlaysList plays = PlaysReader.readPlaysFromJson(gameName);

            PlaysListResult playsResult = new PlaysListResult();
            List<PlayResult> results = new ArrayList<PlayResult>();
            for (Play play : plays.getPlays()) {

                PlayResult playResult = new PlayResult();
                playResult.setNumber(play.getNumber());

                try {
                    game.makePlay(this.fixPlayCoordenates(play));
                    playResult.setBoardStatus(PlayResult.STATUS_VALID);
                } catch (InvalidPlayException ipe) {
                    playResult.setBoardStatus(PlayResult.STATUS_INVALID);
                }

                results.add(playResult);
            }

            playsResult.setPlays(results);

            String result = game.isFullBoard() ? game.checkVictory() : "You don't complete the board yet.";
            System.out.println(result);

            PlaysReader.writePlaysResult(gameName, playsResult);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private Play fixPlayCoordenates(Play play) {
        return new Play(play.getNumber(),
                play.getPosition().getX() - 1,
                play.getPosition().getY() - 1,
                play.getValue());
    }
}
