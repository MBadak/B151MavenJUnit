package techproed.day07_Maven_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JUnitIlkTest {
    // https://mvnrepository.com/artifact/junit/junit   bu siteden gerekli kodu pom.xml e yapistirdik
    // isme göre test claslari calisma sirasini ayarlar

    @Test  // sag tikla generate den test method e olusturabiliriz
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://techproeducation.com");
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test02()  {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://amazon.com");

        driver.close();

    }

}
