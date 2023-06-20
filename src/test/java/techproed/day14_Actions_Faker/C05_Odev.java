package techproed.day14_Actions_Faker;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Odev extends TestBase {
    @Test
    public void odev() {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //    2- Hover over  Me First" kutusunun ustune gelin
        WebElement first= driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(first).perform();

        //    3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        bekle(1);
        //    4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        bekle(1);
        //    5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(1);

        //    6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold= driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();
        bekle(2);

        //    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        actions.release().perform();


        //    8- “Double click me" butonunu cift tiklayin.
        WebElement ciftTikOncesiDoubleClickMe=  driver.findElement(By.xpath("//*[@class='div-double-click']"));
        bekle(3);
        actions.doubleClick(ciftTikOncesiDoubleClickMe).perform();
        // cift tiklandigini Tıklandığını test edin

        WebElement ciftTikSonrasiDoubleClickMe=  driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertTrue(ciftTikOncesiDoubleClickMe.getText().equals(ciftTikSonrasiDoubleClickMe.getText()));


// sayfa 144 ve 143 de ödev


    }

}
