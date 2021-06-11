package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_SoftAssertion {



    /* 'Selenium ögrenmek cok zevkli' cümlesinde asagidaki testleri yapin

    - Cümle 'ögrenmek' iceeriyor
    - Cümle 'Java' icermiyor
    - Cümle 4 kelimeden olusuyor
    - Cümledeki karakter sayisi 25
    */

    String cümle = "Selenium ögrenmek cok zevkli";
    String expected1 = "ögrenmek";
    String expected2 = "Java";

    @Test
    public void hardAssertionTest(){

        Assert.assertTrue(cümle.contains(expected1));
        Assert.assertFalse(cümle.contains(expected2));

        String kelimeler[] = cümle.split(" ");
        Assert.assertEquals(kelimeler.length,4);

        String karakter[] = cümle.split("");
        Assert.assertEquals(karakter.length,25);
    }

    @Test
    public void softAssertionTest(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(cümle.contains(expected1));
        System.out.println("1");

        softAssert.assertTrue(cümle.contains(expected2));
        System.out.println("2");

        String kelimeler[] = cümle.split(" ");
        softAssert.assertEquals(kelimeler,4);
        System.out.println("3");

        String karakter[] = cümle.split("");
        softAssert.assertEquals(karakter.length,25,"FAILD");
        System.out.println("4");

        softAssert.assertAll();
    }

}
