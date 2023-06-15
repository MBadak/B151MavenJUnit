package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class murathan {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://poki.com/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[mode='primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@class='sc-1s4z03m-0 evwDGU'])[2]")).click();
        WebElement subway= driver.findElement(By.id("game-container"));
        Thread.sleep(20000);
        subway.click();
        subway.click();
        Actions actions = new Actions(driver);
        actions.click(subway);
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_UP).perform();  Thread.sleep(500);


        actions.sendKeys(Keys.ARROW_UP).perform();    // Yukarı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500); // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500); // Aşağı yön tuşuactions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500); // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500); // Aşağı yön tuşuactions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500); // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500); // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_DOWN).perform();  // Aşağı yön tuşu
        actions.sendKeys(Keys.ARROW_LEFT).perform(); Thread.sleep(500);   // Sol yön tuşu
        actions.sendKeys(Keys.ARROW_LEFT).perform(); Thread.sleep(500);   // Sol yön tuşu
        actions.sendKeys(Keys.ARROW_LEFT).perform(); Thread.sleep(500);   // Sol yön tuşu
        actions.sendKeys(Keys.ARROW_LEFT).perform(); Thread.sleep(500);   // Sol yön tuşu
        actions.sendKeys(Keys.ARROW_RIGHT).perform(); // Sağ yön tuşu
    }
}
