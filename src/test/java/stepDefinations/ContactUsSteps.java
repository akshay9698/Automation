package stepDefinations;


import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.ContactUsPage;
import pageObjects.Headers;






public class ContactUsSteps {
    @Given("User navigate to contact us page")
    public void user_navigate_to_contact_us_page() {
        Headers hp=new Headers(BaseClass.getDriver());
        hp.clickContactUs();

    }
    @Then("verify the GET IN TOUCH text")
    public void verify_the_get_in_touch_text() {
        ContactUsPage cp=new ContactUsPage(BaseClass.getDriver());
        Assert.assertEquals("GET IN TOUCH", cp.getINTouch());

    }
    @When("User Enter name, email, subject and message")
    public void user_enter_name_email_subject_and_message() {
        ContactUsPage cp=new ContactUsPage(BaseClass.getDriver());
        cp.setTxtContactPageName(BaseClass.randomeString());
        cp.setTxtContactPageEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
        cp.setTxtContactPageSubject(BaseClass.randomeString());
        cp.setTxtContactPageMessage(BaseClass.randomAlphaNumeric());


    }
    @When("Upload file and clicks submit")
    public void upload_file_and_clicks_submit() {
        ContactUsPage cp=new ContactUsPage(BaseClass.getDriver());
        cp.uploadFileInContactUsPage(System.getProperty("user.dir")+"\\testData\\Day60.txt");

    }
    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        ContactUsPage cp=new ContactUsPage(BaseClass.getDriver());


    }
    @When("User Click {string} button")
    public void user_click_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify that landed to home page successfully")
    public void verify_that_landed_to_home_page_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
