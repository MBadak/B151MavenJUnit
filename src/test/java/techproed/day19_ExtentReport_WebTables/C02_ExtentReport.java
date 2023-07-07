package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {



    @Test
    public void test01() {

        extentReport( "Amazon Testi");

        extentTest = extentReports.createTest("Extend Report", "Test Raporu");



        // "https://amazon.com sayfasina gidiniz

        driver.get("https://amazon.com");
        extentTest.info("Amazon Sayfasina Gidildi");

        // Sayfanin Resmini aliniz
        tumSayfaResmiAl();
        extentTest.info("Sayfanin resmi alindi");

        // Arama kutusunda iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        extentTest.info("Arama kutusunda Iphone aratildi");
        extentTest.pass("Test Kapatildi");
        extentReports.flush();


    }
}
