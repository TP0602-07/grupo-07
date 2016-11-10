package ar.fiuba.tdd.nikoli.model.board;

import java.util.List;

/**
 * Created by emmanuel on 30/10/16.
 */
public class RegionLink {
    private int value;

    private List<Link> links;

    public RegionLink(List<Link> links, int value) {
        this.links = links;
        this.value = value;
    }

    public List<Link> getLinks() {
        return links;
    }

    public int getValue() {
        return value;
    }
}
