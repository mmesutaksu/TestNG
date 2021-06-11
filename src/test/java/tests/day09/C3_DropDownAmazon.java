package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_DropDownAmazon {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    /*
    ● https://www.amazon.com/ adresine gidin.
    - Test 1
         Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    -Test 2
         1. Kategori menusunden Books secenegini  secin
         2. Arama kutusuna Java yazin ve aratin
         3. Bulunan sonuc sayisini yazdirin
         4. Sonucun Java kelimesini icerdigini test edin

     */
    @Test
    public void test01(){

        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(dropDown);
        List<WebElement> allOptions = options.getOptions();
        int expected = 45;
        int actual = allOptions.size();
        //////Assert.assertEquals(actual,expected,"Kategori sayisi 45 degildir.");
    }

    @Test
    public void test02() {

        //1. Kategori menusunden Books secenegini  secin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(dropDown);

        List<WebElement> allOptions = options.getOptions();

        options.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedWord = "Java";
        Assert.assertTrue(sonuc.getText().contains(expectedWord));
    }
}
