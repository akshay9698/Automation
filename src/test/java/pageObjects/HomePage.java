package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='Subscription']")
	WebElement textSubscription;

	@FindBy(xpath = "//input[@id='susbscribe_email']")
	WebElement txtSubscriptionEmail;

	@FindBy(xpath = "//button[@id='subscribe']")
	WebElement arrowSubscribe;

	@FindBy(xpath = "//div[@class='alert-success alert']")
	WebElement confSubscribe;

	@FindBy(css = "a[href='/product_details/2']")
	WebElement lnkViewProduct;

	public String getTextSubscription() {
		return textSubscription.getText();
	}

	public void setSubscriptionEmail(String email) {
		txtSubscriptionEmail.sendKeys(email);
	}

	public void clickSubscribeArrow() {
		arrowSubscribe.click();
	}

	public String getConSubscribeMsg() {
		return confSubscribe.getText();
	}

	public void scrollToSubscribe() {
		BaseClass.scrollDown(textSubscription);
	}

	public void clickViewProduct() {
		BaseClass.javascriptClick(lnkViewProduct);
	}

}
