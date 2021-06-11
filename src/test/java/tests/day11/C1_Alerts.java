package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C1_Alerts {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

     /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
     ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfuly clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
     ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının   “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
     ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    */

    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String expectedResult = "You successfully clicked an alert";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String expectedResult = "successfuly";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertFalse(actualResult.contains(expectedResult));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("mesut");
        driver.switchTo().alert().accept();

        String expectedResult = "mesut";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
