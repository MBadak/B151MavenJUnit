package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {

    // Bu class'a extends ettigiiz test claslarindan ulasabiliriz
    // Bu class'i abstract yaparak bu class'ta obje olusturulmasina engel olduk. Zorunlu degil ama güzel.

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void alertPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    public String  getAlertText() {
       return driver.switchTo().alert().getText();
    }

    public void ddmVisibletext(WebElement ddm,String secenek){
        Select select= new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    public void ddmByIndex(WebElement ddm,int index){
        Select select= new Select(ddm);
        select.selectByIndex(index);

    }
    public void ddmByValue(WebElement ddm,String secenek){
        Select select= new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchTo Window-1
    public void switchToWindow(int index){
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }
    //SwitchTo Window-2
    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    public void visibletWait(WebElement webElement,int saniye){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void visibletWait(String xPath,int saniye){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }



}
