package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {
                /*
                WEBTABLE;
                    <table> tagı ile başlar
                        <thead> başlıklar için bu tag ile devam eder
                            <th> table head
                                <td> başlıktaki veriler
                            <tbody> başlıklar altındaki verileri temsil eder
                                    <tr> table row(satır)
                                        <td> table data (tablodaki veri)

                 */


    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 1 : Table1’i yazdırın
        WebElement table1= driver.findElement(By.xpath("//table[1]"));
        System.out.println("Tablo 1 = \n" + table1.getText());



        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement row3= driver.findElement(By.xpath("//table[1]//tr[3]"));
        System.out.println("Row 3 = \n" + row3.getText());

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement rowLast= driver.findElement(By.xpath("//table[1]//tr[4]"));
        System.out.println("Son Satir = \n" + rowLast.getText());


        //    Task 4 : 5. Sütun verilerini yazdırın
        for (int i = 1; i < 5; i++) {
            WebElement sutun= driver.findElement(By.xpath("//table[1]//tr[i]//td[5]"));
            System.out.println(i+". sutun = " + sutun.getText());
        }


        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.



    }
}
