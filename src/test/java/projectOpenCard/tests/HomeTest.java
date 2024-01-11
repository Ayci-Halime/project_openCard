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
    @Test
    public void sepeteUrunEkle(){
        //1-Kullanici browser da URL e gider.
        //2-Kullanici giris butonuna tiklar.
        //3-Kullanici istedigi ürünü, arama alanina girer.
        //4-Kullanici aradigi üründeki sepete ekle butonuna ekler.
        //5-Kullanici sepete ekle butonuna tiklar.
        //6-Kullanici sepetteki ürünleri görür.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();

        driver.get(ConfigReader.getProperty("homepage_url"));

    }
}
