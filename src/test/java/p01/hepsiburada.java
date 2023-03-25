package p01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class hepsiburada {
    public static void main(String[] args) throws InterruptedException {
        /*Task:
        -hepsiburada sitesine gidin
        -arama kutusu linke tıklayın
        -iphone aratın
        -sayfayı kapatın
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://hepsiburada.com");
        Thread.sleep(2000);
        WebElement aramakutusu=driver.
                findElement(By.xpath("//input[@class='theme-IYtZzqYPto8PhOx3ku3c']"));
        aramakutusu.sendKeys("iphone"+ Keys.ENTER);
        driver.close();


    }
}
