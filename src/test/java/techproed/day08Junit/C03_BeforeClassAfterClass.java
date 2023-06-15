package techproed.day08Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    WebDriver driver;
    static int count =0;
    @BeforeClass
    public static void beforeClass() throws Exception {
        count++;
        System.out.println(count+" Amazon testi baslatildi");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        count++;
        System.out.println(count+" Amazon testi sonuclandi");
    }

    @Before
    public void setUp() throws Exception {
        count++;
        System.out.println(count+" Chrome ayarlari yapildi");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        count++;
        driver.close();
        System.out.println(count +" Acilan web sayafasi kapatildi");
    }

    @Test
    public void test01() {
        count++;
       // driver.get("https://amazon.com");  @before den calisacak
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Samsung"+ Keys.ENTER);
        System.out.println(count+" Amazon sayfasina gidildi arama cubuguna Samsung yazildi aratildi");
    }

    @Test
    public void test02() {
        count++;
        // driver.get("https://amazon.com");  @before den calisacak
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Iphone"+ Keys.ENTER);
        System.out.println(count+" Amazon sayfasina gidildi arama cubuguna Iphone yazildi aratildi");
    }
}