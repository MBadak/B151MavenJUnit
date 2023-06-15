package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentocation extends TestBase {
        /*
        -Authentication kimlik dogrulama yöntemidir
        - söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder
        - Authentication üzerinde sag click yapıp locate alınamaz
        - Authentication bir alert degildir
        - Authentication yapabilmek icin uygulamanın kullanıcılara,
        Authentication'ı nasıl yapacagına dair bilgilendirme yapmıs olması gerekir
        - https://username:password@URL gibi
        */
    @Test
    public void test01() {
        // Aşağıdaki bilgileri kullanarak authentication yapınız:

        // Url: https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // Username: admin

        // Password: admin

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement praragraf=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(praragraf.getText().contains("Congratulations"));
    }
}
