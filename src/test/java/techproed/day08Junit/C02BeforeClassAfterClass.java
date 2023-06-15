package techproed.day08Junit;

import org.junit.*;

public class C02BeforeClassAfterClass {
    /*
@BeforeClass class'da en once calısan methoddur.
@AfterClass class'da en son calısan methoddur.

@BeforeClass ve @AfterClass methodları sadece static methodlar ile calısır.
 */
    static int count =0;
    @BeforeClass
    public static void beforeClass() throws Exception {
       count++;
        System.out.println(count+" @BeforeClass : Classta en once calisan methoddur");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        count++;
        System.out.println(count+" @AfterClass: Classta en son calisan methoddur.Birkez calisir");
    }

    @Before
    public void setUp() throws Exception {
        count++;
        System.out.println(count+" @Before : her test() methodundan önce calisir");
    }

    @After
    public void tearDown() throws Exception {
        count++;
        System.out.println(count +" @After : her test() methodundan sonra calisir");
    }

    @Test
    public void test01() {
        count++;
        System.out.println(count+" ilk test methodu");
    }

    @Test
    public void test02() {
        count++;
        System.out.println(count+" ikinci test methodu");
    }
}
