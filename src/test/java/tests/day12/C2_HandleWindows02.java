package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C2_HandleWindows02 extends TestBase{

    /*
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

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

            String firstTab = driver.getWindowHandle(); // anasayfa'nin window handle'ini aldim

            //● Click Here butonuna basın.
            WebElement clickButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
            clickButton.click();

            // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

            Set<String> allHandle = driver.getWindowHandles();

            String secondTab = "";
            for (String w : allHandle) {

                if (!firstTab.equals(w)){
                    secondTab=w;
                }
            }

            driver.switchTo().window(secondTab);

            String actualSecondTabTitle = driver.getTitle();
            String expectedSecondTabTitle = "New Window";

            Assert.assertEquals(actualSecondTabTitle,expectedSecondTabTitle);

            //● Sayfadaki textin “New Window” olduğunu doğrulayın.
            WebElement text2WE = driver.findElement(By.xpath("//h3[text()='New Window']"));
            String actuelText2 = text2WE.getText();
            String expectedText2 = "New Window";

            Assert.assertEquals(actuelText2,expectedText2);

            //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
            driver.switchTo().window(firstTab);

            Assert.assertEquals(actuelTitle1,expectedTitle1);
            }
        }


