package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void cookies() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2-tum cookie’leri listeleyin

                /*
                Cookie'leri listelemek  istersek
                driver.menage().getCookies()  methodu ile ArrayList e atabiliriz
                 */

       // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);  bu methodla yazdiririz
        List<Cookie> cookies=new ArrayList<>(driver.manage().getCookies()) ;

        int sayac=1;
        for (Cookie w: cookies   ) {
            System.out.println(sayac+". cookie : "+ w);
            System.out.println(sayac+". cookieName : "+ w.getName());
            System.out.println(sayac+". cookieValue : "+ w.getValue());
            sayac++;
        }


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookies.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
                //1. Yol
        String actualCookiesValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(actualCookiesValue,"USD");
                // 2. Yol
        for (Cookie w:cookies) {

            if (w.equals("i18n-prefs")) {
                Assert.assertTrue(w.getValue().equals("USD") );
            }
        }


        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
         Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> cookieSet=driver.manage().getCookies();
        for (Cookie w: cookieSet) {

            System.out.println(w);

        }
        int silmeOncesi= (int) Arrays.stream(driver.manage().getCookies().toArray()).count();
        System.out.println("SilmeOncesi "+silmeOncesi);

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        int silmeSonrasi= (int) Arrays.stream(driver.manage().getCookies().toArray()).count();
        System.out.println("SilmeSonrasi "+ silmeSonrasi);
        Assert.assertFalse(silmeSonrasi==silmeOncesi);


        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());

    }
}
