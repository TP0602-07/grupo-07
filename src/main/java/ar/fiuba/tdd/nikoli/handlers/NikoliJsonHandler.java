package ar.fiuba.tdd.nikoli.handlers;


import ar.fiuba.tdd.nikoli.command.CommandManager;
import ar.fiuba.tdd.nikoli.command.PlayCommand;
import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.GameBuilder;
import ar.fiuba.tdd.nikoli.plays.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de correr el juego utilizando el modo de lectura de jugadas con su ejecucion.
 */
public class NikoliJsonHandler {

    private CommandManager commandManager = new CommandManager();

    private Game game;

    public PlaysListResult runGame(String gameName) {

        PlaysListResult playsResult = new PlaysListResult();

        try {
            this.game = GameBuilder.buildGame(gameName);

            PlaysList plays = PlaysReader.readPlaysFromJson(gameName);

            List<PlayResult> results = new ArrayList<PlayResult>();
            for (Play play : plays.getPlays()) {

                PlayResult playResult = new PlayResult();
                playResult.setNumber(play.getNumber());

                boolean playSucced = executePlay(play, game);

                if (playSucced) {
                    playResult.setBoardStatus(PlayResult.STATUS_VALID);
                } else {
                    playResult.setBoardStatus(PlayResult.STATUS_INVALID);
                }

                results.add(playResult);
            }
            playsResult.setPlays(results);

            System.out.println(game.getMessageFinalResult());

            PlaysReader.writePlaysResult(gameName, playsResult);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return playsResult;
    }


    private boolean executePlay(Play play, Game game) {
        //TODO mejorar usando reflection

        if (play.getAction() != null && play.getAction().equals("undo")) {
            this.commandManager.undo();
        } else {
            this.commandManager.executeCommand(new PlayCommand(play, game));
        }

        return game.getResultPlay();
    }

    public boolean checkVictory() {
        return this.game.checkVictory();
    }


}
