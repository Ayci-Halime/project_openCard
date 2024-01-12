package projectOpenCard.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;

public class LoginTest {
@Test
    public void login1() {
    DriverThreadLocal.setDriver();
    WebDriver driver = DriverThreadLocal.getDriver();
        driver.get(ConfigReader.getProperty("login_url"));
        driver.findElement(By.id("input-email")).sendKeys(ConfigReader.getProperty("login_email"));
        driver.findElement(By.id("input-password")).sendKeys(ConfigReader.getProperty("login_password"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
}
