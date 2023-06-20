package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sag ust bolumde bulunan "Konto und Listen" menüsüne git  "Account" secenegine tikla
        WebElement contoListenKIsmi= driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(contoListenKIsmi).perform();

        driver.findElement(By.xpath("//*[text()='Konto']")).click();
        //Acilan sayfanin Title in "Mein Konto" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().equals("Mein Konto"));

    }
}
