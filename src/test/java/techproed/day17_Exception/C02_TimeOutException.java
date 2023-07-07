package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void timeOutException() {
        /*
        TimeOutException --> Web sayfasinda aranan ürün istenilen Max süre icersinde bulunaz ise bu hatayi aliriz
         */

        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        // reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //searchBox görünür oluncaya kadar bekelyin


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement searchBox =     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='YANLISelementor-search-form-9f26725']")));


       /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */


    }
}
