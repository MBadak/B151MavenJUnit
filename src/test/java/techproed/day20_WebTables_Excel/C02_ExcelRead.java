package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {

    @Test
    public void test01() throws IOException {

        // Excelde veri okuyabilmek icin

        // 1- Dosya yolunu alriz ve bir Stringe atariz
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        // 2- Bu alinan dosyayi bizim sistemimize getirmemiz lazim
        FileInputStream fis= new FileInputStream(dosyaYolu);

        //3- Dosyayi Wordbook'a atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz
        Workbook workbook= WorkbookFactory.create(fis);

        //4- Sayfayi (Sheet)  sececegiz
        Sheet sheet = workbook.getSheet("Sheet1");

        //5_ Satiri(row) secmeliyiz
        Row row= sheet.getRow(0);        // 1. satirin index'i 0 'dan baslar

        // 6_ Hücreyi(cell) secmeliyiz
        Cell cell = row.createCell(0);   //index yine 0'dan  baslar


    }

    @Test
    public void test02() throws IOException {
        // kisa yöntem

        // 1. satir 1. sutundaki bilgizi yazdiriniz

        // 1- Dosya yolunu alriz ve bir Sirunge atariz
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        // 2- Bu alinan dosyayi bizim sistemimize getirmemiz lazim
        FileInputStream fis= new FileInputStream(dosyaYolu);

        //3- Dosyayi Wordbook'a atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz
        Workbook workbook= WorkbookFactory.create(fis);

        String  satir1Sutun1= workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println("satir1Sutun1 = " + satir1Sutun1);





    }

    @Test
    public void test03() {

        // Methot olusturun ve 5 satir 2. sutundaki veriyi yazdirin

        excelRead("Sheet1",5,2);
        excelRead("Sheet1",3,1);




    }
    public void excelRead(String sayfa ,int satir , int sutun){
        // 1- Dosya yolunu alriz ve bir Sirunge atariz
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        // 2- Bu alinan dosyayi bizim sistemimize getirmemiz lazim
        FileInputStream fis= null;
        try {
            fis = new FileInputStream(dosyaYolu);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //3- Dosyayi Wordbook'a atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz
        Workbook workbook= null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String  satir1Sutun1= workbook.getSheet(sayfa).getRow(satir-1).getCell(sutun-1).toString();
        System.out.println(satir+".Satir "+sutun+  ".Sutundaki veri = " + satir1Sutun1);
    }
}
