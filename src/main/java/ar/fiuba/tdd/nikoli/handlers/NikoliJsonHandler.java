package ar.fiuba.tdd.nikoli.handlers;


import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.GameBuilder;
import ar.fiuba.tdd.nikoli.model.board.exception.InvalidPlayException;
import ar.fiuba.tdd.nikoli.plays.*;
import ar.fiuba.tdd.nikoli.utils.JsonFileCanNotBeCreatedException;
import ar.fiuba.tdd.nikoli.utils.JsonFileNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de correr el juego utilizando el modo de lectura de jugadas con su ejecucion.
 */
public class NikoliJsonHandler {

    public void runGame() {

        String gameName = "sudoku";

        try {
            Game game = GameBuilder.buildGame(gameName);

            PlaysList plays = PlaysReader.readPlaysFromJson(gameName);

            PlaysListResult playsResult = new PlaysListResult();

            List<PlayResult> results = new ArrayList<PlayResult>();
            for (Play play : plays.getPlays()) {

                PlayResult playResult = new PlayResult();
                playResult.setNumber(play.getNumber());

                try {
                    game.makePlay(play);
                    playResult.setPlayStatus(PlayResult.STATUS_VALID);
                } catch (InvalidPlayException ipe) {
                    playResult.setPlayStatus(PlayResult.STATUS_VALID);
                }

                results.add(playResult);
            }

            playsResult.setPlays(results);

            PlaysReader.writePlaysResult(gameName, playsResult);

        } catch (GameConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (JsonFileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (JsonFileCanNotBeCreatedException e) {
            System.out.println(e.getMessage());
        }

    }
}
