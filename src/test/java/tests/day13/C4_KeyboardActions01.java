package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C4_KeyboardActions01 extends TestBase {
    /*
    1- Bir Class olusturalim D14_KeyboardActions1
    2- https://www.amazon.com sayfasina gidelim
    3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    4- aramanin gerceklestigini test edin
    */

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox).click().
                sendKeys("samsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();

        String actuelResult = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String expectedText = "samsung A71";
        Assert.assertTrue(actuelResult.contains(expectedText));
    }
}
