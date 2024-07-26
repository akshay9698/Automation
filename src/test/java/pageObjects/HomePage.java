package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Click in signin and signup
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement lnkSigninUp;

	@FindBy(xpath = "//li[10]//a[1]/..//b")
	WebElement userName;

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	WebElement deleteAccount;

	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	WebElement AccountDeleted;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement hpContinue;

	public void clickSignin() {
		lnkSigninUp.click();
	}

	public String getUserName() {
		BaseClass.explicitVisibilityWait(userName);
		return userName.getText();
	}

	public void clickDeleteAcc() {
		deleteAccount.click();
	}

	public boolean isAccountDeleted() {
		return AccountDeleted.isDisplayed();
	}

	public void clickContinue() {
		hpContinue.click();
	}

}
