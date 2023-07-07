package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
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

    // Tüm sayfanin resmini ScreenShot olarak alma methodu
    public void tumSayfaResmiAl(){
        String tarih = new SimpleDateFormat("-(dd.MM.yyyy  hh.mm.ss)").format(new Date());
        String dosyaYolu = "TechPro/ScreenShotTumSayfaResimleri/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public void webElementResmiAl(WebElement element){


    // WebElemnt  resmini ScreenShot olarak alma methodu

    String tarih = new SimpleDateFormat("-(dd.MM.yyyy  hh.mm.ss)").format(new Date());
    String dosyaYolu = "TechPro/ScreenShotWebElementResimleri/WEscreenShot" + tarih + ".jpeg";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //UploadFile Robot Class
    public void uploadFilePath(String filePath) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }



    // Extent Raport Methodu  (raporlama icin)


    protected ExtentReports extentReports;            // Raporlamayi baslatmak icin kullanilan class
    protected ExtentHtmlReporter extentHtmlReporter;  // Raporu Htmle formatinda düzenler
    protected ExtentTest extentTest;                  // test adimlarina eklemek istedigimiz bilgileri bu clas ile olustururuz

    public void extentReport(String reportName){
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("-(dd.MM.yyyy  hh.mm.ss)").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter); // HTML formatinda raporlamaya baslayacak

        //Raporda gözükmesini isteğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Mustafa");
        extentReports.setSystemInfo("Sirket","TechProEducation");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName(reportName);



    }

    public void click(WebElement webElement){

        try {
            webElement.click();
        } catch (Exception e) {

            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", webElement);
        }

    }
    // JS Scroll WE
    public void jsScrollWE (WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

    }
    // JS Scroll END Method (sayfa sonuna gitme )
    public void jsScrollEnd (){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    // JS Scroll HOME Method  (sayfa basina gitme )
    public void jsScrollHome (){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    //JS SendKeys() Method
    public void jsSendKeys(String text,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"'",element);
    }

    //JS setAttribute() Method  //  Bir Attribute yeni dgerler atayabiliriz  mesela id= mustafa yapabiliriz. böylece daha kolay locate ederiz
    public void jsSetAttribute(String attribute,String text,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('"+attribute+"','"+text+"')",element);
    }



   }  // TestBase class
