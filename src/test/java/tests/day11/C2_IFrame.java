package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_IFrame {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }

     /*
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
     ○ Text Box’a “Merhaba Dunya!” yazin.
     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
    */

    @Test
    public void iframeTest(){
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
        WebElement iFrameYazisiWE = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(iFrameYazisiWE.isEnabled());

        System.out.println(iFrameYazisiWE.getText());

        //○ Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(0); // iframe'e girdik

        WebElement textAlani = driver.findElement(By.cssSelector(".mce-content-body "));
        textAlani.clear();
        textAlani.sendKeys("Merhaba Dunya!");

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
        driver.switchTo().parentFrame(); // iframe'den ciktik

        WebElement linkWE = driver.findElement(By.linkText("Elemental Selenium"));
        softAssert.assertTrue(linkWE.isDisplayed());
        System.out.println(linkWE.getText());




        softAssert.assertAll();
    }

}
