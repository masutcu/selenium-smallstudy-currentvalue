package p01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Youtube {
    public static void main(String[] args) throws InterruptedException {
        /*Task:
        -youtube sitesine gidin
        -arama kutusu linke tıklayın
        -'güldür güldür son bölüm' aratın
        -işlem aralarına 2 saniye bekleme ekleyin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://youtube.com");
        Thread.sleep(2000);
        WebElement searchbox=driver.
                findElement(By.xpath("//input[@class='ytd-searchbox']"));
        Thread.sleep(2000);
         searchbox.sendKeys("güldür güldür son bölüm", Keys.ENTER);



    }
}
