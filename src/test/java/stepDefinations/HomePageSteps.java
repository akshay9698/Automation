package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;

public class HomePageSteps {
	
	WebDriver driver;
	HomePage hp;
	
	@Given("user is on Homepage")
	public void userIsOnHomepage() {
	    System.out.println("Page Title is: "+ BaseClass.getTitle());
	}

	@When("Scroll down to footer")
	public void scrollToSubscription() {
	    hp=new HomePage(BaseClass.getDriver());
	    try {
	    hp.scrollToSubscribe();
	    }catch(Exception e)
	    {
	    	System.out.println("scroll down failed"+ e.getMessage());
	    }
	}

	@When("Enter email address in input")
	public void setSbscribeEmail() {
	    hp.setSubscriptionEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	}

	@Then("Verify text SUBSCRIPTION and click arrow button")
	public void verifySubscription() {
	    
	    hp.clickSubscribeArrow();
	    Assert.assertEquals("SUBSCRIPTION", hp.getTextSubscription());
	}

	@Then("Verify success message You have been successfully subscribed! is visible")
	public void verifySuccessMessage() {
		Assert.assertEquals("You have been successfully subscribed!", hp.getConSubscribeMsg());
	    
	}

}
