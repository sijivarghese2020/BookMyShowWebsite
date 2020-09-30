package BookMyShow.Common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class reportUtilities {
    private static reportUtilities reports;
    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest extentTest;
    //method to generate report
    private reportUtilities(){
        try {
            String path = System.getProperty("user.dir");
            extentReports = new ExtentReports();
            sparkReporter = new ExtentSparkReporter(path + "\\report\\report.html");
            extentReports.setSystemInfo("Machine Name : ", InetAddress.getLocalHost().getHostName());
            //    extentReports.setSystemInfo("Browser name : ", Browser);
            extentReports.attachReporter(sparkReporter);
       //     extentTest = extentReports.createTest("BookMyShow Reports ");
      //      extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());

        } catch (Exception e) {
            System.out.println("Error in generating report " + e.getMessage());
        }
    }
    public static ExtentReports getReport(){
        reports = new reportUtilities();
        return extentReports;
    }
//    public static String getBrowser() {
//        Log.info("Getting system browser name . . .");
//        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
//        String browserName = cap.getBrowserName().toLowerCase();
//        return StringUtils.capitalize(browserName);
//    }
}
