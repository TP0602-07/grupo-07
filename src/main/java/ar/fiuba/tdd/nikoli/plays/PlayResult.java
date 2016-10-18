package ar.fiuba.tdd.nikoli.plays;

/**
 * Clase que representa el resultado de una jugada.
 */
public class PlayResult {

    public static final String BOARD_STATUS_VALID = "valid";
    public static final String BOARD_STATUS_INVALID = "invalid";

    private int number;
    private String boardStatus;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(String boardStatus) {
        this.boardStatus = boardStatus;
    }
}
