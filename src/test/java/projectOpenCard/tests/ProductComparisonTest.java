package projectOpenCard.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectOpenCard.pages.ProductComparisonPage;
import projectOpenCard.pages.ProductPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;
import projectOpenCard.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;

public class ProductComparisonTest {


    @Test
    public void testProductComparison_Button(){
        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage=new ProductPage();

        driver.get(ConfigReader.getProperty("automationlabs_homepage_url"));

        ReusableMethods.showAllDesktopMethod(driver);
        assertTrue(productPage.compareButton.get(0).isDisplayed());
        driver.quit();
    }
    @Test
    public void productComparisonAlert(){
        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage=new ProductPage();
        ProductComparisonPage comparisonPage=new ProductComparisonPage();

//        Kullanici URL'e gider
        driver.get(ConfigReader.getProperty("automationlabs_homepage_url"));
//        Kullanici schowallDesktop a tiklar.
       ReusableMethods.showAllDesktopMethod(driver);
//        Apple monitörün de karsilastir butonu tiklar.
        productPage.compareProductMethod(0);
//        sayfada ürün karsilastirma listesine eklendi uyarisini görüntüler.(product comparison!)
        System.out.println(comparisonPage.product_Comparison_Alert.getText());
        Assert.assertTrue(comparisonPage.product_Comparison_Alert.getText().contains("product comparison"));
    }

    @Test
    public void test1(){
        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage=new ProductPage();
        ProductComparisonPage comparisonPage=new ProductComparisonPage();
//        Kullanici URL'e gider
        driver.get(ConfigReader.getProperty("automationlabs_homepage_url"));
//        Kullanici schowallDesktop a tiklar.
        ReusableMethods.showAllDesktopMethod(driver);
//        Apple monitörün de karsilastir butonu tiklar.
        productPage.compareProductMethod(0);
//        sayfada ürün karsilastirma listesine eklendi uyarisini görüntüler.
        System.out.println(comparisonPage.product_Comparison_Alert.getText());
        Assert.assertTrue(comparisonPage.product_Comparison_Alert.getText().contains("product comparison"));
//                Karsilastirma listesine tiklar
        comparisonPage.ProductCompare.click();
//        Ürününü karsilastirma listesinde görüntüler
        Assert.assertTrue(comparisonPage.product_Comparison_assert.getText().contains("Product Comparison"));
    }

}
