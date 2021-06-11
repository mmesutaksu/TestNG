package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;

public class C5_KeyboardActions02 extends TestBase {
    /*
    1- Bir Class olusturalim D14_KeyboardActions2
    2- https://html.com/tags/iframe/ sayfasina gidelim
    3- video’yu gorecek kadar asagi inin
    4- videoyu izlemek icin Play tusuna basin
    5- videoyu calistirdiginizi test edin
    */
    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iFrameWE = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));

        driver.switchTo().frame(iFrameWE);

        WebElement videoPlayButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        videoPlayButton.click();


    }
}
