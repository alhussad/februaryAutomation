package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    File file = new File("src/main/resources/Config.properties");
    FileInputStream fs = new FileInputStream(file);
    private Properties properties;

    public ConfigReader() throws IOException {
        this.properties = new Properties();
        properties.load(fs);
    }

    public String getUKBA_URL(){
        return properties.getProperty("UKBA_URL");
    }
    public String getMortgageCal_URL(){
        return properties.getProperty("MortgageCal_URL");
    }
    public String getBlazeDemo_URL(){
        return properties.getProperty("BlazeDemo_URL");
    }
}
