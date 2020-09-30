package BookMyShow.Common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

public class Driver {
    private static WebDriver driver;
    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest extentTest;
    private static Configuration config;
    private static String Browser;

//Opening Browser
    public static WebDriver openBrowser (String browser,String url){
        String browsername = "webdriver." + browser + ".driver";
        String resource = "src/main/resources/";
        String drivertype = "driver.exe";
        String strpath = resource+ browser + drivertype;
        System.setProperty(browsername,strpath);
        try{
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "ie":
                    //IEDriverServer
                    strpath = resource+"IEDriverServer.exe";
                    System.setProperty(browsername,strpath);
                    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                    InternetExplorerOptions ieoptions = new InternetExplorerOptions(capabilities);
                    driver = new InternetExplorerDriver(ieoptions);
                    break;
                case "ff":
                    strpath =resource+ "gecko" + drivertype;
                    browsername = "webdriver." + "gecko" + ".driver";
                    System.setProperty(browsername,strpath);
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + browser);
            }
            logUtilities.information(browser+" browser was started successfully ");
            Browser = browser;
      //      extentReports.setSystemInfo("Browser name : ", Browser);
        }catch (Exception e){
            System.out.println(e.getMessage());
            logUtilities.error("Failed to launch browser "+browser+" "+ e.getMessage());
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        return driver;
    }
    //Closing browser
    public static void closeBrowser(){
        logUtilities.warning("Closing browser");
        driver.quit();
    }

    public static String takeScreenshot()  {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File image = screenshot.getScreenshotAs(OutputType.FILE);
            Random random = new Random();
            String file  = "SS"+random.nextInt(100)+".png";
            String filename = System.getProperty("user.dir")+"\\report\\"+file;
            File destinationFile = new File(filename);
            FileUtils.copyFile (image, destinationFile);
            return file;
        }catch (Exception e){
            logUtilities.error("Error in taking screenshot "+e.getMessage());
            System.out.println("Error in taking screenshot "+ e.getMessage());
            return null;
        }
    }

    //method to generate report
   /* public static void generateReport () {
        try {
            String path = System.getProperty("user.dir");
            extentReports = new ExtentReports();
            sparkReporter = new ExtentSparkReporter(path + "\\report\\report.html");
            extentReports.setSystemInfo("Machine Name : ", InetAddress.getLocalHost().getHostName());
        //    extentReports.setSystemInfo("Browser name : ", Browser);
            extentReports.attachReporter(sparkReporter);
           // extentTest = extentReports.createTest("BookMyShow ");
            extentTest.addScreenCaptureFromPath(takeScreenshot());
            extentReports.flush();
        } catch (Exception e) {
            System.out.println("Error in generating report " + e.getMessage());
        }
    }
*/
}
