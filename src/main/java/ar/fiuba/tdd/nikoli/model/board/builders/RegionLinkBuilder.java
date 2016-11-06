package ar.fiuba.tdd.nikoli.model.board.builders;

import ar.fiuba.tdd.nikoli.conf.board.RegionLinkJson;
import ar.fiuba.tdd.nikoli.model.board.Link;
import ar.fiuba.tdd.nikoli.model.board.Position;
import ar.fiuba.tdd.nikoli.model.board.RegionLink;

import java.util.ArrayList;
import java.util.List;


/**
 * Contruye una @{@link RegionLink} a partir de los datos liedos desde el json.
 */
public class RegionLinkBuilder {

    public static RegionLink build(RegionLinkJson json) {
        List<Link> links = buildLinks(json.getPositionLinkGenerator());

        RegionLink regionLink = new RegionLink(links, json.getValue());

        return regionLink;
    }

    /**
     * Construye una lista de links.
     * @param pos indica a partir de que celda se van a construir los links
     * @return una lista de links
     */
    private static List<Link> buildLinks(Position pos) {
        Position northwest = pos;
        Position northeast = new Position(pos.getX(), pos.getY() + 1);
        Position southwest = new Position(pos.getX() + 1, pos.getY());
        Position southeast = new Position(pos.getX() + 1, pos.getY() + 1);

        Link up = new Link(northwest, northeast);
        Link left = new Link(northwest, southwest);
        Link right = new Link(northeast, southeast);
        Link down = new Link(southwest, southeast);

        List<Link> links = new ArrayList<>();

        links.add(up);
        links.add(left);
        links.add(right);
        links.add(down);

        return links;
    }
}
