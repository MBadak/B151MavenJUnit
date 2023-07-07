package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        /*
        SCREENSHOT
               Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
           driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
           getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
           oranın yolunu belirtiriz.
         */
        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        // reklami kapatin
       driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // Ekran Görüntusu aliniz

                // 1- resimleri koyacagimiz dosyanin yolunu belirtmemiz lazim
        String dosyaYolu= "src/test/java/techproed/TumSayfaResmi/screenShot.png";  // dosya yolunu alip sonuna screenShot.png diye manuel isim veriyoruz
                // 2- TakesScreenshot arayüzünden obje olusturun
        TakesScreenshot ts= (TakesScreenshot) driver;
                // 3_ FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
        //dosya yolunu belirteceğiz

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));



    }

    @Test
    public void test02() throws IOException {
        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        // reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // Ekran Görüntusu aliniz

                // 1- resimleri koyacagimiz dosyanin yolunu belirtmemiz lazim
                        //Stringe atamadan altta kendimiz direk elimizle pathi yazdik

               // 2- TakesScreenshot arayüzünden obje olusturun
                TakesScreenshot ts= (TakesScreenshot) driver;
                // 3_ FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
                //dosya yolunu belirteceğiz

                FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("TechPro/ScreenShot/screenShot.png"));

    }

    @Test
    public void test03() throws IOException {

        /*
        Kadettigimiz ekran resmi her seferinde ayni olmamamsi icin dosya isminden sonra
        String bir degiskene tarih formati atayabiliriz.
         */

        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        // reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // Ekran Görüntusu aliniz

        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());

        String dosyaYolu= "src/test/java/techproed/TumSayfaResmi/screenShot"+tarih+".jpeg";  // dosya yolunu alip sonuna screenShot.png diye manuel isim veriyoruz
        // 2- TakesScreenshot arayüzünden obje olusturun
        TakesScreenshot ts= (TakesScreenshot) driver;
        // 3_ FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
        //dosya yolunu belirteceğiz

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
    @Test
    public void test04() throws IOException {
        //https://amazon.com sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

}
