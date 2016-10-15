package ar.fiuba.tdd.nikoli.utils;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pablo on 10/15/16.
 */
public class JsonFilesUtils {


    private static final String FILE_EXTENSION = ".json";

    /**
     * Retorna un archivo JSON.
     * @param path ruta relativa del archivo dentro de resources.
     * @return un {@link InputStreamReader} del archivo JSON.
     * @throws GameConfigurationNotFoundException si no se encontro el archivo de configuracion del juego pedido.
     */
    public static InputStreamReader getJsonFile(String path) throws JsonFileNotFoundException {

        try {
            ClassLoader classLoader = JsonFilesUtils.class.getClassLoader();
            String filePath = classLoader.getResource(path + FILE_EXTENSION)
                    .getPath();
            InputStreamReader jsonFile = new InputStreamReader(new FileInputStream(filePath), "UTF-8");

            return jsonFile;
        } catch (NullPointerException | IOException e) {
            throw new JsonFileNotFoundException("JSON File" + path + "not found!");
        }
    }
}
