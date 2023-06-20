package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //  https://jqueryui.com/droppable/ adresine gidiniz
        driver.get("https://jqueryui.com/droppable/");

        // (Drag me to my target) elementini  (Drop here) elementinin üzerine birakin
        driver.switchTo().frame(0);     // ifrema oldugu icin  gecis yaptik
        WebElement drap=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);


        actions.dragAndDrop(drap,drop).perform();


        /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */
    }
    @Test
    public void test02() {
        //  https://jqueryui.com/droppable/ adresine gidiniz
        driver.get("https://jqueryui.com/droppable/");

        // (Drag me to my target) elementini  (Drop here) elementinin üzerine birakin
        driver.switchTo().frame(0);     // ifrema oldugu icin  gecis yaptik
        WebElement drap=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);

        actions.clickAndHold(drap).perform(); // drap elementini tuttu
        bekle(1);
        actions.moveToElement(drop).perform(); // drap elementini drop elementine sürükledi. ama hala tutuyor
        bekle(1);
        actions.release().perform();  // drapelementini birakti.

             // actions.clickAndHold(drap).moveToElement(drop).release().perform(); yukaridaki islemleri tek satirda yazdik. buda mümkünmus

    }
    @Test
    public void test03() {
        //  https://jqueryui.com/droppable/ adresine gidiniz
        driver.get("https://jqueryui.com/droppable/");

        // (Drag me to my target) elementini  (Drop here) elementinin üzerine birakin
        driver.switchTo().frame(0);     // ifrema oldugu icin  gecis yaptik
        WebElement drap=driver.findElement(By.xpath("//*[@id='draggable']"));

        Actions actions=new Actions(driver);

        actions.clickAndHold(drap).perform(); // drap elementini tuttu
        bekle(1);
        actions.moveByOffset(120,28).release().perform();
    }
}
