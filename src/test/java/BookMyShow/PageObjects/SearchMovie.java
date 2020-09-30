package BookMyShow.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchMovie extends BasePage{

    @FindBy(xpath = "//div[@class='search-container']/span/input[2]")
    private WebElement txtSearchbox;

    public SearchMovie(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void SearchingMovie(String movie_name){
        waitforElementPresent((By) txtSearchbox);
        txtSearchbox.sendKeys(movie_name);
        txtSearchbox.click();
    }
}
