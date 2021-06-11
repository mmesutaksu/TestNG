package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Set;

public class C2_HandleWindows01 extends TestBase {

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        String firstTab = driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> allHandle = driver.getWindowHandles();

        String secondTab = "";
        for (String w : allHandle) {

            if (!firstTab.equals(secondTab)){
                secondTab=w;
            }
        }

        driver.switchTo().window(secondTab);

        WebElement secondTabText = driver.findElement(By.xpath("//a[@text='subheader']"));
        System.out.println(secondTabText.getText());

    }
}
