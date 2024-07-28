package stepDefinations;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.Headers;
import pageObjects.ProductsPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductsSteps {

    WebDriver driver;
    Headers hp;
    ProductsPage pp;

    @Given("User navigate to products page")
    public void navigateToProductsPage() {
        hp=new Headers(BaseClass.getDriver());
        hp.clickProducts();
    }
    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyAllProductsPage() {
        pp=new ProductsPage(BaseClass.getDriver());
        assertEquals("ALL PRODUCTS",pp.getAllProductsText());


    }
    @Then("Product list should be visible to user")
    public void isProductListVisible() {
        Assert.assertTrue(pp.isListOfProductsDisplayed());

    }
    @When("User clicks on the view product of the first product")
    public void clicksOnTheViewProductOfFirstProduct() {
        pp.clickViewProduct();
    }
    @Then("User should be landed on the product details page")
    public void isNavigatedOnTheProductDetailsPage() {
        driver=BaseClass.getDriver();
        assertEquals("Automation Exercise - Product Details",driver.getTitle());

    }
    @Then("User should see the product details are visible")
    public void verifyProductDetails(DataTable dataTable) {
       List<Map<String,String>> expectedDetails=dataTable.asMaps(String.class,String.class);
       List<String> actualDetails=pp.getProductDetailsList();

        for (Map<String, String> expectedDetail : expectedDetails) {
            String expectedValue = expectedDetail.get("Value");
            Assert.assertTrue("Expected value not found: " + expectedValue, actualDetails.contains(expectedValue));
        }

    }

    @Then("User  Enter product name as {string} in search input and click search button")
    public void userEntersProductNameAndClickSearch(String productName) {
        pp=new ProductsPage(BaseClass.getDriver());
        pp.SetProductName(productName);
         pp.clickSearchProductButton();

    }
    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verifySearchedProductsIsVisible() {
    pp.isSearchedProductDisplayed();

    }
    @Then("Verify all the products related to search are visible")
    public void verifyListOfSearchedProductsAreVisible() {
        pp.isListOfProductsDisplayed();

    }


}
