package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_IFramePlay {

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

    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");

        // iframe'i locate ettik
        WebElement iFrameWE = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));

        // iframe'e gecis yaptik
        driver.switchTo().frame(iFrameWE);

        // Video'nun Play butonu'nu locate ettik ve tikladik
        WebElement videoPlayButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        videoPlayButton.click();

        // iframe'den cikis yaptik
        driver.switchTo().defaultContent();
    }
}
