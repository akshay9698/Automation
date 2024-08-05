package stepDefinations;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;

import pageObjects.Headers;
import pageObjects.LoginPage;
import utilities.DataReader;

public class LoginSteps {

	WebDriver driver;
	Headers hp;
	LoginPage lp;
	List<HashMap<String, String>> dataMap;

	@Given("The user navigate to login page")
	public void the_user_navigate_to_login_page() {
		hp = new Headers(BaseClass.getDriver());
		hp.clickSignin();
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);

	}

	@When("user clicks on log in")
	public void user_clicks_on_log_in() {

		lp.clickLogin();

	}

	@Then("logged in username should be displayed and click on logout")
	public void logged_in_username_should_be_displayed() {

		String name = hp.getUserName();
		hp.clickLogout();
		Assert.assertEquals(name, "Ak");

	}

	// Data Driven Test Case

	@Then("logged in username should be displayed by passing email and password with excel row {string}")
	public void logged_in_username_should_be_displayed_by_passing_email_and_password_with_excel_row(String rows) {

		dataMap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Automation_LoginData.xlsx", "Sheet1");

		int index = Integer.parseInt(rows) - 1;
		String email = dataMap.get(index).get("username");
		String pwd = dataMap.get(index).get("password");
		String exp_res = dataMap.get(index).get("res");

		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();

		hp = new Headers(BaseClass.getDriver());
		try {
			boolean username = hp.isLogoutDisplayed();
			System.out.println("Uesr Name: " + username);

			if (exp_res.equals("Valid")) {
				if (username == true) {
					hp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp_res.equals("Invalid")) {
				if (username == true) {
					hp.clickLogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}

			}

		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

}
