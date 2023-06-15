package techproed.day07_Maven_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        // Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        // Login alanina  "username" yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");
        Thread.sleep(2000);
        // Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(2000);
        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back(); Thread.sleep(2000);
        // Online Banking bölümüne tıklamalın
        driver.findElement(By.id("online-banking")).click(); Thread.sleep(2000);
        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click(); Thread.sleep(2000);
        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("100"); Thread.sleep(2000);
        // Date kismina "2020-09-10" yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10"); Thread.sleep(2000);
        // Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        // "The payment was successfully submitted." mesajinin ciktigini test
        String actualMesaj=driver.findElement(By.id("alert_content")).getText();
        System.out.println(actualMesaj);
        String expectedMesaj="The payment was successfully submitted.";
        System.out.println(actualMesaj);
        System.out.println(expectedMesaj);


        if (actualMesaj.equals(expectedMesaj)) {

            System.out.println("The payment was successfully submitted. Mesaji cikiyor");
        }else System.out.println("The payment was successfully submitted. Mesayi cikmiyor");


        // Sayfayi kapatın
        driver.close();
    }
}
