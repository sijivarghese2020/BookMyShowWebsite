package BookMyShow.PageObjects;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Fanhood extends BasePage {
    WebDriver driver;
    By lnkfanhood = By.linkText("Fanhood");
    By lnkProducts = By.xpath("//div[@class ='container']/ul/li[2]/a[text()='Products']");
    By lnkPlanner = By.xpath("//div[@class ='container']/ul//li[a/text()='Products']//div[span/@class ='mega-menu__title heading' and span/text()='Books']//li [@class ='mega-menu__item' ]/a[text()='Planner']");
    By countProducts =By.xpath("//div[@class ='product-item__info']");
    public Fanhood (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public String[]  selectFanhood(String fan){
        String[] items = new String[2];
        try {
            waitforElementTobeClickable(lnkfanhood);
            driver.findElement(lnkfanhood).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            String strurl = driver.getCurrentUrl();
            System.out.println(strurl);
            Assert.assertTrue(strurl.contains(fan));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(lnkProducts).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(lnkPlanner).click();
            items[0] = strurl;
            int count = driver.findElements(countProducts).size();
            System.out.println(count);
            int value =driver.findElements(By.xpath("//div[@class ='filter-option filter-option-price']/li/ul[@class ='filter-content']")).size();
                    //driver.findElement(By.xpath("//li[@class ='or filter-item filter']")).getText();
            System.out.println(value);
        }catch (Exception e){
            System.out.println("Exception in selecting Fanhood "+ e.getMessage());
        }
        return items;
    }
}
