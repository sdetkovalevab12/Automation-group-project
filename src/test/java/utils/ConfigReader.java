package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static  final String PATH = "config.properties";

    static {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(PATH));
            properties = new Properties();
            properties.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
