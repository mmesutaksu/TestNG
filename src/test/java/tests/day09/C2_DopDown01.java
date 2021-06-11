package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C2_DopDown01 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown değerleri(value) yazdırın
        5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */
    @Test
    public void indexSelectTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(dropDownMenu);
        options.selectByIndex(1);
        System.out.println(options.getFirstSelectedOption().getText());
    }

    @Test
    public void indexValueTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(dropDownMenu);
        options.selectByValue("2");
        System.out.println(options.getFirstSelectedOption().getText());
    }

    @Test
    public void valueVisibleTextTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(dropDownMenu);
        options.selectByVisibleText("Option 1");
        System.out.println(options.getFirstSelectedOption().getText());

        System.out.println();
    }

    @Test
    public void tümListe(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(dropDownMenu);

        List<WebElement> allOptions = options.getOptions();

        System.out.println("Tüm Options Listesi:");
        for (WebElement each : allOptions) {
            System.out.println("-"+each.getText());
        }

        System.out.println("DropDown'daki WebElement sayisi: "+allOptions.size());

    }
}