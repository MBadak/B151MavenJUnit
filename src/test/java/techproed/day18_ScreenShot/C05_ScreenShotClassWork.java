package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {

        //https://techproeducation.com sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklami kapatin
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);


        //sayfanın resmini alalım
        tumSayfaResmiAl();
        bekle(2);
        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER);

        bekle(2);

        //ve sonuc yazısının resmini alalım
        WebElement javaSonucYazisi= driver.findElement(By.xpath("//h1"));
        webElementResmiAl(javaSonucYazisi);

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        bekle(2);
        //sayfanın resmini alalım
        tumSayfaResmiAl();

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        WebElement iphoneSonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmiAl(iphoneSonucYazisi);

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
       switchToWindow(0);
        tumSayfaResmiAl();
}
}
