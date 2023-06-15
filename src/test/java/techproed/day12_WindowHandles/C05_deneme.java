package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C05_deneme extends TestBase {
    @Test
    public void windowHandles() {
        /*
        bu clasi 2 veya daha fazla sekme tiklanarak acilinca gecebilmek icin acilmis bir class
         */

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("Sayfa1Handle = " + sayfa1Handle);


        //  "Click Here" butonuna tıklayın.
        WebElement click_Here = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        click_Here.click();
                /* Bir buttona tiknaninca yeni bir sekme aciliyorsa;
                onun Handle degerini alamak icin tüm handle degerlerini alan
                getWindowHandles(). methodu kullanmali ve bir SET icersine koymaliyiz.
                Foreach kullanarak sonra bir String'e atayabiliriz. Böylece sayfalar arasi gecis yapabiliriz
                 */

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles = " + windowHandles.toString());

        String sayfa2Handle = "";

        for (String w : windowHandles) {
            if (!sayfa1Handle.equals(w))
                sayfa2Handle = w;
        }
        System.out.println("sayfa2Handle = " + sayfa2Handle);

        bekle(3);

        //  ikinci sayfa gidin.
        driver.switchTo().window(sayfa2Handle);
               bekle(3);


        //  ilk sayfaya dönün . "Click Here" butonuna tıklayın.
        driver.switchTo().window(sayfa1Handle);
        click_Here.click();
        Set<String > windowHandles2=driver.getWindowHandles();
        System.out.println("windowHandles2 = " + windowHandles2.toString());
        String sayfa3Handle="";
        for (String w:windowHandles2      ) {
            if ( !w.equals(sayfa1Handle )) {
                if ( !w.equals(sayfa2Handle )) {
                    sayfa3Handle=w;
                }

            }

        }
        System.out.println("sayfa3Handle = " + sayfa3Handle);



        bekle(3);

        // ücüncü sayfaya gidin


        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);
        bekle(3);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);


    }
}