package p01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class $KuruYazdır {
    public static void main(String[] args) {
        /*Task:
        -haberturk sitesine gidin
        -dolar kurunu gösteren linke gidin
        -dolar kurunu alın
        -euro kurunu gösteren linke gidin
        -euro kurunu alın
        -euro - dolar farkını konsola yazdırın
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://haberturk.com");
        WebElement dolarKuru=driver.findElement(By.xpath("//a[@id='dolar']"));
        String currentdolar=dolarKuru.getText();
        System.out.println(currentdolar);
        //Burada dolar kurunu Etiketi ile String bir değer olarak 3 satırda alıyor

        WebElement euroKuru=driver.findElement(By.xpath("//a[@id='euro']"));
        String currenteuro=euroKuru.getText();
        System.out.println(currenteuro);
        //Burada euro kurunu etiketi ile String bir değer olarak 3 satırda alıyor

        //Bu yüzden String'i substring ile kurun değer kısmını alıyoruz
        //Ancak alınan sayısal değer aralığında virgül kullanılmış, onuda replace ile  nokta ya çeviriyoruz
        String dolar=currentdolar.substring(5,11).replace(",",".");
        String euro=currenteuro.substring(4,10).replace(",",".");

        //burada String bir alanda sakladığımız veriable yi Double class tan parseDouble metodu ile dauble a çeviriyoruz.
        double fark=Double.parseDouble(euro)-Double.parseDouble(dolar);


        System.out.println("Bugünkü dolar kuru : "+dolar);
        System.out.println("Bugünkü euro  kuru : "+euro);
        System.out.println("Bugünkü euro - dolar kur farkı : "+fark+" TL dir.");


    }
}
