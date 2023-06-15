package techproed.day07_Maven_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odevler {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //https://www.google.com/  adresine gidin
        driver.get("https://www.google.com/");

        //cookies uyarisini  kabul ederek kapatin
        //Sayfa	basliginin	"Google"	ifadesi	icerdigini	test  edin
        //Arama cubuguna "Nutella" yazip aratin
        //Bulunan sonuc sayisini yazdirin
        //sonuc sayisinin 10 milyon'dan fazla oldugunu test  edin
        //Sayfayi kapatin


      //  2

        // "https://www.saucedemo.com" Adresine gidin
        // Username kutusuna "standard_user" yazdirin
        // Password kutusuna "secret_sauce" yazdirin
        // Login tusuna basin
        // Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        // Add to Cart butonuna basin
        // Alisveris sepetine tiklayin
        // Sectiginiz urunun basarili olarak sepete eklendigini control  edin
        // Sayfayi kapatin

    }
}







