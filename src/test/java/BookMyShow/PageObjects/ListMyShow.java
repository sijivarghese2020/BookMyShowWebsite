package BookMyShow.PageObjects;

import BookMyShow.Common.CustomException;
import BookMyShow.Common.logUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListMyShow extends BasePage {
    //    @FindBy (linkText = "ListYourShow")
//    private  WebElement lnkList;
    WebDriver driver;
    By lnkList = By.linkText("ListYourShow");
    By hostelements = By.className("__txt");
    By closeButton = By.xpath("//div/div/span[@class ='__dismiss icon-cancel']");
    By popup = By.id("wzrk-cancel");
    By lblservices = By.xpath("//*[contains(text(), 'your vision to life.')]");
    By reportDetails = By.xpath("//div [@class ='__txt' and text()='Reports & business insights']");
    By depthreport = By.xpath("//div [@class ='__text' and text()='In depth reports']");
    By regdata = By.xpath("//div [@class ='__text' and contains(text(), 'registration data')]");
    By behaviouraldata = By.xpath("//div[@class ='__text' and contains(text(),'behavioural')]");
    By lnkOffers = By.partialLinkText("Offers");
    By lnkRewards = By.xpath("//li [@data-id ='rewards']");
    By txtRewards = By.xpath("//*[@id='REWARDPOINTS']/a[1]/div[2]/h4[1]");
    By txtPayback = By.xpath("//*[@id='PAYBACK']/a[1]/div[2]/h4[1]");
    By txtClickSBI = By.xpath("//*[@id='SBISIMCLIK']/a[1]/div[2]/h4[1]");
    By txtSearchbox = By.id("ajax-typeahead");
    By txtdiscount = By.className("tt-highlight");
    By footer0 = By.xpath(" //div [@ class ='col app']/h4[1] ");
    By footer1 = By.xpath(" //div [@ class ='col news']/h4");
    By footer2 = By.xpath(" //div [@ class ='col help']/h4");
    By footer3 = By.xpath(" //div [@ class ='col exclusives']/h4");
    By btnClose = By.xpath("//div [@close-modal='Reports']");
    ////div[@class ='col news']/h4

    public ListMyShow (WebDriver driver) {
        super(driver);
        this.driver = driver;
        //PageFactory.initElements(driver,this);
    }

    public void searchListMyShow (String[] ListValues) {
        String txtPresent;
        try {
            //         driver.findElement(By.linkText("BookMyShow")).click();
            //        driver.findElement(By.xpath("//*[@id='showcase-primary']/div[2]/span[1]/svg[1]")).click();
            ////*[@id="showcase-primary"]/div[2]/span[1]/svg[1]
            //   waitforElementTobeClickable(popup);
            // driver.findElement(popup).click();
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            waitforElementPresent(lnkList);
            driver.findElement(lnkList).click();
            pageScrolldown(hostelements);
            for (int i = 0; i <= 6; i++) {
                txtPresent = driver.findElements(hostelements).get(i).getText();
                Assert.assertEquals(txtPresent, ListValues[i]);
            }
            //throw new CustomException( "Element not visible ");
        } catch (Exception e) {
            System.out.println("Error in ListMyShow " + e.getMessage() + "\n" + e.getCause());
            logUtilities.error("In ListMyShow "+e.getMessage());
        }
    }

    public void listServices (String[] services) {
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        String[] diffService = new String[15];

        try {
            pageScrolldown(lblservices);
            for (int i = 7; i < driver.findElements(hostelements).size(); i++) {
                diffService[i] = driver.findElements(hostelements).get(i).getText();
            }
            String[] strService = Arrays.copyOfRange(diffService, 7, 13);
            for (int i = 0; i < strService.length; i++) {
                Assert.assertEquals(strService[i], services[i]);
            }
        } catch (Exception e) {
            System.out.println("Error in Services we offer " + e.getMessage() + "\n" + e.getCause());
            logUtilities.error("In Services we offer "+e.getMessage());
        }
    }
    public void closeReports(){
        driver.findElement(btnClose).click();
    }
    public void report_BusinessInsight (String[] report) {
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        try {
            waitforElementTobeClickable(reportDetails);
            driver.findElement(reportDetails).click();
            pageScrolldown(reportDetails);
            ////div [@id ='Reports']
            String[] reports = new String[3];
            reports[0] = driver.findElement(depthreport).getText();
            reports[1] = driver.findElement(regdata).getText();
            reports[2] = driver.findElement(behaviouraldata).getText();
            for (String iterator : report) {
                Assert.assertEquals(report, reports);
            }
        } catch (Exception e) {
            System.out.println("Error in Business Insight section " + e.getMessage() + "/n" + e.getCause());
            logUtilities.error("In Business Insight "+e.getMessage());
        }
    }

    public void getOffers (String[] rewards) {
        try {
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            waitforElementTobeClickable(lnkOffers);
            driver.findElement(lnkOffers).click();
            waitforElementTobeClickable(lnkRewards);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            pageScrolldown(lnkRewards);
            driver.findElement(lnkRewards).click();
            String[] offers = new String[3];
            offers[0] = driver.findElement(txtRewards).getText();
            offers[1] = driver.findElement(txtPayback).getText();
            offers[2] = driver.findElement(txtClickSBI).getText();
            for (String iterator : offers) {
               Assert.assertEquals(offers, rewards);
            }
        } catch (Exception e) {
            System.out.println("Error in Offers section " + e.getMessage() + "/n" + e.getCause());
            logUtilities.error("In Offers "+e.getMessage());
        }
    }

    public void discountOffers (String discounts) {
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(lnkOffers).click();
        try {
            waitforElementTobeClickable(txtSearchbox);
            String discount =discounts.substring(0,15);
            driver.findElement(txtSearchbox).sendKeys(discount);
            pageScrolldown(txtSearchbox);
            if (driver.findElements(txtdiscount).size()>0) {
                waitforElementTobeClickable(txtdiscount);
                List<WebElement> options = driver.findElements(txtdiscount);
                for (WebElement option : options) {
                    if (option.getText().equalsIgnoreCase(discounts)) {
                        option.click();
                        break;
                    }
                }
            }
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            //   driver.findElements(By.className("tt-highlight")).get(0).click();
          } catch (Exception e) {
            System.out.println("Error in Discount Offers section " + e.getMessage() + "/n" + e.getCause());
            logUtilities.error("In Discount Offers "+e.getMessage());
        }
    }

    public void FooterTextValidation (String [] footers){
        try {
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            pageScrolldown(footer0);
            String footervalue = driver.findElement(footer0).getText();
            Assert.assertEquals(footervalue,footers[0]);
            footervalue = driver.findElement(footer1).getText();
            Assert.assertEquals(footervalue,footers[1]);
            footervalue = driver.findElement(footer2).getText();
            Assert.assertEquals(footervalue,footers[2]);
            footervalue = driver.findElement(footer3).getText();
            Assert.assertEquals(footervalue,footers[3]);
        }catch (Exception e){
            System.out.println("Error in FooterText Validation "+ e.getMessage()+ "\n"+e.getCause());
            logUtilities.error("In FooterText Validation "+e.getMessage());
        }

    }
}
    //    @FindBy(xpath = "//div[@class='search-container']/span/input[2]")
//    private WebElement txtSearchbox;
//
//    public SearchMovie(WebDriver driver){
//        super(driver);
//        PageFactory.initElements(driver,this);
//    }
//
//    public void SearchingMovie(String movie_name){
//        waitforElementPresent((By) txtSearchbox);
//        txtSearchbox.sendKeys(movie_name);
//        txtSearchbox.click();
//    }

