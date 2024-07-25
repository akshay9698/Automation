package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	
	
	@Given("The user navigate to login page")
	public void the_user_navigate_to_login_page() {
	    hp=new HomePage(BaseClass.getDriver());
	    hp.clickSignin();
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		lp=new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
		
	    
	}

	@When("user clicks on log in")
	public void user_clicks_on_log_in() {
		
		lp.clickLogin();
	    
	}

	@Then("logged in username should be displayed.")
	public void logged_in_username_should_be_displayed() {
		
		Assert.assertTrue(hp.isLoginNameDisplayed());
	    
	}

}
