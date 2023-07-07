package techproed.day22_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_SetAttribute extends TestBase {

    /*
    <input> tag'ina sahip webelementlere deger gonderirken sendKeys() methodu kullaniriz
    sendKeys() methodu ile deger gonderemedigimiz durumlarda js executor ile rahatlikla deger gonderebiliriz
    <input> taglarinda value attributu degeri arama kutusu icindeki veriyi temsil eder
     */
    @Test
    public void test01() {
        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'", aramaKutusu); //-->value attribute deger olarak QA yazdir



    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        jsSendKeys("QA", aramaKutusu);




    }

    @Test
    public void test03() {

        /*
        JS executer ile bir attribute değer atayabiliriz. aşağıdaki örnekteki gibi
        sayfadaki arama kutusunu locate edip arama kutusunun value attribute une 'QA' değerini atarız
         */

        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);



    }

    @Test
    public void test04() {
        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','mustafa')",aramaKutusu);
        driver.findElement(By.id("mustafa")).sendKeys("Java", Keys.ENTER);




    }
    @Test
    public void test05() {
        //Techpro education ana sayfasına git reklami kapat
        driver.get("Https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));

        jsSetAttribute("value", "QA",aramaKutusu);  //Method ile value attribute degrine set ettik, QA olarak degisti


    }
}
