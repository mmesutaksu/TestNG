package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import static org.testng.Assert.*;

public class C4_UploadFile extends TestBaseClass {
    /*
    1.Tests packagenin altina bir class oluşturun : D14_UploadFile
    2.https://the-internet.herokuapp.com/upload adresine gidelim
    3.chooseFile butonuna basalim
    4.Yuklemek istediginiz dosyayi secelim.
    5.Upload butonuna basalim.
    6.“File Uploaded!” textinin goruntulendigini test edelim.
     */
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/upload");

        // Dosya sec butonunu locate edin
        WebElement dosyaSecButton = driver.findElement(By.id("file-upload"));

        // Upload olacak dosyanin yolunu bulalim
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\FLOWER.jpg";

        // sendkey ile dosyayi gönderecegiz
        dosyaSecButton.sendKeys(dosyaYolu);

        // Upload butonuna tiklayalim
        driver.findElement(By.id("file-submit")).click();

        WebElement onayYazisi = driver.findElement(By.tagName("h3"));
        assertTrue(onayYazisi.isDisplayed());

    }

}
