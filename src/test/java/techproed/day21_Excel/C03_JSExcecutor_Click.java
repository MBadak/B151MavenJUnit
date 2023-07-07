package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExcecutor_Click extends TestBase {
            /*
            Eger bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak olusturulduysa,
            o sayfayla etkilesimde bulunmak icin standart WebDriver komutları yetersiz kalabilir.


            Bu durumda sayfayla etkilesime gecebilmek icin JavaScriptExecuter arayuzunu kullanmak gerekir.
            JavaScriptExecuter arayuzu sayfaya dogrudan erisebilir.

            Ancak, mümkünse WebDriver'ın sundugu standart yöntemlerle sayfayla etkilesime gecmek her zaman daha iyidir.
            Cünkü JS kullanımı sayfanın daha yavas yuklenmesine neden olabilir.

             */

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidiniz
        driver.get("https://www.amazon.com");

        // Warenrücksendungen  kismina tiklayiniz

        WebElement warenrücksendungen = driver.findElement(By.xpath("//*[@id='nav-orders']"));
       // warenrücksendungen.click();


        /*
        Ilgili webElementin HTML kodu , JavaScript kullanilarak olusturulduysa standart WebDriver komutu olan click()
        yetersiz kalabilir. Boyle durumlarda JavaScriptExecuter kullanilarak sayfa ile etkilesime gecilebilir
         */

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", warenrücksendungen);



    }

    @Test
    public void test02() {
        // https://www.amazon.com/ sayfasina gidiniz
        driver.get("https://www.amazon.com");

        // Warenrücksendungen  kismina tiklayiniz

        WebElement warenrücksendungen = driver.findElement(By.xpath("//*[@id='nav-orders']"));

        // TestBase' de methot olusturup tiklattik

        click(warenrücksendungen);
    }
}
