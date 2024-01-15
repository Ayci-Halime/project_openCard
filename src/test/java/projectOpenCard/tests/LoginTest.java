package projectOpenCard.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectOpenCard.pages.LoginPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;
import projectOpenCard.utilities.ReusableMethods;

public class LoginTest {
@Test
    public void login1() {
    DriverThreadLocal.setDriver();
    WebDriver driver = DriverThreadLocal.getDriver();
    LoginPage loginPage = new LoginPage();
    ReusableMethods.login(driver);
    //Gercek email ve password ile Login olup olmadigini assert ettik
    Assert.assertTrue(loginPage.Myaccount.getText().contains("My Account"));
    }
    @Test
    public void login2() {
    DriverThreadLocal.setDriver();
    WebDriver driver = DriverThreadLocal.getDriver();
        driver.get(ConfigReader.getProperty("login_url"));
        driver.findElement(By.id("input-email")).sendKeys(ConfigReader.getProperty("login_email"));
        driver.findElement(By.id("input-password")).sendKeys(ConfigReader.getProperty("login_password"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

}
