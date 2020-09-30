package BookMyShow.PageObjects;

import BookMyShow.Common.logUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class selectValues extends BasePage{
    WebDriver driver;
    By lstlanguage = By.xpath("//ul[@class ='options']/li");
    By linklang = By.xpath("//div[@class='lang-select']");
    By selectEng = By.xpath("//ul/li[@data-name ='English']");
////div/a[@class='logo']
    public selectValues (WebDriver driver) {
        super(driver);
        this.driver= driver;
    }
    public void chooseLanguage(){
   //     driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(selectEng).click();
    }
    public List<String> selectLanguage(String language){
        List<String> langList = new ArrayList<String>();
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(linklang).click();
            //ul[@class ='options']/li/@data-name
            //     By.xpath("//ul[@class ='options']/li");
            List<WebElement> sublang = driver.findElements(lstlanguage);
            for (WebElement option : sublang) {
                langList.add(option.getAttribute("data-name"));
            }
        } catch (Exception e) {
            System.out.println("Error in Choose Language " + e.getMessage() + "\n" + e.getCause());
            logUtilities.error("In Choose Language " + e.getMessage());
        }
        return langList;
    }
}
