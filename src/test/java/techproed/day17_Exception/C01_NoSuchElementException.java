package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementException() {
        /*
         NoSuchElementException  --> sayfada ki elemente ulasmaya calisildiginda bazi nedenlerden
                - elemen yoksa
                - yanlis locate edilmisse
                - sayfa acilinca daha tüm elementler dolmadi ise
          dolayi ulasilamaz ise bu hata uyarisini aliriz
         */

        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        // reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //searchBox'a java yazip aratiniz
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='(bu kisimi bilrek yanlis locate alalaim)elementor-search-form-9f26725']"));
        searchBox.sendKeys("java", Keys.ENTER);

    }
}
