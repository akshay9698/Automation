package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Log in
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	
	//Sign up
	@FindBy(name="name")
	WebElement txtname;
	
	@FindBy(css="input[data-qa='signup-email']")
	WebElement txtnewEmail;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement btnSignup;
	
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']")
	WebElement titleText;
	
	
	
	
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		BaseClass.explicitVisibilityWait(btnLogin);
		btnLogin.click();
	}
	
	public void setName(String name)
	{
		txtname.sendKeys(name);
	}
	
	public void setnewEmail(String email)
	{
		txtnewEmail.sendKeys(email);
	}
	
	public void clickSignUp()
	{
		btnSignup.click();
	}
	
	public String getNewUserText()
	{
		BaseClass.explicitVisibilityWait(titleText);
		return titleText.getText();
	}

}
