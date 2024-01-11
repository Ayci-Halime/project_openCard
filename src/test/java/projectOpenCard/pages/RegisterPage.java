package projectOpenCard.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class RegisterPage {

    public RegisterPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }


    @FindBy(id = "input-firstname")
    public WebElement firstname;

    @FindBy (id = "input-lastname")
    public WebElement lastname;

    @FindBy(id = "input-email")
    public  WebElement email;

    @FindBy (id = "input-telephone")
    public WebElement telephone;

    @FindBy (id = "input-password")
    public WebElement password;

    @FindBy (id = "input-confirm")
    public WebElement passwordConfirm;

    @FindBy (xpath = "(//input[@type='radio'])[2]")
    public WebElement radioButtonYes;

    @FindBy (xpath = "(//input[@type='radio'])[3]")
    public WebElement radioButtonNo;

    @FindBy (xpath = "//input[@type='checkbox']")
    public WebElement policyCheckbox;

    @FindBy (xpath = "//input[@type='submit']")
    public WebElement continueButton;

    @FindBy (tagName = "h1")
    public WebElement verificationOfCreation;    // hesap oluşturunca, bu elementin text'ini al ve .contains("Created!") ile verify et

    @FindBy(xpath = "//ul[@class='breadcrumb']//following::div")
    public WebElement warningMessage;  // aynı mail ile ikinci kez kayıt yapılmaya çalışınca çıkan uyarının locati

    @FindBy (xpath = "//div[@class='text-danger']")
    public WebElement firstnameErrorMessage;

    @FindBy (xpath = "//div[@class='text-danger']")
    public WebElement lastnameErrorMessage;

    @FindBy (xpath = "//div[@class='text-danger']")
    public WebElement emailErrorMessage;

    @FindBy (xpath = "//div[@class='text-danger']")
    public WebElement telephoneErrorMessage;

    @FindBy (xpath = "//div[@class='text-danger']")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//ul[@class='breadcrumb']//following::div")
    public WebElement privaciyPolicyErrorMessage;





}
