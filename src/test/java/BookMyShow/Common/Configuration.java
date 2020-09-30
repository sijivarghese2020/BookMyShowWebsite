package BookMyShow.Common;


import com.aventstack.extentreports.ExtentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Configuration Config = null;
    private Properties properties;
    public ExtentTest Test;

    //Inside Constructor, method to read from Config.Properties
    public Configuration() throws IOException{
        logUtilities.information("Fetching data from Config.Properties");
        properties= new Properties();
        String path=System.getProperty("user.dir");
        path +="\\src\\main\\resources\\Config.Properties";
        FileInputStream file = new FileInputStream(path);
        properties.load(file);
        file.close();
        logUtilities.information("Data Fetched: Config.Properties file closed");
    }
    //Method to retrieve the contents from Config.Properties file
    public String getContents(String tag) throws IOException{
        return properties.getProperty(tag);
    }
    public Configuration ConfigReturn() throws IOException{
        return new Configuration();
    }
}
