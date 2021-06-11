package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Practice04_SwitchToAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
     ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
     ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının   “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
     ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    */

    @Test
    public void acceptAlert(){
        // ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        WebElement firstAlertWE = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        firstAlertWE.click();

        driver.switchTo().alert().accept();

        WebElement resultWE = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultWE.getText();
        String expectedResult = "You successfully clicked an alert";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult, "Kazim yüzünden FAILD oldu");

        softAssert.assertAll();
    }

    @Test
    public void dismissAlert(){
        // ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının   “successfuly” icermedigini test edin.
        WebElement secondAlert = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        secondAlert.click();

        driver.switchTo().alert().dismiss();

        WebElement resultWE = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultWE.getText();
        String expectedResult = "successfuly";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(actualResult.contains(expectedResult));

        softAssert.assertAll();
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement thirdAlert = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        thirdAlert.click();

        driver.switchTo().alert().sendKeys("Kazim'in saclari yok");
        driver.switchTo().alert().accept();

        WebElement resultWE = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultWE.getText();
        String expectedResult = "Kazim'in saclari yok";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualResult.contains(expectedResult));

        softAssert.assertAll();
    }
}
