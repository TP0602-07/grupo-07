package ar.fiuba.tdd.nikoli.model.rules.implementation;

import ar.fiuba.tdd.nikoli.model.board.*;
import ar.fiuba.tdd.nikoli.model.rules.Rule;

import java.util.List;

/**
 * Created by emmanuel on 31/10/16.
 */
public class RegionLinkCountRule extends Rule {

    @Override
    public boolean isRuleBroken(GameBoard board, Position position) {
        List<RegionLink> regions = board.getRegionsLink();


        boolean isBroken = false;

        for (RegionLink region : regions) {

            isBroken = isRegionControlFail(board,region);
            if (isBroken) {
                break;
            }
        }

        return isBroken;
    }

    /**
     * Chequea que si en la region se han insertado la cantidad de enlaces correspondientes.
     * @param board tablero del juego.
     * @param region region a validar.
     * @return devuelve true si la regla se rompe.
     */
    private boolean isRegionControlFail(GameBoard board, RegionLink region) {

        int countLinks = toCountLinks(board, region);

        boolean isIncorrect = false;

        if (board.isCompleteBoard()) {
            isIncorrect = countLinks != region.getValue();
        } else {
            isIncorrect = countLinks > region.getValue();
        }

        return isIncorrect;
    }

    private int toCountLinks(GameBoard board, RegionLink region) {
        List<Link> links = board.getLinks();

        int countLinks = 0;

        for (Link link : region.getLinks()) {
            if (links.contains(link)) {
                countLinks++;
            }
        }

        return countLinks;
    }
}
