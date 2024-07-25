package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public  HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// Click in signin and signup
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement lnkSigninUp;
	
	@FindBy(xpath="//li[10]//a[1]")
	WebElement userName;
	
	
	public void clickSignin()
	{
		lnkSigninUp.click();
	}
	
	public boolean isLoginNameDisplayed()
	{
		return userName.isDisplayed();
	}
	

}
