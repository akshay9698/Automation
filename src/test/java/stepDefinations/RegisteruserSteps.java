package stepDefinations;

import org.junit.Assert;


import factory.BaseClass;
import io.cucumber.java.en.*;

import pageObjects.Headers;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class RegisteruserSteps {
	

	Headers hp;
	LoginPage lp;
	RegisterPage rp;


	
	
	@Then("Verify New User Signup! is visible")
	public void verifyUserSignupText() {
		lp=new LoginPage(BaseClass.getDriver());
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
		rp=new RegisterPage(BaseClass.getDriver());
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
		hp=new Headers(BaseClass.getDriver());
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

	@When("User enters name and existing email address as {string} and clicks on sign up button")
	public void enterNameAndExistingEmail(String email) {
		try {
			lp.setName(BaseClass.randomeString());
			lp.setnewEmail(email);
			lp.clickSignUp();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	@Then("Verify error Email Address already exist! is visible")
	public void verifyErrorMessageEmailAlreadyExist() {
		Assert.assertEquals("Email Address already exist!",lp.getErrorMessage());
	}

}
