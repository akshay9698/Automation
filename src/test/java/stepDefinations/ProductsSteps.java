package stepDefinations;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.Headers;
import pageObjects.ProductsPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductsSteps {

    WebDriver driver;
    Headers hp;
    ProductsPage pp;
    CartPage cp;

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
    
    @When("Hover over first product and click Add to cart and clicks Continue Shopping button")
    public void hover_over_first_product_and_click_add_to_cart_and_clicks_continue_shopping_button() {
    	
    	pp=new ProductsPage(BaseClass.getDriver());
    	pp.clickAddToCartFirst();
    	pp.clickContinueShopping();
    }

    @When("Hover over second product and click Add to cart and  clicks View Cart button")
    public void hover_over_second_product_and_click_add_to_cart_and_clicks_view_cart_button() {
        pp.clickAddToCartSec();
        pp.clickViewCart();
    }

    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
       cp=new CartPage(BaseClass.getDriver());
       int expectedProducts= 2;
       int actualProducts=cp.noOfProductsInCart();
       Assert.assertEquals(expectedProducts, actualProducts);
       
    }

    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price(DataTable dataTable) {
    	 List<List<String>> data=dataTable.asLists(String.class);
    	 List<String> expectedPrices=data.get(1);
    	 List<String> expectedQuntys= data.get(2);
    	 List<String> expectedTotalPrices= data.get(3);
    	 
    	 List<String> actualPrices=cp.getProductPrices();
    	 List<String> actualQuntys=cp.getProductsQnty();
    	 List<String> actualTotalPrices=cp.getProductTotalPrices();
    	 
    	// Verify Prices
    	 for (int i = 0; i < expectedPrices.size(); i++) {
             Assert.assertEquals("Price of product " + (i + 1) + " should match.",
                     expectedPrices.get(i), actualPrices.get(i));
         }

         // Verify Quantities
         for (int i = 0; i < expectedQuntys.size(); i++) {
             Assert.assertEquals("Quantity of product " + (i + 1) + " should match.",
            		 expectedQuntys.get(i), actualQuntys.get(i));
         }

         // Verify Total Prices
         for (int i = 0; i < expectedTotalPrices.size(); i++) {
             Assert.assertEquals("Total price of product " + (i + 1) + " should match.",
                     expectedTotalPrices.get(i), actualTotalPrices.get(i));
         }
    	
    }



}
