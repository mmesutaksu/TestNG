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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Practice06_GetWindowHandle3 {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text1WE = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String actuelText1 = text1WE.getText();
        String expectedText1 =  "Opening a new window";

        Assert.assertEquals(actuelText1,expectedText1);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actuelTitle1 = driver.getTitle();
        String expectedTitle1 = "The Internet";

        Assert.assertEquals(actuelTitle1,expectedTitle1);

        //● Click Here butonuna basın.
        WebElement clickButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickButton.click();

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> allHandle = driver.getWindowHandles();
        ArrayList<String> arr = new ArrayList<>(allHandle);

        String parentHandle = arr.get(0);
        String childHandle = arr.get(1);

        driver.switchTo().window(childHandle);

        String actuelChildTitle = driver.getTitle();
        String expectedChildTitle = "New Window";

        Assert.assertEquals(actuelChildTitle,expectedChildTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement text2WE = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String actuelText2 = text2WE.getText();
        String expectedText2 = "New Window";

        Assert.assertEquals(actuelText2,expectedText2);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(parentHandle);

        Assert.assertEquals(actuelTitle1,expectedTitle1);
    }
}
