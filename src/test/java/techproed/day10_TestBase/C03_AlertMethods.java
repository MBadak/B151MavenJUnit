package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_AlertMethods extends TestBase {
    @Test
    public void acceptAlert() throws InterruptedException {

        //    Bir metod olusturun: acceptAlert

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    1. butona tıklayın,
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        bekle(3);  // Thread.sleep(2000);bunun yerine TestBase clasindan bekle methodunu aldik

        //    uyarıdaki OK butonuna tıklayın
        alertAccept();// driver.switchTo().alert().accept();
        bekle(3);  // Thread.sleep(2000);bunun yerine TestBase clasindan bekle methodunu aldik

        //    ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String actualResult=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        // Bir metod olusturun: dismissAlert

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    2. butona tıklayın,
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        bekle(3);  // Thread.sleep(2000);bunun yerine TestBase clasindan bekle methodunu aldik
        //    uyarıdaki Cancel butonuna tıklayın
        alertDismiss();  //driver.switchTo().alert().dismiss();   yerine


        //    ve result mesajının "successfuly" icermedigini test edin.
        String actualResult= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult="successfuly";
        Assert.assertFalse(actualResult.contains(expectedResult));

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    3. butona tıklayın,
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        bekle(2);  // Thread.sleep(2000);bunun yerine TestBase clasindan bekle methodunu aldik

        //    uyarıdaki mesajı konsolda yazdırın,
        System.out.println(getAlertText());  // System.out.println(driver.switchTo().alert().getText());
        bekle(2);  // Thread.sleep(2000);bunun yerine TestBase clasindan bekle methodunu aldik

        //    uyarıdaki metin kutusuna isminizi yazin,
       alertPrompt("mustafa");
        bekle(2);  // Thread.sleep(2000);bunun yerine TestBase clasindan bekle methodunu aldik

        //    OK butonuna tıklayın
       alertAccept();
        bekle(2);  // Thread.sleep(2000);bunun yerine TestBase clasindan bekle methodunu aldik

        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult="mustafa";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}