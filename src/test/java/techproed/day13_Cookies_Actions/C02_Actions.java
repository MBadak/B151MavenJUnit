package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
                    //Sağ klik yapabilmek için öncelikle Actions class'ından bir obje oluşturmalıyız
        Actions actions = new Actions(driver);
        actions.contextClick(kutu). //sağ klik yapma methodu kullandık
                        perform();  //actions objemizle yapacağımız işlemi uygulaması için veya sonlandırması için perform() kullanırız.
        bekle(2);

        // Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
                // 1: YOL KENDI METDUMUZLA
        Assert.assertEquals(getAlertText(),"You selected a context menu");
                // 2. yol yeniden yaziyi getText() ile alma
        String actualAlertText= driver.switchTo().alert().getText();
        String expectedAlertText="You selected a context menu";
        Assert.assertEquals(expectedAlertText,actualAlertText);


        // Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
                // veya
               // alertAccept();   bu bizim methodumuz



    }
}
