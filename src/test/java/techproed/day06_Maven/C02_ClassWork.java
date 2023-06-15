package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        // 2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        Thread.sleep(3000);
        // 3.Login alanine “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");
        Thread.sleep(5000);
        // 4.Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(5000);
        // 5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        // 6.Online Banking altindaki Pay Bills sayfasina gidin
        driver.navigate().back();
        // 7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();
        Thread.sleep(5000);
        // Amount kismina 0 giriniz.
        driver.findElement(By.id("sp_amount")).sendKeys("0");
        Thread.sleep(5000);
        // 8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        Thread.sleep(5000);
        // 9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(5000);
        // 10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        String actualMesaj=driver.findElement(By.id("alert_content")).getText();
        System.out.println(actualMesaj);
        String expectedMesaj="The payment was successfully submitted.";
        System.out.println(actualMesaj);
        System.out.println(expectedMesaj);


        if (actualMesaj.equals(expectedMesaj)) {

            System.out.println("The payment was successfully submitted. Mesaji cikiyor");
        }else System.out.println("The payment was successfully submitted. Mesayi cikmiyor");


    }
}
