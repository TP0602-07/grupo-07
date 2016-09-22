package ar.fiuba.tdd.nikoli.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Message {

    private static String fileName = "message.properties";

    public static String getMessage(String idMessage) {

        Properties prop   = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(fileName);
            prop.load(input);
            String message = prop.getProperty(idMessage);
            if (message == null) {
                message = "Message ID " + idMessage + "not found";
            }
            return message;

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Message ID " + idMessage + "not found";
    }
}
