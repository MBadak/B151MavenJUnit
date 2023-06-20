package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDowload extends TestBase {
    @Test
    public void test01() {

        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);



        //"b10 all test cases" dosyasını indirin
        String filePath="C:\\Users\\M\\Downloads\\b10 all test cases, code.docx";
        File silencekDosya = new File(filePath);  // dosya objesi ile silinecek dosyayi olustururuz
        silencekDosya.delete();                   // testi run edince her calisdiginda yeni bir doya olusturmasini önledik.
                                                  // yani önce varsa sildik sonra tekrardan indirdik.
                                                  // her halukarda bir  dosya kalir


        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();
        bekle(2);
        // Dosyanın başarıyla indirilip indirilmediğini test edin.


        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        // daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
