package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C2_IsExist {

    @Test
    public void test01(){
        // masaüstünde flower dosyasi oldugunu test edin
        String mainPath = System.getProperty("user.home");

        // dosya yolunu string olarak kaydedelim
        String dosyaYolu = mainPath+"\\Desktop"+"\\FLOWER.jpg";
        System.out.println(dosyaYolu);

        // Assertion yapalim
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
