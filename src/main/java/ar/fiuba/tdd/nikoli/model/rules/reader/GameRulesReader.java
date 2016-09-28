package ar.fiuba.tdd.nikoli.model.rules.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ar.fiuba.tdd.nikoli.model.rules.GameRules;
import ar.fiuba.tdd.nikoli.model.rules.Rule;
import ar.fiuba.tdd.nikoli.model.rules.exception.GameRulesNotFoundException;
import ar.fiuba.tdd.nikoli.model.rules.exception.UnknownRuleException;
import ar.fiuba.tdd.nikoli.model.rules.factory.GameRulesFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de realizar el procesamiento de reglas.
 */
public class GameRulesReader {

    private static GameRulesReader instance;

    private GameRulesReader() { }


    public static GameRulesReader getInstance() {
        if (instance == null) {
            instance = new GameRulesReader();
        }

        return instance;
    }


    /**
     * Genera las reglas de juego a partir de su nombre.
     * @param gameName nombre del juego
     * @return una instacia de {@link GameRules}
     * @throws GameRulesNotFoundException si no se encuentra archivo de reglas de juego
     * @throws UnknownRuleException si una regla enumerada en el archivo de juego es desconocida
     */
    public GameRules readGameRules(String gameName)
            throws GameRulesNotFoundException, UnknownRuleException {

        GameRules gameRules = this.readGameRulesFromJson(gameName);
        List<Rule> rules = this.processGameRules(gameRules.getRulesNames());
        gameRules.setRules(rules);
        return gameRules;
    }


    /**
     * Lee las reglas de un juego desde un archivo JSON.
     * @param gameName nombre del juego
     * @return una instacia de {@link GameRules} obtenida de la lectura del JSON de configuracion
     * @throws GameRulesNotFoundException si no se encuentra archivo de reglas de juego
     */
    private GameRules readGameRulesFromJson(String gameName) throws GameRulesNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        try {

            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(
                    "configurationFiles/" + gameName + "/" + gameName + "-rules.json");

            if (inputStream ==  null) {
                throw new GameRulesNotFoundException("No se ha encontrado el archivo de configuracion con las reglas del juego");
            }
            InputStreamReader jsonFile = new InputStreamReader(inputStream, "UTF-8");

            GameRules rules = gson.fromJson(jsonFile, GameRules.class);

            return rules;

        } catch (IOException e) {
            throw new GameRulesNotFoundException("No se ha encontrado el archivo de configuracion con las reglas del juego");
        }
    }


    /**
     * Procesa los nombres de las reglas encontradas creando objetos de las clases correspondientes.
     * @param rulesNames lista con los nombres de las reglas de un juego
     * @throws UnknownRuleException si una regla enumerada en el archivo de juego es desconocida
     */
    private List<Rule> processGameRules(List<String> rulesNames) throws UnknownRuleException {
        List<Rule> rules = new ArrayList<Rule>();

        for (String name: rulesNames) {
            try {
                Rule rule = GameRulesFactory.getInstance().createRuleByName(name);
                rules.add(rule);
            } catch (UnknownRuleException e) {
                throw new UnknownRuleException(name);
            }
        }

        return rules;
    }

}
