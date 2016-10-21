package ar.fiuba.tdd.nikoli.model.board;

/**
 * Clase que representa bordes de la celda, ya sea extremos como lados.
 *
 */
public class Edge {

    private int value1; //lado superior(country road,slitherlink,ishi) = extremo superior izquierdo(naname)
    private int value2; //lado derecho(country road,slitherlink,ishi) = extremo superior derecho(naname)
    private int value3; //lado inferior(country road,slitherlink,ishi) = extremo inferior derecho(naname)
    private int value4; //lado izquierdo(country road,slitherlink,ishi) = extremo inferior izquierdo(naname)

    public Edge(int value1, int value2, int value3, int value4) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public int getValue3() {
        return value3;
    }

    public void setValue3(int value3) {
        this.value3 = value3;
    }

    public int getValue4() {
        return value4;
    }

    public void setValue4(int value4) {
        this.value4 = value4;
    }
}
