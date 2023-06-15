package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class C01_Maven_IlkTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //   https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //amazonu ingilizce yapmak
        driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@class='a-icon a-icon-radio'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
        Thread.sleep(1000);
        // arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        // “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        // Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());
        String [] sonucSayisi=sonucYazisi.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[2]);
        // Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        // Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari=driver.findElements(By.xpath("//h1|//h2|//h3//h4|//h5|//h6"));
        for (WebElement w:sayfaBasliklari ) {
            System.out.println(w.getText());
        }





    }
}
