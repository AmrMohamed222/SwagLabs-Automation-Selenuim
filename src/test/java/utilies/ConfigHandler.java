package utilies;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigHandler {
    Properties properties;
    public ConfigHandler(String filePath) {
        properties = new Properties();
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
