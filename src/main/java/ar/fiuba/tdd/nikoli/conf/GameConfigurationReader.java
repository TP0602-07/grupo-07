package ar.fiuba.tdd.nikoli.conf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationException;
import ar.fiuba.tdd.nikoli.conf.exception.GameConfigurationNotFoundException;
import ar.fiuba.tdd.nikoli.utils.JsonFileNotFoundException;
import ar.fiuba.tdd.nikoli.utils.JsonFilesUtils;

import java.io.InputStreamReader;


/**
 * Clase abstracta que implementa funcionalidad de lectura de archivos de configuracion y delega en sus clases
 * hijas el procesamiento de lo leido.
 */
public abstract class GameConfigurationReader<T,U> {


    private static final String CONFIGURATION_FILES_BASE_PATH = "configurationFiles/";

    private Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    protected Class<T> clazz;


    /**
     * Lee la configuration de un juego dado su nombre.
     * @param gameName nombre del juego.
     * @return un objecto con configuracion de un juego
     * @throws GameConfigurationException si se produce un error en la lectura de la configuracion del juego.
     */
    public U readConfiguration(String gameName) throws GameConfigurationException {
        T objectFromJson = this.readConfigurationFromJson(gameName);
        return this.process(objectFromJson);
    }

    /**
     * Lee la configuracion de un juego desde un archivo JSON.
     * @param gameName nombre del juego.
     * @return un objeto correspondiente al JSON leido.
     * @throws GameConfigurationNotFoundException si no se encuentra archivo de configuracion de juego.
     */
    private T readConfigurationFromJson(String gameName) throws GameConfigurationNotFoundException {
        InputStreamReader jsonFile = this.getConfigurationFile(gameName, this.getConfigurationType());
        T objectFromJson = gson.fromJson(jsonFile, this.clazz);

        return objectFromJson;
    }

    /**
     * Retorna un archivo de configuracion.
     * @param gameName nombre del juego.
     * @param configurationType tipo de configuracion (reglas o tablero).
     * @return un {@link InputStreamReader} del archivo de configuracion.
     * @throws GameConfigurationNotFoundException si no se encontro el archivo de configuracion del juego pedido.
     */
    private InputStreamReader getConfigurationFile(String gameName, String configurationType) throws GameConfigurationNotFoundException {

        try {
            String path = CONFIGURATION_FILES_BASE_PATH + gameName + "/" + gameName + "-" + configurationType;
            return JsonFilesUtils.getJsonFile(path);
        } catch (JsonFileNotFoundException e) {
            throw new GameConfigurationNotFoundException(gameName, configurationType);
        }
    }


    /**
     * Procesa la configuracion leida.
     * @param configuration objeto con configuracion de un juego.
     * @throws GameConfigurationException si se produjo algun error en el procesamiento de la configuracion.
     */
    protected abstract U process(T configuration) throws GameConfigurationException;

    /**
     * @return el tipo de configuracion de juego.
     */
    protected abstract String getConfigurationType();


}
