package ar.fiuba.tdd.nikoli.model;

import ar.fiuba.tdd.nikoli.model.state.IState;

//Player basico
public class Player {

    private String name;
    private IState status; //Propuesta, jugador con estado

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IState getStatus() {
        return this.status;
    }

    public void changeStatus(IState newStatus) {
        this.status = newStatus;
    }
}