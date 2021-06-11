package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class practice02 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test(){
        driver.get("http://amazon.com");
        WebElement kategoriler = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(kategoriler);
        options.selectByVisibleText("Computers");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("computer"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='Monitors']")).click();
        driver.findElement(By.partialLinkText("(LS34J550WQNXZA)")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }
}
