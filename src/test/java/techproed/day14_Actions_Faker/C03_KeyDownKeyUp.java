package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        // Google anasayfasina gidiniz
        driver.get("https://google.com");
        bekle(1);
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();
        // Arama kutusunda Shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazmaya devam edelim

        bekle(1);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).sendKeys("Selenium").keyUp(Keys.SHIFT).sendKeys("JAva", Keys.ENTER).perform();

    }

    @Test
    public void test02() {
        // Google anasayfasina gidiniz
        driver.get("https://google.com");
        bekle(1);
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();
        // Arama kutusunda Shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazmaya devam edelim

        bekle(1);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, "Java", Keys.ENTER);

    }

    @Test
    public void test03() {
        // Google anasayfasina gidiniz
        driver.get("https://google.com");
        bekle(1);
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın

        bekle(1);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("selenium", Keys.ENTER);
        // Sayfayı bekleyin
        bekle(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.CONTROL, "a");
        bekle(2);
        aramaKutusu.sendKeys(Keys.CONTROL, "x");

        bekle(1);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.get("https://google.com");
        bekle(2);

        aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.CONTROL, "v", Keys.ENTER);

    }
}
