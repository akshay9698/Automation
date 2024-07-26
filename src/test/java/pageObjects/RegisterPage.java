package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement mr;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//select[@id='days']")
	WebElement day;

	@FindBy(xpath = "//select[@id='months']")
	WebElement smonth;

	@FindBy(xpath = "//select[@id='years']")
	WebElement years;

	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement signUpForOurNewsletter;

	@FindBy(xpath = "//input[@id='optin']")
	WebElement receiveSpecialOffersFromOu;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='company']")
	WebElement company;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2;

	@FindBy(xpath = "//select[@id='country']")
	WebElement country;

	@FindBy(xpath = "//input[@id='state']")
	WebElement state;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipcode;

	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement mobileNumber;

	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	WebElement createAccount;

	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	WebElement enterAccountInformation;

	@FindBy(xpath = "//b[normalize-space()='Account Created!']")
	WebElement accountCreated;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement btnContinue;

	public String getRegisterText() {
		return enterAccountInformation.getText();
	}

	public void selectGender() {
		mr.click();
	}

	public String getEnteredName() {
		return name.getText();
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void setDay(String date) {
		BaseClass.selectByVisibleText(day, date);
	}

	public void setMonth(String month) {
		BaseClass.selectByVisibleText(smonth, month);
	}

	public void setYear(String year) {
		BaseClass.selectByVisibleText(years, year);
	}

	public void clickNewsLetter() {
		signUpForOurNewsletter.click();
	}

	public void clickOffer() {
		receiveSpecialOffersFromOu.click();
	}

	public void setfName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setlName(String lName) {
		lastName.sendKeys(lName);
	}

	public void setCompany(String Com) {
		company.sendKeys(Com);
	}

	public void setAddress(String adds) {
		address1.sendKeys(adds);
	}

	public void selectCountry(String con) {
		BaseClass.selectByVisibleText(country, con);
	}

	public void setState(String sta) {
		state.sendKeys(sta);
	}

	public void setCity(String cyt) {
		city.sendKeys(cyt);
	}

	public void setZip(String zip) {
		zipcode.sendKeys(zip);
	}

	public void setMobile(String moba) {
		mobileNumber.sendKeys(moba);
	}

	public void clickCreateAccount() {
		createAccount.click();
	}

	public String getCofMessage() {
		return accountCreated.getText();
	}

	public void clickContinue() {
		btnContinue.click();
	}

}
