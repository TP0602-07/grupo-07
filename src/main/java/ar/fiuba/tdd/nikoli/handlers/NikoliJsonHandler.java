package ar.fiuba.tdd.nikoli.handlers;


import ar.fiuba.tdd.nikoli.command.Command;
import ar.fiuba.tdd.nikoli.command.CommandManager;
import ar.fiuba.tdd.nikoli.command.PlayCommand;
import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.model.GameBuilder;
import ar.fiuba.tdd.nikoli.model.board.exception.InvalidPlayException;
import ar.fiuba.tdd.nikoli.plays.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de correr el juego utilizando el modo de lectura de jugadas con su ejecucion.
 */
public class NikoliJsonHandler {

    private CommandManager commandManager = new CommandManager();

    public void runGame(String gameName) {

        try {
            Game game = GameBuilder.buildGame(gameName);

            PlaysList plays = PlaysReader.readPlaysFromJson(gameName);

            PlaysListResult playsResult = new PlaysListResult();
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

            String result = game.isFullBoard() ? game.checkVictory() : "You don't complete the board yet.";
            System.out.println(result);

            PlaysReader.writePlaysResult(gameName, playsResult);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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


}
