package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_Senkronizasyon extends TestBase {

    @Test
    public void implicitWaitTest(){

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini test edin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebElement message= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement message2 = driver.findElement(By.cssSelector("p#message"));
        Assert.assertTrue(message2.isDisplayed());

    }

    @Test
    public void explicitWaitTest(){

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini test edin.
        WebDriverWait wait = new WebDriverWait(driver,30);

        WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement message2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));


    }
}
