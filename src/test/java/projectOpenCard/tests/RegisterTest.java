package projectOpenCard.tests;



import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import projectOpenCard.pages.RegisterPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;


public class RegisterTest {

    @Test
    public void TC_004_01 () {
        // TC_004_01 Kullanıcı, kayıt formunu doldurarak yeni bir hesap oluşturabilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));



//        Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

//        Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

//        Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(ConfigReader.getProperty("email_first_register"));

//        Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

//        Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

//        Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

//        Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

//        Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

//        Kullanıcı hesap oluşturulduğunu verify eder
        Assert.assertTrue(registerPage.verificationOfCreation.getText().contains("Created!"),"Account creation could not be verified");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_02() {
        // TC_004_02 Kullanıcı, kayıt formunda first name alanını boş bıraktığında, kayıt olmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));


//        Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

//        Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

//        Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

//        Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

//        Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

//        Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

//        Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

//        Kullanıcı hesap oluşturulmadığını verify eder
        Assert.assertTrue(registerPage.firstnameErrorMessage.isDisplayed(),"Error Message for first name is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_03() {

        // TC_004_03 Kullanıcı, kayıt formunda last name alanını boş bıraktığında, kayıt olmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.lastnameErrorMessage.isDisplayed(),"Error Message for last name is not displayed");

        DriverThreadLocal.closeBrowser();

    }


    @Test
    public void TC_004_04() {

        // TC_004_04 Kullanıcı, kayıt formunda email alanını boş bıraktığında, kayıt olmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.emailErrorMessage.isDisplayed(),"Error Message for email is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_05() {

        // TC_004_05 Kullanıcı, kayıt formunda password alanını boş bıraktığında, kayıt olmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.passwordErrorMessage.isDisplayed(),"Error Message for password is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_06() {

        // TC_004_06 Kullanıcı, kayıt formunda telefon alanını boş bıraktığında, kayıt olmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.telephoneErrorMessage.isDisplayed(),"Error Message for telephone is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_07() {
        // TC_004_07 Kullanıcı, kayıt formunda password alanına 4 karakterden az veri girdiğinde, kayıt olmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password_TC_004_07"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_TC_004_07"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.passwordErrorMessage.isDisplayed(),"Error Message for password is not displayed");

        DriverThreadLocal.closeBrowser();
    }


    @Test
    public void TC_004_08() {
        // TC_004_08 Kullanıcı, kayıt formunda password alanına en az 4 karakter veri girdiğinde, kayıt olmalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password_TC_004_08"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_TC_004_08"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturduğunu verify eder
        Assert.assertTrue(registerPage.verificationOfCreation.getText().contains("Created!"),"Account creation could not be verified");

        DriverThreadLocal.closeBrowser();
    }


    @Test
    public void TC_004_09() {
        // TC_004_09 Kullanıcı, kayıt formunda password alanına en fazla 20 karakter veri girdiğinde, kayıt olmalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password_TC_004_09"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_TC_004_09"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturduğunu verify eder
        Assert.assertTrue(registerPage.verificationOfCreation.getText().contains("Created!"),"Account creation could not be verified");

        DriverThreadLocal.closeBrowser();
    }

    @Test
    public void TC_004_10() {
        // TC_004_10 Kullanıcı, kayıt formunda password alanına 20 karakterden fazla veri girdiğinde, kayıt olmamalıdır.
        //  !!! bu case 'de bug var. max 20 karakter şifre kabul etmesi gerekirken, 20 karakterden fazla şifreyi de kabul ediyor

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password_TC_004_10"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_TC_004_10"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.passwordErrorMessage.isDisplayed(),"Error message for password is not displayed");


        DriverThreadLocal.closeBrowser();
    }

    @Test
    public void TC_004_11() {
        // TC_004_11 Kullanıcı, kayıt formunda privacy policy checkbox'ını işaretlemediği sürece, kayıt olmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.privaciyPolicyErrorMessage.isDisplayed(),"Error message for privacy policy chechbox is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_12() {
        // TC_004_12 Kullanıcı, kayıt formunu doldurduğunda News Letter Subscribe alanını yes olarak işaretleyerek kayıt olabilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı news letter subscribe alanını yes olarak işaretler
        registerPage.radioButtonYes.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturulduğunu verify eder
        Assert.assertTrue(registerPage.verificationOfCreation.getText().contains("Created!"),ConfigReader.getProperty("Account creation could not be verified"));

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_13() {
        // TC_004_13 Kullanıcı, kayıt formunu doldurduğunda News Letter Subscribe alanını no olarak işaretleyerek kayıt olabilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı news letter subscribe alanını no olarak işaretler
        registerPage.radioButtonNo.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturulduğunu verify eder
        Assert.assertTrue(registerPage.verificationOfCreation.getText().contains("Created!"),ConfigReader.getProperty("Account creation could not be verified"));

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_14() {
        // TC_004_14 Kullanıcı, kayıt olduktan sonra geçerli email ve şifre ile giriş yapabilmelidir.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı geçerli mail adresini email adresi alanına girer

        //Kullaıncı geçerli şifresini password alanına girer

        //Kullanıcı login butonuna tıklar

        //Başarılı bir şekilde login olduğunu verify eder

        DriverThreadLocal.closeBrowser();

    }


    @Test
    public void TC_004_15() {
        // TC_004_15 Kullanıcı, daha önce kayıt olduğu bir mail adresi ile ikinci bir kullanıcı oluşturmamalıdır.

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(ConfigReader.getProperty("email_first_register"));

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı news letter subscribe alanını no olarak işaretler
        registerPage.radioButtonNo.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.warningMessage.isDisplayed(),"Warning message for creating an account with same credantials is not displayed");

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_16() {
        // TC_004_16 Kullanıcı, first name alanına 32 karakter uzunluğunda isim girdiğinde register olmalıdır

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name_TC_004_16"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı news letter subscribe alanını no olarak işaretler
        registerPage.radioButtonNo.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturulduğunu verify eder
        Assert.assertTrue(registerPage.verificationOfCreation.getText().contains("Created!"),ConfigReader.getProperty("Account creation could not be verified"));

        DriverThreadLocal.closeBrowser();

    }

    @Test
    public void TC_004_17() {
        // TC_004_17 Kullanıcı, first name alanına 32 karakterden daha uzun isim girdiğinde register olmamalıdır

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name_TC_004_17"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı news letter subscribe alanını no olarak işaretler
        registerPage.radioButtonNo.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();

        //Kullanıcı hesap oluşturamadığını verify eder
        Assert.assertTrue(registerPage.firstnameErrorMessage.isDisplayed(),"Error message for creating an account is not displayed");

        DriverThreadLocal.closeBrowser();

    }


    @Test
    public void TC_004_18() {
        // TC_004_18 Kullanıcı, first name alanına 1 karakter uzunluğunda isim girdiğinde register olmalıdır

        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        RegisterPage registerPage = new RegisterPage();

        driver.get(ConfigReader.getProperty("automationlabs_url"));

        //Kullanıcı first name alanını doldurur
        registerPage.firstname.sendKeys(ConfigReader.getProperty("first_name_TC_004_18"));

        //Kullanıcı last name alanını doldurur
        registerPage.lastname.sendKeys(ConfigReader.getProperty("last_name"));

        //Kullanıcı email alanını doldurur
        registerPage.email.sendKeys(Faker.instance().internet().emailAddress());

        //Kullanıcı telefon alanına geçerli bir telefon numarası girer
        registerPage.telephone.sendKeys(ConfigReader.getProperty("telephone"));

        //Kullanıcı password alanını doldurur
        registerPage.password.sendKeys(ConfigReader.getProperty("password"));

        //Kullanıcı confirm password alanını doldurur
        registerPage.passwordConfirm.sendKeys(ConfigReader.getProperty("password_confirm"));

        //Kullanıcı privacy policy şartlarını kabul eder
        registerPage.policyCheckbox.click();

        //Kullanıcı news letter subscribe alanını no olarak işaretler
        registerPage.radioButtonNo.click();

        //Kullanıcı continue butonuna tıklar
        registerPage.continueButton.click();


        //Kullanıcı hesap oluşturulduğunu verify eder
        Assert.assertTrue(registerPage.verificationOfCreation.getText().contains("Created!"),"Account creation could not be verified");

        DriverThreadLocal.closeBrowser();

    }



}
