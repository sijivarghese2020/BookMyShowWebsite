package BookMyShow.Common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public static ExtentReports extentReports;
    public ExtentTest Test;
    @Override
    public void onTestStart(ITestResult result) {
  //      extentReports=reportUtilities.getReport();
    }
    @Override
    public void onTestSuccess(ITestResult result) {
   //     System.out.println("Positive Scenario: Test execution success");
   //     Test.addScreenCaptureFromPath(Driver.takeScreenshot(),"Test case Successful");
    }
    @Override
    public void onTestFailure(ITestResult result) {
   //     System.out.println("Negative Scenario: Test execution success");
  //      Test.addScreenCaptureFromPath(Driver.takeScreenshot(),"Negatvie Test case ");
    }
    public  void onFinish(ITestContext context) {

    }
}
