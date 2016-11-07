package ar.fiuba.tdd.nikoli.model.board;

/**
 * Clase que modela un enlace que va desde una posicion inicial hacia una posicion final.
 */
public class Link {
    private Position start;
    private Position end;

    public Link(Position pos1, Position pos2) {
        //Ordena el enlace para que la posicion inicial sea la que esté mas al noroeste
        if (pos1.getX() < pos2.getX() || (pos1.getX() == pos2.getX() && pos1.getY() < pos2.getY())) {
            this.start = pos1;
            this.end = pos2;
        } else {
            this.start = pos2;
            this.end = pos1;
        }

    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Link) {
            Link link = (Link) obj;

            result = (link.start.getX() == this.start.getX())
                     &&
                     (link.start.getY() == this.start.getY())
                     &&
                     (link.end.getX() == this.end.getX())
                     &&
                     (link.end.getY() == this.end.getY());
        }


        return result;
    }

    @Override
    public int hashCode() {
        assert false : "hashCode not designed";
        return 42; // any arbitrary constant will do
    }

}
