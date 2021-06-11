package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_SoftAssertiTest {

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
    Yeni bir Class Olusturun : D10_SoftAssertTest
     1. “http://zero.webappsecurity.com/” Adresine gidin
     2. Sign in butonuna basin
     3. Login kutusuna “username” yazin
     4. Password kutusuna “password.” yazin
     5. Sign in tusuna basin
     6. Pay Bills sayfasina gidin
     7. “Purchase Foreign Currency” tusuna basin
     8. “Currency” drop down menusunden Eurozone’u secin
     9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
     10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    */
    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin
        WebElement username = driver.findElement(By.id("user_login"));
        username.sendKeys("username");

        //4. Password kutusuna “password.” yazin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // Güvenlik duvari icin yazilan kod
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement kategoriler = driver.findElement(By.id("pc_currency"));
        Select options = new Select(kategoriler);
        List<WebElement> list = options.getOptions();//10. soruda kullanacagim softassert sarti icin olusturuldu.
        options.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actual = options.getFirstSelectedOption().getText();
        String expected = "Eurozone (Euro)";
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actual,expected,"Yaptigimiz secim ile beklenen 'Eurozone (Euro)' ayni degildir.");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",........
        List<String > expectedList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)", "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)", "Singapore (dollar)","Thailand (baht)");

        List<String> actualList = new ArrayList<String>();
        for (WebElement w : list) {
            actualList.add(w.getText());
        }

        softAssert.assertEquals(actualList,expectedList);


        softAssert.assertAll();





    }
}
