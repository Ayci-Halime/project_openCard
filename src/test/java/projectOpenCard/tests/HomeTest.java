package projectOpenCard.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectOpenCard.pages.HomePage;
import projectOpenCard.pages.RegisterPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;

public class HomeTest {
    @Test
    public void TC_001_01(){
        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        HomePage homePage = new HomePage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        homePage.desktops.click();

        homePage.showAllDesktops.click();

        Assert.assertTrue(homePage.dogrulamaMesaji.isDisplayed());

        DriverThreadLocal.closeBrowser();

    }
}
