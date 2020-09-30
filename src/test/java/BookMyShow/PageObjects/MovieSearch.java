package BookMyShow.PageObjects;

import BookMyShow.Common.Driver;
import BookMyShow.Common.logUtilities;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MovieSearch extends BasePage {
    private WebDriver driver;

    By txtMovieSearch = By.xpath("//nav//div//input[@id ='input-search-box']");
    By optionMovie = By.xpath("//span/input[@class='search-box typeahead tt-input']");

    By closeButton = By.xpath("//div [@id ='showcase-primary'] //span[@class ='__dismiss icon-cancel']");

//tt-suggestion tt-selectable
    By txtclsRegion = By.className("tt-selectable");
   // By txtRegionSearch = By.id("inp_RegionSearch_top");
    By txtRegionSearch = By.xpath("//li[@class ='secondary-menu location-container']//span[@id='spnSelectedRegion']");
    By txtLocation = By.id ("inp_RegionSearch_top");
    By titleMovie = By.xpath("//div/h1[@title ='Fantasy Island']");

    By popup =By.id("wzrk-cancel");
    By lstMovie = By.className("tt-selectable");
    By moviename =By.xpath("//div/h1[@id='eventTitle']");
    By txtNorecords = By.xpath("//div/span[@class='__red-text']");
    By txtActor =By.xpath("//div[@class ='__cast-member']");
    By txtMusician = By.xpath("//div[@class ='__cast-member']");
    By labelCast = By.id("cast");

    public MovieSearch (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void ChooseLocation (String location) {
        try {
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           driver.findElement(closeButton).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   //         waitforElementPresent(txtRegionSearch);
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    //        driver.findElement(txtRegionSearch).click();
            driver.findElement(txtLocation).sendKeys(location);
            driver.findElements(txtclsRegion).get(0).click();
            driver.findElement(closeButton).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    //        waitforElementPresent(popup);
    //        driver.findElement(popup).click();
        }catch (Exception e){
            System.out.println("Error in Location selection "+ e.getMessage()+ "\n"+ e.getCause());
            logUtilities.error("In Location selection "+e.getMessage());
        }
    }

    public void ChooseMoviename (String movie){
        try {
            driver.findElement(txtMovieSearch).sendKeys(Keys.CONTROL, "a");
            driver.findElement(txtMovieSearch).sendKeys(Keys.DELETE);

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(txtMovieSearch).sendKeys(movie);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElements(lstMovie).get(0).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("Error in Movie Search: " + e.getMessage());
            logUtilities.error("Could not complete Movie Search "+e.getMessage());
    }
     //   driver.findElements(By.className("tt-menu tt-open")).get(0).click();

//        String actualtitle = driver.findElement(moviename).getText();
//        Assert.assertEquals(actualtitle,"Fantasy Island");
            //Assert.assertTrue();
//        List<WebElement> movieoptions = driver.findElements(optionMovie);
//        for(WebElement option : movieoptions){
//            if (option.getText().equalsIgnoreCase("Fantasy Island")){
//                option.click();
//                break;
//            }
//        }
    }

    public void ChooseCastCrew(String actor,String musician) throws Exception{

    ///    waitforElementPresent(txtActor);
        driver.findElement(txtMovieSearch).clear();
        String actorname = driver.findElement(txtActor).getText();
        actorname =actorname.substring(0,11);
        String musicianname = driver.findElements(txtMusician).get(5).getText();
        musicianname = musicianname.substring(0,13);
        Assert.assertEquals(actorname,actor);
        Assert.assertEquals(musicianname,musician);
        WebElement webElement = driver.findElement(labelCast);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
  //      Driver.takeScreenshot();
    }


    public  void actorSearch(HashMap<String,String> data){
        try{
           driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
           ChooseMoviename(data.get("Movie"));
           ChooseCastCrew(data.get("Cast1"),data.get("Crew1"));
        }catch (Exception e){
            System.out.println("Error in actor searching "+ e.getMessage());
            logUtilities.error("Cast and Crew "+e.getMessage());
        }

    }
    public void ChooseCastCrewNegative (HashMap<String, String> data) {
        try{
            // ChooseLocation(data.get("Location"));
            // ChooseMoviename(data.get("Movie"));
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            String actor = data.get("Cast2");
            String musician =data.get("Crew2");
            String actorname = driver.findElement(txtActor).getText();
            actorname =actorname.substring(0,11);
            String musicianname = driver.findElements(txtMusician).get(5).getText();
            musicianname = musicianname.substring(0,13);
       //     SoftAssert softAssert = new SoftAssert();
            Assert.assertNotEquals(actor, actorname);
         //   softAssert.assertEquals(actor, actorname);
            Assert.assertNotEquals(musician, musicianname);
      //      softAssert.assertEquals(musician, musicianname);
            pageScrolldown(labelCast);
        //    Driver.takeScreenshot();
         //   softAssert.assertAll();
        }catch (Exception e){
            System.out.println("Error in actor searching "+ e.getMessage());
            logUtilities.error("Cast and Crew Negative "+e.getMessage());
        }
    }
    public void SearchingMovie (String movie) {
        try {

            waitforElementVisibility(txtMovieSearch);
            driver.findElement(txtMovieSearch).sendKeys(movie);
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            driver.findElements(lstMovie).get(0).click();
            driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("Error in "+e.getCause()+" "+e.getMessage());
            logUtilities.error("Movie Search "+e.getMessage());
        }
    }
    public void SearchMovie (String location, String movie) {
        try {

            ChooseLocation(location);
            waitforElementPresent(popup);
            driver.findElement(popup).click();
          //  wait = new WebDriverWait(driver, 10);
          //  wait.until(ExpectedConditions.invisibilityOfElementLocated(closeButton));
            ChooseMoviename(movie);
        }catch (Exception e){
            System.out.println("Error in "+this.getClass()+ "   "+e.getCause()+" "+e.getMessage());
        }
    }
    public void chooseCity (String location) {
        try {
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        //    driver.findElement(closeButton).click();
            waitforElementPresent(txtRegionSearch);
            driver.findElement(txtRegionSearch).click();
            driver.findElement(txtLocation).sendKeys(location);
            driver.findElements(txtclsRegion).get(0).click();
        //    driver.findElement(closeButton).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //      waitforElementPresent(popup);
       //     driver.findElement(popup).click();
        }catch (Exception e){
            System.out.println("Error in Location selection "+ e.getMessage()+ "\n"+ e.getCause());
            logUtilities.error("Choose City "+e.getMessage());
        }
    }

}




//        driver.findElement(By.xpath("//nav/div/div/div[2]/div/input[@id='input-search-box']")).sendKeys(movie);
        //     waitforElementPresent(txtsearch);

//        Thread.sleep(4000);
        //    findDynamicElement(movie);

//        Alert alert = driver.switchTo().alert();
//        driver.switchTo().alert();
//        alert.dismiss();
//        driver.switchTo().parentFrame();
//        driver.switchTo().alert().dismiss();
        // driver.switchTo().defaultContent();
        //  driver.findElement(By.xpath('//div[contains(@class,"ui-dialog") and @aria-describedby="dialogContent2"]//button[@title="Close"]').click()
        //System.out.println(driver.findElement(By.cssSelector("//*[@id=\"showcase-primary\"]/div[2]")).isEnabled());


////div/span/input[@class='search-box typeahead tt-input']
        //     driver.findElement(optionMovie).sendKeys(movie);


//        System.out.println(driver.findElement(optionMovie).getText());
////        waitforElementTobeClickable((WebElement) optionMovie);

        //      Thread.sleep(6000);
        //
        //     driver.findElement(optionMovie).click();
        //     Thread.sleep(6000);
//        List<WebElement> movieoptions = driver.findElements(optionMovie);
//        for(WebElement option : movieoptions){
//            if (option.getText().equalsIgnoreCase(movie)){
//                option.click();
//                break;
//            }
//        }

//        Set <String> handleIds = driver.getWindowHandles();
//        Iterator<String> iterator = handleIds.iterator();
//        String parent_Id = iterator.next();
//        System.out.println(parent_Id);
////        String child_Id = iterator.next();
//        driver.switchTo().window(parent_Id);

        //    driver.findElement(By.cssSelector("#showcase-primary > div.showcase-overlay.puff-reverse > div.overlay-card._video")).click();
        //       driver.switchTo().alert().dismiss();
        //  Thread.sleep(7000);
        //      driver.findElement(spanSelectRegion).click();
//        Set <String> handleIds = driver.getWindowHandles();
//        Iterator<String> iterator = handleIds.iterator();
//        String parent_Id = iterator.next();
//        String child_Id = iterator.next();
//        driver.switchTo().window(child_Id);
        //  driver.findElement(By.xpath("//div[@id ='showcase-primary']/div[2]//div[2] "));
        //   System.out.println(driver.findElement(By.xpath("//div[@id ='showcase-primary']/div[2]//div[2] ")).isDisplayed());
        //      System.out.println("element capute "+ txtRegionSearch);
        //      driver.findElement(txtRegionSearch).click();
        //   waitforElementPresent(SelectRegion);
        //  Set <String> handleIds = driver.getWindowHandles();
//        Iterator<String> iterator = handleIds.iterator();
//        String parent_Id = iterator.next();
//        String child_Id = iterator.next();
//        driver.switchTo().window(child_Id);
        //   Thread.sleep(1000);
        //      wait =  new WebDriverWait(driver,10);
        // driver.findElement(SelectRegion).click();
        //  waitforElementPresent(txtRegionSearch);
        ;
        //     waitforElementPresent(txtSearchbox);
        //      driver.findElement(txtSearchbox).click();
        //    WebElement RegionSearch = driver.findElement(By.xpath("//div[@class='search-container']/span/input[2]"));

//        String childWindowHandle = driver.getWindowHandle();
//        System.out.println("hiiiii " +childWindowHandle);
//        driver.switchTo().window(childWindowHandle);
//        ;
//        System.out.println(txtRegionSearch);
//
//        Set<String> allowWindowhandles = driver.getWindowHandles();
//        for (String handle : allowWindowhandles){
//            driver.switchTo().window(handle);
//            System.out.println(handle);
//        }
//        waitforElementPresent(txtRegionSearch);
//        System.out.println(txtRegionSearch);
//        driver.findElement(txtRegionSearch).sendKeys("Kochi");
//        waitforElementPresent(txtSearchbox);
//

