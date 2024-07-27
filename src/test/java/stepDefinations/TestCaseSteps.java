package stepDefinations;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.Headers;

public class TestCaseSteps {

    WebDriver driver;
    Headers hp;


    @When("User navigate to Test Case page")
    public void userNavigateToTestCase() {
        hp=new Headers(BaseClass.getDriver());
        hp.clickTestCases();
    }
    @Then("Verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        driver=BaseClass.getDriver();
        Assert.assertEquals("https://www.automationexercise.com/test_cases",driver.getCurrentUrl());
    }
}
