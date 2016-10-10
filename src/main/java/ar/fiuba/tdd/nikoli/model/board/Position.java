package ar.fiuba.tdd.nikoli.model.board;

/**
 * Clase que modela una posicion en el tablero.
 */
public class Position {
    private int coordinateX;
    private int coordinateY;

    public Position(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Position position = (Position) object;

        return (coordinateX == position.coordinateX && coordinateY == position.coordinateY);

    }

    @Override
    public int hashCode() {
        int result = coordinateX;
        result = 31 * result + coordinateY;
        return result;
    }

    public boolean isContiguouosHorizontalOrVertical(Position position) {
        boolean isContiguous = false;
        if ((this.coordinateX - position.getX() == 1 || this.coordinateX - position.getX() == -1)
                && (this.coordinateY - position.getY() == 0)) {
            isContiguous = true;
        } else if ((this.coordinateY - position.getY() == 1 || this.coordinateY - position.getY() == -1)
                    && (this.coordinateX - position.getX() == 0)) {
            isContiguous = true;
        }
        return isContiguous;
    }
}
