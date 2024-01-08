package projectOpenCard.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class DriverThreadLocal {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // ThreadLocal değişkeni, her bir thread için ayrı bir WebDriver örneği tutmak için kullanılır.

    // WebDriver örneğini oluşturur ve ThreadLocal değişkenine atanır
    public static void setDriver() {

        driver.set(new ChromeDriver()); // Yeni bir ChromeDriver örneği oluşturur ve ThreadLocal değişkenine atar
    }

    // Mevcut thread'e ait WebDriver örneğini döndürür
    public static WebDriver getDriver() {



        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.get();

    }

    // Mevcut thread'e ait WebDriver örneğini kapatır ve ThreadLocal değişkeninden kaldırır
    public static void closeBrowser() {
        driver.get().close(); // WebDriver'ı kapatır
        driver.remove(); // ThreadLocal değişkeninden WebDriver örneğini kaldırır
    }
}
