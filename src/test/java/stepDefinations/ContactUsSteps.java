package stepDefinations;


import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.ContactUsPage;
import pageObjects.Headers;

public class ContactUsSteps {

    WebDriver driver=BaseClass.getDriver();
    ContactUsPage cp;
    Headers hp;


    @Given("User navigate to contact us page")
    public void user_navigate_to_contact_us_page() {
        hp=new Headers(BaseClass.getDriver());
        hp.clickContactUs();

    }
    @Then("verify the GET IN TOUCH text")
    public void verify_the_get_in_touch_text() {
        ContactUsPage cp=new ContactUsPage(BaseClass.getDriver());
        Assert.assertEquals("GET IN TOUCH", cp.getINTouch());

    }
    @When("User Enter name, email, subject and message")
    public void user_enter_name_email_subject_and_message() {
        cp=new ContactUsPage(BaseClass.getDriver());
        cp.setTxtContactPageName(BaseClass.randomeString());
        cp.setTxtContactPageEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
        cp.setTxtContactPageSubject(BaseClass.randomeString());
        cp.setTxtContactPageMessage(BaseClass.randomAlphaNumeric());


    }
    @When("Upload file and clicks submit")
    public void upload_file_and_clicks_submit() {
        cp.uploadFileInContactUsPage(System.getProperty("user.dir")+"\\testData\\Day60.txt");
        cp.clickSubmit();

    }
    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        driver.switchTo().alert().accept();
        Assert.assertEquals("Success! Your details have been submitted successfully.",cp.getConfirmMessage());


    }
    @When("User Click Home button")
    public void clickHome() {
        cp.clickHomeButton();
    }
    @Then("verify that landed to home page successfully")
    public void verify_that_landed_to_home_page_successfully() {
        Assert.assertEquals("Automation Exercise",driver.getTitle());
    }
}
