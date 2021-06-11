package tests.day12;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C4_MouseActionGiris extends TestBase {

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        driver.findElement(By.xpath("//span[@text()='Creat a List']"));
    }
}
