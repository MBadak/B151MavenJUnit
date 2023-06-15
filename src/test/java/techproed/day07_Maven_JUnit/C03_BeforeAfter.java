package techproed.day07_Maven_JUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C03_BeforeAfter {

    @Test
    public void test01() {
        System.out.println("test01() : ilk test");
    }

    @Test
    public void test02() {
        System.out.println("test02() ;ikinci test");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before : her test methodu öncesi bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After :her test methodu sonrasi bir kez calisir");
    }
}
