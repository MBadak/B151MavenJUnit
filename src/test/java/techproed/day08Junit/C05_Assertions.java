package techproed.day08Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }


    @Test
    public void test01() {
        // test01
        // https://amazon.com sayfasına gidin
                // @before den gittik
        // sayfa baslıgının "Amazon" kelimesini icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void test02() {
        // test02
        // https://amazon.com sayfasına gidin
                // @before den gittik
        // Amazon resminin görüntülendiğini (isDisplayed()) test edin

       WebElement amazon_resmi= driver.findElement(By.id("nav-logo-sprites"));
       Assert.assertTrue(amazon_resmi.isDisplayed());
    }

    @Test
    public void test03() {
        // test03
        // https://amazon.com sayfasına gidin
                // @before den gittik
        // arama kutusunun erisilebilir oldugunu test edin
        WebElement arama_Kutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(arama_Kutusu.isEnabled());

    }

    @Test
    public void test04() {
        // test04
        // https://amazon.com sayfasına gidin
                // @before den gittik
        // sayfa baslıgının "kitap" icermedigini test edin
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains("kitap"));
    }
}
