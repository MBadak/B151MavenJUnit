package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //techproeducation sayfasına gidiniz


        driver.get("https://techproeducation.com");


        //Baslıgın "Bootcamp" icerdigini test ediniz
        String actuelTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";

        Assert.assertTrue(actuelTitle.contains(expectedTitle));


    }

}
