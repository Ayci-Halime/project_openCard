package projectOpenCard.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectOpenCard.pages.HomePage;
import projectOpenCard.pages.SearchPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;

import java.util.ArrayList;
import java.util.List;

public class SearchTest {
    @Test
    public void TC_003_01() {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        HomePage homePage = new HomePage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        Assert.assertTrue(homePage.searchBox.isDisplayed());

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_003_02() {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        HomePage homePage = new HomePage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        Assert.assertTrue(homePage.searchIcon.isDisplayed());

        DriverThreadLocal.closeBrowser();

    }
    @Test
    public void TC_003_22() {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        HomePage homePage = new HomePage();
        SearchPage searchPage =new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        homePage.searchIcon.click();

        Assert.assertEquals(searchPage.search_page.getText(),"Search");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_003_20() {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        HomePage homePage = new HomePage();
        SearchPage searchPage =new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));

         Assert.assertEquals(homePage.searchBox.getAttribute("placeholder"),"Search");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_003_21() {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        HomePage homePage = new HomePage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        homePage.searchBox.sendKeys(ConfigReader.getProperty("product_name"));

        Assert.assertFalse(homePage.searchBox.getAttribute("value").contains("search"),"placeholder aramaya dahil edilmemeli");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_003_03()  {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        homePage.searchBox.sendKeys(ConfigReader.getProperty("product_name"));

        homePage.searchIcon.click();

        Assert.assertEquals(searchPage.product_hd.getText(), "HTC Touch HD");

        DriverThreadLocal.closeBrowser();

    }
    @Test
    public void TC_003_04() {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        homePage.searchBox.sendKeys(ConfigReader.getProperty("product_brand"));

        homePage.searchIcon.click();

        Assert.assertEquals(searchPage.product_samsung_syn.getText(), "Samsung SyncMaster 941BW");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_003_05(){

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        homePage.searchBox.sendKeys(ConfigReader.getProperty("product_model"));

        homePage.searchIcon.click();

        Assert.assertEquals(searchPage.puroduct_nicon_D300.getText(), "Nikon D300");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_003_06() {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        homePage.searchBox.sendKeys(ConfigReader.getProperty("kategorie"));

        homePage.searchIcon.click();

        Assert.assertEquals(searchPage.criteria_text.getText(), "There is no product that matches the search criteria.");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_003_07()  {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));

        homePage.searchBox.sendKeys(ConfigReader.getProperty("keyword"));

        homePage.searchIcon.click();

        Assert.assertEquals(searchPage.product_samsung_tab.getText(), "Samsung Galaxy Tab 10.1");

        DriverThreadLocal.closeBrowser();

    }
    @Test
    public void TC_003_08()  {

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        homePage.searchIcon.click();

        searchPage.search_keyword_input.sendKeys(ConfigReader.getProperty("product_name"));

        Select select=new Select( searchPage.category_select);
        select.selectByValue("24");
        searchPage.searchButton.click();

        Assert.assertTrue(searchPage.product_hd.isDisplayed());

        DriverThreadLocal.closeBrowser();

    }

}
