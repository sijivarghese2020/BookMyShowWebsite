package BookMyShow.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page{
    public BasePage (WebDriver driver) {
        super(driver);
    }

    @Override
    public String getpageTitle () {
        return driver.getTitle();
    }

    @Override
    public String getPageHeader (By locator) {
        return getElement(locator).getText();
    }

    @Override
    public WebElement getElement (By locator) {
        WebElement element = null;
        try{
            element.findElement(locator);
        }catch (Exception e){
            System.out.println("Error occurred while creating element"+locator.toString());
        }
        return element;
    }

    @Override
    public void waitforElementPresent (By locator) {
        try{
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e){
            System.out.println("Exception while waiting for the element presence "+locator.toString());
        }
    }

    @Override
    public void waitforPageTitle (String title) {
        try{
            wait.until(ExpectedConditions.titleContains(title));
        }catch (Exception e){
            System.out.println("Exception while waiting for Page Title "+title);
        }
    }

    @Override
    public void waitforElementTobeClickable (By locator) {
        try {
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            System.out.println("Exception while waiting for the element to click "+locator);
        }
    }
    @Override
    public void waitforElementVisibility(By locator){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void pageScrolldown (By locator){
        WebElement webElement = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
