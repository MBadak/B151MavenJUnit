package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test
    public void fileExist() {
        System.out.println(System.getProperty("user.dir"));  // C:\Users\M\Desktop\IT Dökümanlar\Selenium\B151MavenJUnit
        System.out.println(System.getProperty("user.home")); // C:\Users\M

        // Soru
        // Desktop(masaustu)'da bir text dosyası olusturun
                // masa üzerine gittik text.txt adinda bir metin dosyasi olusturduk

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
           // dosyanin yolu= C:\Users\M\Desktop\text.txt
        Assert.assertTrue(Files.exists(Paths.get("C:/Users/M/Desktop/text.txt")));
                // Daha dinamik hale getirelim
        String farkliKisim= System.getProperty("user.home");
        String ortakKisim="/Desktop/text.txt";
        Assert.assertTrue(Files.exists(Paths.get("C:/Users/M/Desktop/text.txt")));
        Assert.assertTrue(Files.exists(Paths.get(farkliKisim+ortakKisim)));

    }
}
