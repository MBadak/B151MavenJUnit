package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.security.KeyFactorySpi;

public class C07_GenelTekrarTestiOdevi extends TestBase {
    @Test
    public void test01() {
        // Test01 :
        // 1- amazon gidin
        driver.get("https://amazon.com");
        // 2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement alleDrapdown= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select= new Select(alleDrapdown);
        int count=0;
        for (WebElement w: select.getOptions() ) {
            System.out.println(count+ 1+". "+w.getText());
            count++;
        }
        System.out.println(count);
        // 3. dropdown menude 28 eleman olduğunu doğrulayın
        Assert.assertTrue(count==28);

    }

    @Test
    public void test02() {
        // Test02
                // 1- amazon gidin
                driver.get("https://amazon.com");
                // 2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
                WebElement alleDrapdown= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
                Select select= new Select(alleDrapdown);


        // 1. dropdown menuden elektronik bölümü seçin
        select.selectByIndex(6);

        // 2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement ara= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        ara.sendKeys("iphone", Keys.ENTER);
        // 3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));

        // 4. ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("(//h2)[1]"));
        WebElement ucuncuUrun = driver.findElement(By.xpath("(//h2)[3]"));


        // 5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    }


        // Test03
        // 1. yeni bir sekme açarak amazon anasayfaya gidin
        // 2. dropdown’dan bebek bölümüne secin
        // 3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        // 4. sonuç yazsının puset içerdiğini test edin
        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        // Test 4
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
}
