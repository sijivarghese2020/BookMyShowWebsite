package BookMyShow.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public Page (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 1);

    }
//abstract methods
//get Page title
    public abstract String getpageTitle();

    public abstract String getPageHeader (By locator);

    public abstract WebElement getElement (By locator);

    public abstract void waitforElementPresent (By locator);

    public abstract void waitforPageTitle (String title);

    public abstract void waitforElementTobeClickable(By locator);

    public abstract void waitforElementVisibility(By locator);

}
