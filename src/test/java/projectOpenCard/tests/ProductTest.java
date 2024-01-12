package projectOpenCard.tests;


import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectOpenCard.pages.ProductPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;
import projectOpenCard.utilities.ReusableMethods;


public class ProductTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_01() {
        //-Kullanıcılar, login oldukları zaman ürünler için derecelendirme ve yorumlar eklemek istediğinde,
        // kullanıcının adı review section'ın your name kısmında görülmelidir.
        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı adının your name alanında görüldüğünü doğrular
        Assert.assertTrue(productPage.nameFieldInReviews.getAttribute("value").contains("John"),"Name Field'text is not matching");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void TC_009_02() {
        //-Kullanıcılar, login oldukları zaman ürünler için derecelendirme ve yorumlar ekleyebilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your review alanına ürün değerlendirmesini girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_02"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesinin submit edildiğini doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_03() {
        // Kullanıcılar login oldukları zaman, your name alanını boş bırakırsa,
        // ürünler için derecelendirme ve yorumlar ekleyememelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Your name alanını boş bırakır
        productPage.nameFieldInReviews.clear();

        //Kullanıcı your review alanına ürün değerlendirmesini girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_03"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_04() {
        // Kullanıcılar login oldukları zaman, your review alanını boş bırakırsa,
        // ürünler için derecelendirme ve yorumlar ekleyememelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your review alanını boş bırakır
        productPage.textFieldInReviews.clear();

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_05() {
        // Kullanıcılar login oldukları zaman, your review alanına girdikleri metin 25 karakterten daha az ise,
        // ürünler için derecelendirme ve yorumlar ekleyememelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_05"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_06() {
        // Kullanıcılar login oldukları zaman, your review alanına girdikleri metin 25 karakter ve daha fazla ise,
        // ürünler için derecelendirme ve yorumlar ekleyebilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_06"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_07() {
        // Kullanıcılar login oldukları zaman, your review alanına girdikleri metin 1000 karakter ve daha az ise,
        // ürünler için derecelendirme ve yorumlar ekleyebilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_07"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_08() {
        //-Kullanıcılar login oldukları zaman, your review alanına girdikleri metin 1000 karakter daha fazla ise,
        // ürünler için derecelendirme ve yorumlar ekleyememelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_08"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();


        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_09() {
        // -Kullanıcılar login oldukları zaman, review alanındaki rating radio buttonunu seçmez ise,
        // ürünler için derecelendirme ve yorumlar yapamamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_09"));

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void TC_009_10() {
        // -Kullanıcılar login oldukları zaman, ürünün sayfasında add to cart butonunun altında write a review linkine
        // tıklayarak da ürünler için derecelendirme ve yorumlar yapabilmelidirler

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Ön koşullar login olma
        ReusableMethods.login(driver);
        /////////////

        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        // Ürünün add to cart butonunun altında write a review linkine tıklar
        productPage.writeReviewUnderAddToCartButton.click();

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_10"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(4);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();


        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void TC_009_11() {
        //Kullanıcılar, login olmadan ürünler için derecelendirme ve yorumlar eklemek istediğinde,
        //review section'ın your name kısmının boş olduğu görülmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Your name alanının boş olduğu görülür
        Assert.assertEquals(productPage.nameFieldInReviews.getText(), "", "Name field in reviews is not matching");

        DriverThreadLocal.closeBrowser();
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_12() {
        //-Kullanıcılar login olmadan, your review alanına girdikleri metin 25 karakterten
        // daha az ise, ürünler için derecelendirme ve yorumlar ekleyememelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_12"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_12"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");

        DriverThreadLocal.closeBrowser();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_13() {
        //Kullanıcılar login olmadan, your review alanına girdikleri metin 25 karakter ve
        // daha fazla ise, ürünler için derecelendirme ve yorumlar ekleyebilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_13"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_13"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_14() {
        //-Kullanıcılar login olmadan, your review alanına girdikleri metin 100 karakter ve daha az ise,
        // ürünler için derecelendirme ve yorumlar ekleyebilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_14"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_14"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(4);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_15() {
        //Kullanıcılar login olmadan, your review alanına girdikleri metin 100 karakter daha fazla ise,
        // ürünler için derecelendirme ve yorumlar ekleyememelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_15"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_15"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(3);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");


        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_16() {
        // Kullanıcılar login olmadan, review kısmındaki your name alanına 3 karakterden daha az kullanıcı adı girerlerse,
        // ürünler için derecelendirme ve yorumlar yapamamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_16"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_16"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(3);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");


        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_17() {
        //-Kullanıcılar login olmadan, review kısmındaki your name alanına 25 karakterden fazla kullanıcı adı girerlerse,
        // ürünler için derecelendirme ve yorumlar yapamamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_17"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_17"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message in review is not displayed");


        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_18() {
        // Kullanıcılar login olmadan, review kısmındaki your name alanına 3 karakter uzunluğunda kullanıcı adı girerlerse,
        // ürünler için derecelendirme ve yorumlar yapabilmelidirler.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_18"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_18"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(2);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");


        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_19() {
        // Kullanıcılar login olmadan, review alanındaki rating radio buttonunu seçmez ise,
        // ürünler için derecelendirme ve yorumlar yapamamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_19"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_19"));

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yapamadığını doğrular
        Assert.assertTrue(productPage.errorMessageInReview.isDisplayed(),"Error message about rating in review is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_20() {
        //-Kullanıcılar login olmadan, ürünün sayfasında add to cart butonunun altında write a review linkine
        // tıklayarak da ürünler için derecelendirme ve yorumlar yapabilmelidirler

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Add to cart butonunun altındaki write a review linkine tıklar
        productPage.writeReviewUnderAddToCartButton.click();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_20"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_20"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(3);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void TC_009_21() {
        // -Kullanıcılar, login olduktan sonra, ürün sayfalarında diğer kullanıcıların
        // derecelendirmelerini ve yorumlarını görebilmelidir.

        //  ******** !!! BURDA BUG VAR. TEST FAIL OLUYOR  ********


        // Önşart olarak önce sonra bir yorum yapalım
        TC_009_18();

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        // Önşart olarak sonra login olalım
        ReusableMethods.login(driver);
        ////////

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);


        //Kullanıcı yorumları görmek istediği ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Kullanıcı ürünün altındaki Reviews bölümün tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı, diğer kullanıcılar tarafından yapılan yorumları görür
        Assert.assertTrue(!productPage.viewAllReviewsMethod().getText().contains("0"), "Reviews from other users are not displayed");

        DriverThreadLocal.closeBrowser();

    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void TC_009_22() {
        // -Kullanıcılar, login olmadan, ürün sayfalarında diğer kullanıcıların derecelendirmelerini ve yorumlarını görebilmelidir.

        //  ******** !!! BURDA BUG VAR. TEST FAIL OLUYOR  ********

        // Önşart olarak önce yorum yapalım. Aşağıdaki metod ile yorum yapıyoruz önce
        TC_009_18();


        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);


        //Kullanıcı yorumları görmek istediği ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Kullanıcı ürünün altındaki Reviews bölümün tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı, diğer kullanıcılar tarafından yapılan yorumları görür
        Assert.assertTrue(!productPage.viewAllReviewsMethod().getText().contains("0"), "Reviews from other users are not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void TC_009_23() {
        // -Kullanıcılar login olmadan, review kısmındaki your name alanına 25 karakter uzunluğunda kullanıcı adı girerlerse,
        // ürünler için derecelendirme ve yorumlar yapabilmelidirler.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage = new ProductPage();

        driver.get(ConfigReader.getProperty("homepage_url"));
        ReusableMethods.showAllDesktopMethod(driver);

        //Kullanıcı ürünü seçer
        ReusableMethods.selectProductMethod(0);

        //Ürünün description section'ının yanındaki Reviews bölümüne tıklar
        productPage.clickOnReviewSectionMethod();

        //Kullanıcı your name alanını girer
        productPage.nameFieldInReviews.sendKeys(ConfigReader.getProperty("name_field_TC_009_23"));

        //Kullanıcı değerlendirme metnini your review alanına girer
        productPage.textFieldInReviews.sendKeys(ConfigReader.getProperty("text_field_TC_009_23"));

        //Kullanıcı, değerlendirmesine göre rating bölümündeki radio button'larından birini seçer
        productPage.clickOnRatingRadioButtonMethod(4);

        //Kullanıcı continue butonuna tıklar
        productPage.continueButtonInReview.click();

        //Kullanıcı ürün değerlendirmesi yaptığını doğrular
        Assert.assertTrue(productPage.reviewConfirmationText.getText().contains("submitted"),"Review confirmation is not done");


        DriverThreadLocal.closeBrowser();

    }







}
