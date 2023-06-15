
package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void test01() {

    //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techProHandleDegeri=driver.getWindowHandle();  // acilan sayfanin handle degerini aldik
        System.out.println("TechPro Handle : "+techProHandleDegeri); //0C3A7D26297C73C6DC993BFE9844ACCD

    //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actuelTitle=driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actuelTitle);

    //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        bekle(1);
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();
        System.out.println("Youtube Handle : "+ youtubeHandle);


    //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        bekle(2);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();
        System.out.println("Linkedin Handle : " + linkedinHandle);
        bekle(3);

    //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techProHandleDegeri);
        bekle(3);

    //  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeHandle);
        bekle(3
        );
    //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(3);



    }
}
