package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice05_IFrame {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        driver.get("https://the-internet.herokuapp.com/iframe");

        //  ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
        WebElement textWE = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(textWE.isEnabled());

        System.out.println(textWE.getText());

        // ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameWE = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameWE);

        WebElement iFrameText = driver.findElement(By.xpath("//body[@id='tinymce']"));
        iFrameText.clear();
        iFrameText.sendKeys("Hello World!");

        driver.switchTo().parentFrame();

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
        WebElement linkWE = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));

        Assert.assertTrue(linkWE.isDisplayed());

        System.out.println(linkWE.getText());
    }
}
