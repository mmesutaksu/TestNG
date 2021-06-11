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
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice01 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://best.aliexpress.com/?lan=en");
        driver.findElement(By.xpath("//div[@class='Sk1_X _1-SOk']")).click();
    }
    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test01(){

        WebElement kategoriler = driver.findElement(By.xpath("//select[@id='search-dropdown-box']"));
        Select options = new Select(kategoriler);

        //options.selectByIndex(8);
        options.selectByValue("26");
        //options.selectByVisibleText("Spielzeug und Hobbys");

        driver.findElement(By.xpath("//input[@id='search-key']")).sendKeys("zürafa"+ Keys.ENTER);
    }

}
