package ar.fiuba.tdd.template;

import ar.fiuba.tdd.nikoli.rules.GameRules;
import ar.fiuba.tdd.nikoli.rules.reader.GameRulesReader;


public class Main {
    public static void main(String[] args) {
        System.out.println("This is just a template project and I'm testing CI notifications");

        try {
            GameRules gameRules = GameRulesReader.getInstance().readGameRules("sudoku");

            System.out.println("REGLAS DE " + gameRules.getGameName());
            System.out.println("------");

            System.out.println("EL JUEGO TIENE " + gameRules.getRules().size() + " REGLAS") ;

        } catch (Exception e) {
            System.out.println("EXCEPTION > " + e.getMessage());
        }




    }

}
