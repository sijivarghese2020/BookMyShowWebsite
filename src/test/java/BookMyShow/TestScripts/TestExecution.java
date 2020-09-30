package BookMyShow.TestScripts;

import BookMyShow.Common.Configuration;
import BookMyShow.Common.Driver;
import BookMyShow.Common.logUtilities;
import BookMyShow.Common.reportUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class TestExecution {
    private static Configuration config;

    public WebDriver OpenBrowser () {
        WebDriver driver = null;
        try {
            config = new Configuration();
            String browser = config.getContents("BROWSER");
            String url = config.getContents("URL");
            driver = Driver.openBrowser(browser, url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

    public void FinalizeTest () {

        Driver.closeBrowser();
  //      extentReports.flush();

    }

}

