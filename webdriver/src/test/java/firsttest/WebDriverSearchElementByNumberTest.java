package firsttest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebDriverSearchElementByNumberTest {

    @Test
    public void CommonSearchTest(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ikea.lt/lt");
        WebElement searchElement = driver.findElement(By.id("header_searcher_desktop_input"));
        searchElement.sendKeys("205.221.07");
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"headerMainToggler\"]/div/div[2]/div[1]/div/div/button"));
        searchBtn.click();

        List<WebElement> searchResult = driver.findElements(By.xpath("//*[@id=\"contentWrapper\"]/div[2]/div/div[2]"));

        WebElement AcceptBtn = driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonAccept\"]"));
        AcceptBtn.click();

        Assert.assertTrue("Search result is not searchable!", searchResult.size()==1);

        driver.quit();

    }
}
