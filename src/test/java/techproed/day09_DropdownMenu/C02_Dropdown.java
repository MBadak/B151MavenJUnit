package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    /*
DROPDOWN --->Alt basliklarin oldugu acilir menu listesidir.
dropdown u handle(automate) etmek icin
    1-dropdown menuyu ilk olarak locate ederiz
    2-Select objesi olusturuuz
    3-select objesinin ddm webelementlerinin iceriginine ve seceneklerine erisim saglamak icin
    SELECT sinifina arguman olarak locate ettigimizwebelementleri koyariz
    SYNTAX:
    Select select0 nev Select(ddm webelement)
    4-Select classi sadece <select > tag i ile olusturulmus dropdown menulere uygulanabilir
    5-Select objesi ddm yi handle edebilmek icin 3 method kullanilir
        a-selectByVisibleText()->-> Ddm'deki elemente gorunur metin ile ulasmak icin kullanilir
        b-selectbyIndex()->Index ile ulasmak icin kullanilir(Index 0(sifir))'dan baslar
        c-selectByValue()-> Elementin degeri ile ulasmak icin kullanilir(option tag'larindaki deger(value) ile)
    6-getOptions() -> locate ettigimiz tum secenekleri bize verir.(List e atip loop ile yazdirabiliriz)
    7-getFirstselectedOption()->Ddm deki secili kalan secenegi bize verir.Birden fazla secenek secildiyse bu secilenlerin ilkini verir
 */


    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
      driver.close();
    }


/*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
    @Test
    public void test01() {
        // 1.Method:
        //        a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil= driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay= driver.findElement(By.xpath("//*[@id='month']"));
        WebElement gun= driver.findElement(By.xpath("//*[@id='day']"));

        //        b. Select objesi olustur
        Select select_Yil= new Select(yil);

        //    c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select_Yil.selectByIndex(42); // 5, indexdeki 2018 i secer
        Select select_ay=new Select(ay);
        select_ay.selectByValue("3"); //july
        Select select_gun=new Select(gun);
        select_gun.selectByVisibleText("15");


    }

    @Test
    public void test02() {
        //a. Tüm eyalet isimlerini yazdıralım (Select ile)
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        select.getOptions().forEach(w-> System.out.println(w.getText()));
        //getOptions() methodu ile tüm seçenekleri yazdırdık
        //2. yol
        System.out.println("****************************************************************");
        List<WebElement> eyaletlerr = driver.findElements(By.xpath("(//select)[5]"));
        eyaletlerr.forEach(w-> System.out.println(w.getText()));
    }

    @Test
    public void test03() {
        //3.Method:
        //        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);

        String secili_Olan_Secenek=select.getFirstSelectedOption().getText();
        System.out.println(secili_Olan_Secenek);
        Assert.assertEquals("Select a State",secili_Olan_Secenek);




    }
}
