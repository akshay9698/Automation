package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//h2[text()='Get In Touch']")
    public WebElement GetInTouch;

    @FindBy(xpath="//input[@placeholder='Name']")
    public WebElement txtContactPageName;

    @FindBy(xpath="//input[@placeholder='Email']")
    WebElement txtContactPageEmail;

    @FindBy(xpath="//input[@placeholder='Subject']")
    WebElement txtContactPageSubject;

    @FindBy(xpath="//textarea[@id='message']")
    WebElement txtContactPageMessage;

    @FindBy(xpath="//input[@name='upload_file']")
    WebElement lnkContactPageUploadFile;

    @FindBy(xpath="//input[@name='submit']")
    WebElement btnContactPageSubmit;

    @FindBy(xpath="//div[@class='status alert alert-success']")
    WebElement msgContactPageSuccess;

    @FindBy(xpath="//span[normalize-space()='Home']")
    WebElement btnContactPageHome;



    public String getINTouch()
    {
        return GetInTouch.getText();
    }

    public void setTxtContactPageName(String name)
    {
        txtContactPageName.sendKeys(name);
    }

    public void setTxtContactPageEmail(String email)
    {
        txtContactPageEmail.sendKeys(email);
    }

    public void setTxtContactPageSubject(String subject)
    {
        txtContactPageSubject.sendKeys(subject);
    }

    public void setTxtContactPageMessage(String msg)
    {
        txtContactPageMessage.sendKeys(msg);
    }

    public void uploadFileInContactUsPage(String filePath)
    {
        lnkContactPageUploadFile.sendKeys(filePath);
    }

    public void clickSubmit()
    {
        btnContactPageSubmit.click();
    }

    public String getConfirmMessage()
    {
        return msgContactPageSuccess.getText();
    }

    public void clickHomeButton()
    {
        btnContactPageHome.click();
    }

}
