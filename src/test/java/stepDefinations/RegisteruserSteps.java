package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class RegisteruserSteps {
	
	public WebDriver driver=BaseClass.getDriver();
	public HomePage  hp=new HomePage(driver);
	public LoginPage lp=new LoginPage(driver);;
	public RegisterPage rp=new RegisterPage(driver);

	
	
	@Then("Verify New User Signup! is visible")
	public void verifyUserSignupText() {
	    String text=lp.getNewUserText();
	    Assert.assertEquals(text, "New User Signup!");
	}

	@When("User enters name and email address and clicks on sign up button")
	public void entersNameAndEmail() {
	    lp.setName(BaseClass.randomeString());
	    lp.setnewEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	    lp.clickSignUp();
	}

	@Then("Verify that ENTER ACCOUNT INFORMATION is visible")
	public void verifyEnterAccountInformation() {
	    String text=rp.getRegisterText();
	    Assert.assertEquals(text, "ENTER ACCOUNT INFORMATION");
	}

	@When("User fills registration form")
	public void setRegistrationForm() {
	    rp.selectGender();
	    rp.setPassword(BaseClass.randomAlphaNumeric());
	    rp.setDay("2");
	    rp.setMonth("May");
	    rp.setYear("1996");
	    rp.clickNewsLetter();
	    rp.clickOffer();
	    rp.setfName(BaseClass.randomeString());
	    rp.setlName(BaseClass.randomeString());
	    rp.setCompany(BaseClass.randomeString());
	    rp.setAddress(BaseClass.randomAlphaNumeric());
	    rp.selectCountry("India");
	    rp.setState(BaseClass.randomeString());
	    rp.setCity(BaseClass.randomeString());
	    rp.setZip(BaseClass.randomeNumber());
	    rp.setMobile(BaseClass.randomeNumber());
	}

	@When("clicks on create account button")
	public void clickCreateAccountButton() {
	    rp.clickCreateAccount();
	}

	@Then("Verify that ACCOUNT CREATED! is visible")
	public void verifyAccountCreated() {
	    String conMsg=rp.getCofMessage();
	    Assert.assertEquals(conMsg, "ACCOUNT CREATED!");
	}

	@When("click on continue button")
	public void clickContinueButton() {
	    rp.clickContinue();
	}

	@Then("Verify that Logged in as username is visible")
	public void verifyLoggedInAsUsername() {
		String userName=hp.getUserName();
		System.out.println(userName);
	}

	@When("Click Delete Account button")
	public void clickDeleteAccountButton() {
	    hp.clickDeleteAcc();
	}

	@Then("Verify that ACCOUNT DELETED! is visible")
	public void verifyAccountDeleted() {
        Assert.assertTrue(hp.isAccountDeleted());
		
	}

	@When("click Continue button")
	public void clickDeleteContinueButton() {
	    hp.clickContinue();
	}

}
