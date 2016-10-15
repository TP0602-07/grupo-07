package ar.fiuba.tdd.nikoli.plays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ar.fiuba.tdd.nikoli.utils.JsonFileNotFoundException;
import ar.fiuba.tdd.nikoli.utils.JsonFilesUtils;

import java.io.InputStreamReader;


/**
 * Clase utilitaria con metodos encargados de la lectura/escritura de jugadas desde archivos.
 */
public class PlaysReader {

    private static final String PLAYS_FILES_BASE_PATH = "plays/";

    private static final String PLAYS_FILES_SUFFIX = "-plays";

    private static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();


    /**
     * Lee una lista de jugadas para un juego desde un archivo JSON.
     * @param gameName nombre del juego.
     * @return una instancia de {@link PlaysList}.
     * @throws JsonFileNotFoundException si no se encuentra archivo de jugadas del juego.
     */
    public static PlaysList readPlaysFromJson(String gameName) throws JsonFileNotFoundException {
        InputStreamReader jsonFile = getPlaysFile(gameName);
        PlaysList playList = gson.fromJson(jsonFile, PlaysList.class);
        return playList;
    }


    /**
     * Retorna un archivo de jugadas.
     * @param gameName nombre del juego.
     * @return un {@link InputStreamReader} del archivo de jugadas.
     * @throws JsonFileNotFoundException si no se encontro el archivo de jugadas del juego pedido.
     */
    private static InputStreamReader getPlaysFile(String gameName) throws JsonFileNotFoundException {
        String path = PLAYS_FILES_BASE_PATH + gameName + PLAYS_FILES_SUFFIX;
        return JsonFilesUtils.getJsonFile(path);
    }

}
