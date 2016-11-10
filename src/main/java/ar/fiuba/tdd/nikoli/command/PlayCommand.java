package ar.fiuba.tdd.nikoli.command;

import ar.fiuba.tdd.nikoli.model.Game;
import ar.fiuba.tdd.nikoli.plays.Play;

/**
 * Created by emmanuel on 08/11/16.
 */
public class PlayCommand extends Command {

    private Play play;
    private Game previousGame;
    private Game game;

    public PlayCommand(Play play, Game game) {
        this.play = play;
        this.game = game;
    }

    @Override
    public void execute() {
        try {
            this.previousGame = (Game) this.game.clone();
            this.game.makePlay(fixPlayCoordenates(play));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
        this.game = this.previousGame;
    }

    private Play fixPlayCoordenates(Play play) {
        return new Play(play.getNumber(),
                play.getPosition().getX() - 1,
                play.getPosition().getY() - 1,
                play.getValue());
    }
}
