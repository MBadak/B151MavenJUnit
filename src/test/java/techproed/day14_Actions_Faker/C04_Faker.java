package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C04_Faker extends TestBase {
    @Test
    public void faker() {

         /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */
        Faker faker=new Faker();

        //Faker objesini kullanarak bir isim yazdiriniz
        System.out.println(faker.name().firstName());
        //Faker objesini kullanarak bir soy isim yazdiriniz
        System.out.println(faker.name().lastName());
        //Faker objesini kullanarak bir full isim yazdiriniz
        System.out.println(faker.name().fullName());
        //Faker objesini kullanarak bir sehir yazdiriniz
        System.out.println(faker.address().cityName());

        //Faker objesini kullanarak bir adres yazdiriniz
        System.out.println(faker.address().fullAddress());

        //Faker objesini kullanarak bir tel yazdiriniz
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());


        //Faker objesini kullanarak bir e mail yazdiriniz
        System.out.println(faker.internet().emailAddress());


        //Faker objesini kullanarak bir rasgele bir sayi yazdiriniz
        System.out.println(faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println(faker.job().position());


    }
}
