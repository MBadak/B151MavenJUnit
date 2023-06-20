package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //reklami kapatacak
        bekle(2);
        //sayfanin altina dogru gidelim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);

        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //reklami kapatacak
        bekle(2);
        //sayfanin en altina scroll yapalim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(2);

        actions.sendKeys(Keys.HOME).perform();
                //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
                //objesini birbirine bağlar
                //release()  --> mausu serbest birakir


    }
    @Test
    public void test03() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //reklami kapatacak
        bekle(2);
        //sayfanin altina dogru gidelim
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,2500).perform();

        bekle(2);
               /*
                scrollByAmount(0,1500) kartezyen koordinat sistemi olan yatay ve düsey yönleri x ve y olarak adlandirdigimiz sistemde x=0 ile y=+1500 arasinda
                gidecektir. pozitif(+) yön kuzey secilmistir
               */

        //sayfanin ustune dogru gidelim
        actions.scrollByAmount(0,-2000).perform();

    }
}
