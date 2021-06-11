package tests.day14;

import org.testng.annotations.Test;

public class C1_BilgisayardakiDosyalaraUlasma {

    @Test
    public void test01() {
        // System.getProperty("user.dir"); // icinde oldugumuz projenin bilgisayardaki yolunu verir.
        System.out.println(System.getProperty("user.dir"));

        // System.getProperty("user.home"); // kullandigimiz bilgisayarin main path'ini verir.
        System.out.println(System.getProperty("user.home"));

        // Bir dosyaya dinamik olarak uslabilmek icin
        // Masaustune ulasmak istiyorsam
        String masaUstuDosyaYolu = System.getProperty("user.home") + "\\Desktop";
        System.out.println(masaUstuDosyaYolu);
    }
}