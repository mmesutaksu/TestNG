package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C5_FakerClass extends TestBaseClass {

    @Test
    public void facebookFaker() {
        //1."https://facebook.com" Adresine gidin
        driver.get("http://facebook.com/");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();

        //2.“create new account” butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3.“firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String sifre = faker.internet().password();
        System.out.println(email+"\n"+sifre);

        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("10").
                sendKeys(Keys.TAB).
                sendKeys("May").
                sendKeys(Keys.TAB).
                sendKeys("2010").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                sendKeys(Keys.ENTER).
                perform();


        //4.“surname” giris kutusuna bir soyisim yazin
        //5.“email” giris kutusuna bir email yazin
        //6.“email” onay kutusuna emaili tekrar yazin
        //7.Bir sifre girin
        //8.Tarih icin gun secin
        //9.Tarih icin ay secin
        //10.Tarih icin yil secin
        //11.Cinsiyeti secin
        //12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //13.Sayfayi kapatin
    }
}
