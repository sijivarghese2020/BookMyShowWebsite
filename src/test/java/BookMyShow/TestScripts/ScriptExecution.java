package BookMyShow.TestScripts;

import BookMyShow.Common.*;
import BookMyShow.PageObjects.Fanhood;
import BookMyShow.PageObjects.ListMyShow;
import BookMyShow.PageObjects.MovieSearch;
import BookMyShow.PageObjects.selectValues;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.HashMap;

public class ScriptExecution extends TestExecution {
    private WebDriver driver;
    public static ExtentReports extentReports;


    @BeforeSuite
    public void beforeSuite(){
        this.driver= super.OpenBrowser();
        extentReports=reportUtilities.getReport();
        logUtilities.information("Site launched");
    }
    @BeforeMethod
    public void Initialize( ){

      //  extentReports=reportUtilities.getReport();
      //  logUtilities.information("Site launched");
     }


    @Parameters ("location")
    @Test (priority = 1 )
    public void TestCase_1_LocationSelection(String location){
        MovieSearch search = new MovieSearch(driver);
        logUtilities.information("Selected location as "+location);
        ExtentTest test = extentReports.createTest(driver.getTitle());
        search.ChooseLocation (location);
    }
    @Test (priority = 2, dataProvider = "Moviename1", dataProviderClass = MovieDP.class )
    public void TestCase_2_MovieSearch(String movie){ //String location,
            MovieSearch search = new MovieSearch(driver);
            logUtilities.information("Selected movie as "+movie);
      //      search.SearchMovie(location,movie);
            search.SearchingMovie(movie);
            ExtentTest test = extentReports.createTest("TC_1 & 2 Search Movie Scenario :- Movie "+ movie + " selected");
            test.log(Status.PASS, "Movie ' "+movie+ " ' Searched");
            test.addScreenCaptureFromPath(Driver.takeScreenshot());
            logUtilities.information("Movie '"+movie+ "' Searched");
    }

    @Test (priority = 3, dataProvider = "MergedData", dataProviderClass = CastandCrew_DP.class)
    public void TestCase_3_SearchCastandCrew(HashMap<String,String> data){
        MovieSearch search = new MovieSearch(driver);
        search.actorSearch(data);
        ExtentTest test = extentReports.createTest("TC_3 Search for Cast and Crew-Postive:- Movie "+ data.get("Movie") + " selected");
        test.log(Status.PASS, "Movie ' "+data.get("Movie")+ " ' Searched");
        logUtilities.information("Movie ' "+data.get("Movie")+ " ' Searched");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 4, dataProvider = "MergedData", dataProviderClass = CastandCrew_DP.class)
    public void TestCase_4_SearchCastandCrewNegative(HashMap<String,String> data){
        MovieSearch search = new MovieSearch(driver);
        search.ChooseCastCrewNegative(data);
        ExtentTest test = extentReports.createTest("TC_4 Search for Cast and Crew-Negative:- Movie "+ data.get("Movie") + " selected");
        test.log(Status.PASS, "Movie ' "+data.get("Movie") + " ' selected");
        logUtilities.information("Movie ' "+data.get("Movie")+ " ' Searched");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }

    @Test (priority = 5, dataProvider = "ListMyShow", dataProviderClass = ListMyShowDP.class)
    public void TestCase_5_ListMyShow(String[] ListValues){
        ListMyShow myShow = new ListMyShow(driver);
        myShow.searchListMyShow(ListValues);
        ExtentTest test = extentReports.createTest("TC_5 List Your Show-What can you Host ");
        test.log(Status.PASS, "Searched for ' CAST and CREW '");
        logUtilities.information("Invoked the link 'List Your Show' ");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 6, dataProvider="offeredServices", dataProviderClass = ListMyShowDP.class)
    public void TestCase_6_Services(String [] services){
        ListMyShow myShow = new ListMyShow(driver);
        myShow.listServices(services);
        ExtentTest test = extentReports.createTest("TC_6 List Your Show-What are the services we offer?");
        test.log(Status.PASS, "Fetched for the services offered");
        logUtilities.information("Fetched for the services offered");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 7, dataProvider="Reports", dataProviderClass = ListMyShowDP.class)
    public void TestCase_7_Reports(String [] report){
        ListMyShow myShow = new ListMyShow(driver);
        myShow.report_BusinessInsight(report);
        ExtentTest test = extentReports.createTest("TC_7 Reports & business insights");
        test.log(Status.PASS, "Fetched for Reports & business insights");
        logUtilities.information("Fetched for Reports & business insights");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 8, dataProvider = "Offers", dataProviderClass = ListMyShowDP.class)
    public void TestCase_8_Offers(String[] rewards){
        ListMyShow myShow = new ListMyShow(driver);
        myShow.closeReports();
        myShow.getOffers(rewards);
        ExtentTest test = extentReports.createTest("TC_8 Check Offers");
        test.log(Status.PASS, "Fetched for Check Offers");
        logUtilities.information("Fetched for Check Offers");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 9)
    @Parameters ("discountoffer")
    public void TestCase_9_DiscountOffer(String discountoffer){
        ListMyShow myShow = new ListMyShow(driver);
        myShow.discountOffers(discountoffer);
        ExtentTest test = extentReports.createTest("TC_9 FILTER OFFERS BY Positive scenario with "+ discountoffer);
        test.log(Status.PASS, "Fetched for Discount Offers ' "+discountoffer+ " '");
        logUtilities.information("Fetched for Discount Offers ' " + discountoffer+ " '");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 10)
    @Parameters ("discountoffer1")
    public void TestCase_10_DiscountOfferNegative (String discountoffer){
        ListMyShow myShow = new ListMyShow(driver);
        myShow.discountOffers(discountoffer);
        ExtentTest test = extentReports.createTest("TC_10 FILTER OFFERS BY Negative scenario with "+ discountoffer);
        test.log(Status.PASS, "Fetched for Discount Offers ' "+discountoffer+ " ' Negative Scenario");
        logUtilities.information("Fetched for Discount Offers ' " + discountoffer+ " ' Negative Scenario");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority =11, dataProvider = "footers" , dataProviderClass = ListMyShowDP.class)
    public void TestCase_11_FooterTextValidation(String [] footer){
        ListMyShow myShow = new ListMyShow(driver);
        myShow.FooterTextValidation(footer);
        ExtentTest test = extentReports.createTest("TC_11 Footer Text Validation");
        test.log(Status.PASS, "Footer Text Validation ");
        logUtilities.information("Footer Text Validation");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority =12)
    @Parameters ("language")
    public void TestCase_12_SelectLanguage(String language){
        selectValues selectLang = new selectValues(driver);
    //    selectLang.selectLanguage(language);
        ExtentTest test = extentReports.createTest("TC_12 Select Language");
        Markup markup = MarkupHelper.createOrderedList(selectLang.selectLanguage(language));
        test.log(Status.PASS, "Select Language");
        logUtilities.information("Select Language");
        test.info(markup);
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 13 )
    @Parameters ("city")
    public void  TestCase_13_SelectCity(String city){
        MovieSearch search = new MovieSearch(driver);
        logUtilities.information("Selected location as "+city);
        selectValues values = new selectValues(driver);
        values.chooseLanguage();
        search.chooseCity (city);
        ExtentTest test = extentReports.createTest("TC_13 Choose City");
        test.log(Status.PASS, "Select City/Location");
        logUtilities.information("Select City/Location");
        test.addScreenCaptureFromPath(Driver.takeScreenshot());
    }
    @Test (priority = 14)
    @Parameters ("menufanhood")
    public void TestCase_15_SelectFanhood(String menufanhood){
        Fanhood fanhood = new Fanhood(driver);
        ExtentTest test = extentReports.createTest("Fanhood");
        fanhood.selectFanhood(menufanhood);
        Markup markup = MarkupHelper.createOrderedList(fanhood.selectFanhood(menufanhood));
        test.info(markup);
        test.addScreenCaptureFromPath(Driver.takeScreenshot());

    }
    @AfterMethod
    public void Finalize(ITestResult result){
      //  Driver.takeScreenshot();
//        super.FinalizeTest(); //browser closing
//        extentReports.flush();
     }
    @AfterSuite
    public void afterSuite(){
        super.FinalizeTest();
        extentReports.flush();
    }
}
