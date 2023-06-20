package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileAbload extends TestBase {
    @Test
    public void test01() {
        // masaustunde bir text.txt dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
        bekle(2);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec= driver.findElement(By.xpath("//*[@id='file-upload']"));
        dosyaSec.sendKeys("C:\\Users\\M\\Desktop\\text.txt");
        bekle(2);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        bekle(1);

        // 'File Uploaded!' yazısının goruntulendigini test edin
       WebElement fileUploadedYazisi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }
}
