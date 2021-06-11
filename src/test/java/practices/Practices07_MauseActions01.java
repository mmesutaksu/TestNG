package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.event.ActionEvent;
import java.util.Set;

public class Practices07_MauseActions01 extends TestBase {

    /*
        1- Yeni bir class olusturalim: D14_MouseActions1
        2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        3- Cizili alan uzerinde sag click yapalim
        4- Alert’te cikan yazinin “You selected a context menu” oldugunu

        test edelim.

        5- Tamam diyerek alert’I kapatalim
        6- Elemental Selenium linkine tiklayalim
        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        WebElement tikAlani = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(tikAlani).perform();

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";

        Assert.assertEquals(actualAlertText,expectedAlertText);

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        String firstTagHAndle = driver.getWindowHandle();
        Set<String> allHandle = driver.getWindowHandles();

        String secondTagHandle = "";
        for (String w : allHandle){
            if (!firstTagHAndle.equals(w)){
                secondTagHandle = w;
            }
        }

        driver.switchTo().window(secondTagHandle);

        WebElement secondTagTextWE = driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));
        String actuelSeconTagText = secondTagTextWE.getText();
        String expectedSecondTagText = "Elemental Selenium";

        Assert.assertEquals(actuelSeconTagText,expectedSecondTagText);


    }

}
