package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

        /*  WAIT icin GENEL NOTLAR

        implicitlyWait() sayfadaki tüm elementlerin max bekleme süresidir. bizim isimizi %80 halleder

        bu method ile cogu yerde isimizi halleder.
        islem daha önce biterse sürenin bitmesi beklenmez, genelde TestBase class inda kullanilir.

        explicitlywait() %20 oraninda kullaniriz. Sadece belirli bir webelement icin kullanilir.Belirli bir
        kosul gerceklesene kadar max süre boyunca bekletir. Max süreyi biz belirleriz.
        Default olarak kontrol etme süresi 500 ms'dir ~ yaklasik 0,5 saniye. Bu sürede sürekli kontrol eder.
        webdriverwait defult olarak 500 ms atanir ve degistirilemez
        fluentwait istedigimiz ms atayabiliriz.
        beklenen bir durum, bir sart olmali. Örnegin webelement görünür oluncaya kadar bekle.
        explicitlywait()'de bir kosul belirtiriz. Belirli webelementler icin kullanilir.
        ÖRNEK: WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); objesini kullaniriz.

        Webelementi locate etmek icin wait object kullanma:(explicitlywait() icin)
         WebElement element = wait.until(ExpectedCondition.visibilityOfElemetLocated(By.xpath("")));
        explicitlywait()'de sartlar methodlarla belirtilir. Methodlarin 17sini gördük.

        implicitlyWait() ile halledebiliyorsak explicitlywait() kullanmayiz.

        Bir webelement max bekleme sürelerinde yüklenemezse NoSuchElementException aliriz

        */


    @Test
    public void explicitWait() {

        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        //  ==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();



        //==> Hello World! yazısının görünürlügünü test edin
        WebElement helloYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));

         wait.until(ExpectedConditions.visibilityOf(helloYazisi));
        // explicitWait(helloYazisi,15);                    kendim method olusturdum
        // explicitWait("//h4[text()='Hello World!']",15);  kendim method olusturdum

        Assert.assertTrue(helloYazisi.isDisplayed());


    }
}
