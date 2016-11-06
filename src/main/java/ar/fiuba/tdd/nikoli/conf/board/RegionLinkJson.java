package ar.fiuba.tdd.nikoli.conf.board;

import ar.fiuba.tdd.nikoli.model.board.Position;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * Esta clase tiene como objetivo almacenar una posicion y una valor que se utilizaran
 * para generar @{@link ar.fiuba.tdd.nikoli.model.board.RegionLink}
 */
@SuppressWarnings("UWF_UNWRITTEN_FIELD")
public class RegionLinkJson {
    private int value;
    private Position positionLinkGenerator;

    public int getValue() {
        return value;
    }


    public Position getPositionLinkGenerator() {
        return positionLinkGenerator;
    }
}

