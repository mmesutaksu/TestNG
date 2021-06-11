package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice03_Select {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

    /*
     1. “http://zero.webappsecurity.com/” Adresine gidin
     2. Sign in butonuna basin
     3. Login kutusuna “username” yazin
     4. Password kutusuna “password.” yazin
     5. Sign in tusuna basin
     */
    @Test
    public void test01(){
        driver.get("http://zero.webappsecurity.com/");

        WebElement signIn = driver.findElement(By.xpath("//button[@id='signin_button']"));
        signIn.click();

        WebElement username = driver.findElement(By.xpath("//input[@id='user_login']"));
        username.sendKeys("username");

        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        WebElement rememberMeCheckBox = driver.findElement(By.xpath("//input[@id='user_remember_me']"));
        rememberMeCheckBox.click();

        WebElement signInButton = driver.findElement(By.xpath("//input[@name='submit']"));
        signInButton.click();

        // Güvenlik duvari icin yazilan kod
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        WebElement transferButton = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
        transferButton.click();

        WebElement fromAccount = driver.findElement(By.xpath("//select[@id='tf_fromAccountId']"));
        Select option = new Select(fromAccount);
        option.selectByValue("4");

        WebElement toAccount = driver.findElement(By.xpath("//select[@id='tf_toAccountId']"));
        Select option1 = new Select(toAccount);
        option.selectByValue("2");

        WebElement amount = driver.findElement(By.xpath("//input[@id='tf_amount']"));
        amount.sendKeys("500.2");

        WebElement description = driver.findElement(By.xpath("//input[@id='tf_description']"));
        description.sendKeys("Borc yigidin kamcisidir");

        WebElement contineButton = driver.findElement(By.xpath("//button[@id='btn_submit']"));
        contineButton.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='btn_submit']"));
        submitButton.click();

        WebElement onlineStatementsButton = driver.findElement(By.xpath("//a[text()='Online Statements']"));
        onlineStatementsButton.click();

        WebElement accountOptionsWE = driver.findElement(By.xpath("//select[@id='os_accountId']"));
        Select accountOptions = new Select(accountOptionsWE);
        accountOptions.selectByIndex(1);

        List<WebElement> list = accountOptions.getOptions();

        List<String> actualList = new ArrayList<String>(); //Bos list

        // Karsilastiralim "Savings","Checking","Savings","Loan","Credit Card","Brokerage"
        List<String> expectedList = Arrays.asList("Savings","Checking","Savings","Loan","Credit Card","Brokerage");

        for (WebElement w : list) {
            actualList.add(w.getText());
        }

        Assert.assertEquals(actualList,expectedList);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualList,expectedList);
        softAssert.assertAll();
    }
}
