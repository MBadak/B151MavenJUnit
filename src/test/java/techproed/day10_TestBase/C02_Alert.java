package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import utilities.TestBase;

public class C02_Alert extends TestBase {
    @Test
    public void acceptAlert() throws InterruptedException {

        //    Bir metod olusturun: acceptAlert

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    1. butona tıklayın,
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        Thread.sleep(3000);

        //    uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();  // switchTo()  gec,degistir alert() 'e ve accept()  kabul et
        Thread.sleep(3000);

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
        Thread.sleep(3000);
        //    uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();    // switchTo(). gecis yap
                                                // alert(). 'e gec
                                                // dismiss()  iptal et

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
        Thread.sleep(2000);

        //    uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);

        //    uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("mustafa");
        Thread.sleep(2000);

        //    OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult="mustafa";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}


