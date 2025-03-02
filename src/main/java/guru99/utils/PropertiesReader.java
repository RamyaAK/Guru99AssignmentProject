package guru99.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Properties properties = new Properties();

    // Load the properties file once at the beginning
    static {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();  // Handle error if file not found or other IO issues
        }
    }

    // Method to fetch the property value for a given key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
