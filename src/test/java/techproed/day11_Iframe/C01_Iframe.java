package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void test01() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        WebElement anIframeYazisi = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(anIframeYazisi.getText().contains("black border"));

        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
                /*
                Applications lists' yazisina baktigimizda bir Iframe icersinde oldugunu gördük
                bu yaziyi test edebilmemiz icin önce Iframe 'yi locate edip switchTo() ile Iframe'ye gecmemiz gerekli.
                daha sonra iceride islemler yapilabiöir
                 */


        WebElement iframe = driver.findElement(By.xpath("//*[@src='/index.php']"));
        driver.switchTo().frame(iframe);


        WebElement applicationsListsYazisi = driver.findElement(By.xpath("//h1[text()='Applications lists']"));

        Assert.assertTrue(applicationsListsYazisi.isDisplayed());
        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
                /*
                driverimiz Iframe icersinde.
                bu soruyu cözebilmemiz icin driver'mizi defaultContent() ile en basa veya parentFrame() ile bir disa cikartmamiz lazim.
                 */
        driver.switchTo().defaultContent();
        WebElement powerByYazisi= driver.findElement(By.xpath("//p[text()='Povered By']"));
        Assert.assertTrue(powerByYazisi.getText().contains("Povered"));

    }
}
