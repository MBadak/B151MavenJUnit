package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

                /*
            EXTENTREPORT;
               1- ExtentReport(aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı
                  dependency'i pom.xml dosyamıza ekleriz.
               2- ExtentReports class'ından class seviyeninde obje oluştururuz
               3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
               4- ExtentTest class'ından class seviyeninde obje oluştururuz
             */

    ExtentReports extentReports;            // Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;  // Raporu Htmle formatinda düzenler
    ExtentTest extentTest;                  // test adimlarina eklemek istedigimiz bilgileri bu clas ile olustururuz

    @Test
    public void test01() {

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("-(dd.MM.yyyy  hh.mm.ss)").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter); // HTML formatinda raporlamaya baslayacak

        //Raporda gözükmesini isteğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Mustafa");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");


        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");


        // "https://amazon.com sayfasina gidiniz

        driver.get("https://amazon.com");
        extentTest.info("Amazon Sayfasina Gidildi");

        // Basligin Amazon icerdigini test edelim

        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));

        extentTest.info("Basligin Amazon icerdigi test ettik");

        //Iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        extentTest.info("Arama kutusunda Iphone aratildi");

        //cikan sonucu konsola yazdiralik alalim
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("sonucYazisi = " + sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi konsola yazdırıldı");
        extentTest.pass("Sayfa kapatıldı");

        /*
            extentTest objesi ile info() methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
        testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
        ekleyebiliriz.
            Ve son olarak actions daki perform methodu gibi extentReport objesi ile flush() methodu kullanarak
        raporu sonlandırırız
         */

        extentReports.flush();  // bunu kullanmaz isek rapor olusmaz





    }
}
