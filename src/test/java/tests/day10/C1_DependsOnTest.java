package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C1_DependsOnTest {

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
    ● https://www.walmart.com/ adresine gidin.
    1. Test : Wallmart ana sayfaya gittiginizi test edin
    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $6.65 oldugunu test edin
     */

    @Test
    public void test01(){
        driver.get("https://www.walmart.com/");
        String expecteUrl = "https://www.walmart.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expecteUrl);
    }

    @Test (dependsOnMethods = "test01")
    public void test02(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String searchWord = "Nutella";
        searchBox.sendKeys(searchWord+ Keys.ENTER);

        String actuelTitle = driver.getTitle();
        Assert.assertTrue(actuelTitle.contains(searchWord));
    }

    @Test (dependsOnMethods = "test01")
    public void test03(){
        driver.findElement(By.xpath("//img[@data-pnodetype='item-pimg']")).click();
        WebElement fiyatWE = driver.findElement(By.xpath("//span[@class='price-group']"));

        String actualFiyat = fiyatWE.getText();
        String expectedFiyat = "$7.97";

        Assert.assertEquals(actualFiyat,expectedFiyat);
    }
}
