package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void windowHandles() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("Sayfa1Handle = " + sayfa1Handle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement text = driver.findElement(By.xpath("//h3"));
        String actuelText = text.getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actuelText);
        bekle(3);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualSayfa1Title = driver.getTitle();
        String expectedSayfa1Title = "The Internet";
        Assert.assertEquals(expectedSayfa1Title, actualSayfa1Title);
        bekle(3);

        //  "Click Here" butonuna tıklayın.
        WebElement click_Here = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        click_Here.click();
                /* Bir buttona tiknaninca yeni bir sekme aciliyorsa;
                onun Handle degerini alamak icin tüm handle degerlerini alan
                getWindowHandles(). methodu kullanmali ve bir SET icersine koymaliyiz.
                Foreach kullanarak sonra bir String'e atayabiliriz. Böylece sayfalar arasi gecis yapabiliriz
                 */

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Sayfa2Handle = " + windowHandles.toString());

        String sayfa2Handle = "";

        for (String w : windowHandles) {
            if (!sayfa1Handle.equals(w))
                sayfa2Handle = w;
        }
        System.out.println("sayfa2Handle = " + sayfa2Handle);

        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(sayfa2Handle);
        String actualSayfa2Title = driver.getTitle();
        String expectedSayfa2Title = "New Window";
        Assert.assertEquals(expectedSayfa1Title, actualSayfa1Title);
        bekle(3);


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(sayfa1Handle);
        String actualSayfa1Title1 = driver.getTitle();
        String expectedSayfa1Title1 = "The Internet";
        Assert.assertEquals(expectedSayfa1Title1, actualSayfa1Title1);
        bekle(3);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);
        bekle(3);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);


    }
}
