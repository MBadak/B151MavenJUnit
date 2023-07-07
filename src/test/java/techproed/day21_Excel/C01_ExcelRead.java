package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead{

    @Test
    public void test01() throws IOException {
        // 3. satir 1. Sutun degerini yazdirin ve "France" oldugununtest ediniz
        // Excelde veri okuyabilmek icin

        // 1- Dosya yolunu alriz ve bir Stringe atariz
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        // 2- Bu alinan dosyayi bizim sistemimide okuyabilmek icin akisa sunmaliyiz.
        FileInputStream fis= new FileInputStream(dosyaYolu);

        //3- Dosyayi Wordbook'a atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz
        Workbook workbook= WorkbookFactory.create(fis);


        String satir3sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. satir 1. sutun = " + satir3sutun1);

        Assert.assertEquals(satir3sutun1,"France");


        // Son Satir Sayisini bulunuz
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("sonSatirSayisi = " + sonSatirSayisi);

        // ilk Satir Sayisini bulunuz
        int ilkSatirSayisi = workbook.getSheet("Sheet1").getFirstRowNum();
        System.out.println("ilkSatirSayisi = " + ilkSatirSayisi);

         // Kullanilan Satir Sayisini bulunuz
        int kullnlnSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("kullnlnSatirSayisi = " + kullnlnSatirSayisi);


    }

    Map<String ,String > capitaltsMap = new HashMap<>();
    @Test
    public void test02() throws IOException, InterruptedException {
        //Capitals dosyasindakitüm verileri yazdiriniz
      // Capital dosyasindaki tüm verileri koyabilecegimiz en uygun Java objesi Map'dir

        String  dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirNum= workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i < sonSatirNum+1; i++) {

           String key =  workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
           String value =  workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

           capitaltsMap.put(key,value);

            System.out.println(key+"  "+ value);



        }

        System.out.println(capitaltsMap);


    }

    }

