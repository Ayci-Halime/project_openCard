package projectOpenCard.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectOpenCard.pages.HomePage;
import projectOpenCard.pages.ProductPage;
import projectOpenCard.pages.ShoppingCartPage;
import projectOpenCard.pages.RegisterPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;

public class HomeTest {
    @Test
    public void TC_001_01() {
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
    public void sepeteUrunEkle() {
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

    @Test
    public void sepeteUrunEkleme() throws InterruptedException {
        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        driver.get(ConfigReader.getProperty("homepage_url"));

        HomePage homepage = new HomePage();
        ProductPage productPage = new ProductPage();
        productPage.addToCartMethod(0);

        System.out.println(homepage.item.getText());
        Thread.sleep(4000);

        Assert.assertTrue(homepage.item.getText().contains("1 item(s)"));

        //  DriverThreadLocal.closeBrowser();
    }

    @Test
    public void sepeteUrunEkleyememe() {
        //1-Kullanici browser da URL e gider.
        //2-Kullanici menubardan tablet e gelir.
        //3-Kullanici istedigi ürünü, sepete ekle butonuna tiklar.
        //4-Kullanici viewcart a tiklar
        //5-Kullanici ürün stokta yok uyarisini görur.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        driver.get(ConfigReader.getProperty("homepage_url"));

        HomePage homePage = new HomePage();
        homePage.tablets.click();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.samsungTablet.click();//Educart

        homePage.shoppingCart.click();
        Assert.assertTrue(shoppingCartPage.warningAlert.getText().contains("*** are not available"));

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void sepetttt() throws InterruptedException {
        //1-Kullanici browser da URL e gider.
        //2-Kullanici menu bar dan Desktops gelir.
        //3-Kullanci ShowAllDesktops a tiklar.
        //4-Kullanici Iphone cepTelefonu ürününü, sepete ekle butonuna tiklar.
        //5-Kullanici sepete ekledigi ürünü görmek icin, shoppingCart butonuna tiklar.
        //6-Kullanici ürünün sepete eklendigini dogrular.
        //7-Kullanici ürünü silmek icin Remove butonuno tiklar.
        //8-Kullanici eklenen ürünün sepetten silindigini görür.


        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        driver.get(ConfigReader.getProperty("homepage_url"));

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();

        homePage.desktops.click();
        homePage.showAllDesktops.click();

        productPage.addToCartMethod(4);
        homePage.shoppingCart.click();

        Assert.assertTrue(!homePage.sepettekiUrun.getText().contains("empty"));//Locayt bosdegilse bunu dondurecek

        homePage.remove.click();
        Thread.sleep(3000);

        Assert.assertTrue(homePage.sepettekiUrun.getText().contains("empty"));//Empty gözüküyorsa ürün silinmistir

        DriverThreadLocal.closeBrowser();


    }


      //  DriverThreadLocal.closeBrowser();
    }

}
