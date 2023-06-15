package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void name() {

        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement kalinYazi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

        //==>  textBox içindeki yazıyı siliniz.
                // Önce Iframe icersine girmeliyiz.Bunun icin;
                     //1. yol
        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
                     //2. yol
                //  driver.switchTo().frame(0); index ile de iframe gecis yapilir. siteden baktik bir tane iframe vardi index=0 yazdik
                      //3. yol
                //  driver.switchTo().frame("mce_0_ifr");  id ile de iframe gecis yapilir.
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        bekle(1);
        textBox.clear();
        bekle(1);


        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(1);

        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
                // driver disa cikaarilir
        driver.switchTo().defaultContent();
        WebElement elementalYazisi = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalYazisi.isDisplayed());


    }
}