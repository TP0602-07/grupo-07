package ar.fiuba.tdd.nikoli.utils;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
            String filePath = classLoader.getResource(path + FILE_EXTENSION).getPath();
            InputStreamReader jsonFile = new InputStreamReader(new FileInputStream(filePath), "UTF-8");

            return jsonFile;
        } catch (NullPointerException | IOException e) {
            throw new JsonFileNotFoundException("JSON File" + path + "not found!");
        }
    }

    /**
     * Crea un archivo JSON en la ruta especificada con el contenido dado.
     * @param fileName es el nombre del archivo JSON.
     * @param json es el contenido del archivo JSON.
     * @exception Exception si no se puede escribir el archivo JSON.
     */
    public static void writeJsonFile(String fileName, String json) throws Exception {
        try {

            File file = new File(fileName + FILE_EXTENSION);
            Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new Exception();
        }
    }

}
