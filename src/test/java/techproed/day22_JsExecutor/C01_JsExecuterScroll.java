package techproed.day22_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecuterScroll extends TestBase {

            /*
        Actions class'ındaki gibi js executor ile de sayfada scroll işlemi yapabiliriz. Bir webelementi locate edip
        o webelement görünür olana kadar scroll yapabiliriz
        "arguments[0].scrollIntoView(true);",Webelement --> Bu script kodu ile belirtmiş olduğumuz webelemente scroll
        yaparız
         */
    @Test
    public void test01() {

        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer=  driver.findElement(By.xpath("(//*[@class='title'])[2]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", weOffer);
        bekle(2);
        tumSayfaResmiAl();
        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree= driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true)", enrollFree);
        bekle(2);
        tumSayfaResmiAl();


        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement WhyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true)", WhyUs);
        bekle(2);
        tumSayfaResmiAl();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true)", enrollFree);
        bekle(2);
        tumSayfaResmiAl();


        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(1);
        //Sayfayi en üste scroll yapalım

        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");



    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,1000)"); //  0 = X  1000 = Y
        bekle(2);
        js.executeScript("window.scrollTo(0,1000)");
        bekle(2);
        js.executeScript("window.scrollTo(0,2000)");
        bekle(2);
        js.executeScript("window.scrollTo(0,3000)");
        bekle(2);

    }

    @Test
    public void test03() {
        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer=  driver.findElement(By.xpath("(//*[@class='title'])[2]"));
       jsScrollWE(weOffer);
        bekle(2);
        tumSayfaResmiAl();
        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree= driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFree);
        bekle(2);
        tumSayfaResmiAl();


        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
      jsScrollWE(whyUs);
        bekle(2);
        tumSayfaResmiAl();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
      jsScrollWE(enrollFree);
        bekle(2);
        tumSayfaResmiAl();


        //Sayfayı en alta scroll yapalım
      jsScrollEnd();
        bekle(1);
        //Sayfayi en üste scroll yapalım

       jsScrollHome();



    }
}
