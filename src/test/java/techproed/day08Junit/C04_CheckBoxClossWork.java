package techproed.day08Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClossWork {


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/checkboxes sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement Checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement Checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        // Checkbox1 seçili değilse secin
        if (!Checkbox1.isSelected()) {
            Checkbox1.click();
        }

        // Checkbox2 seçili değilse secin
        if (!Checkbox2.isSelected()) {
            Checkbox2.click();
        }
    }

    @Test @Ignore("aciklama alani. neden ignore ettiginizide yazabilirsiniz bu alana")  //  @Ignore     testi calistirmaz
    public void ignor() {
        driver.get("https://amazon.com");
    }
}

