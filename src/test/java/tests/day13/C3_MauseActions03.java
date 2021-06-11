package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C3_MauseActions03 extends TestBase {

    /*
    Yeni bir class olusturalim: D15_MouseActions4
    1- https://www.facebook.com adresine gidelim
    2- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    3- Kaydol tusuna basalim
    */

    @Test
    public void test01(){
        driver.get("https://facebook.com");

    }
}
