package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//h2[text()='All Products']")
    WebElement allProducts;

    @FindBy(xpath="(//a[text()='View Product'])[1]")
    WebElement viewProductButton;

    @FindBy(xpath="(//img[@alt='ecommerce website products'])")
    List<WebElement> productsList;

    @FindBy(xpath="//div[@class='product-information']//h2")
    WebElement nameOfFirstProduct;

    @FindBy(xpath="//div[@class='product-information']//p")
    List<WebElement> productDetailsList;

    @FindBy(xpath="//div[@class='features_items']//div[@class='productinfo text-center']/p")
    List <WebElement> listOfSearchedProducts;

    @FindBy(id="search_product")
    WebElement txtProduct;

    @FindBy(id="submit_search")
    WebElement btnSearch;

    @FindBy(xpath="//h2[normalize-space()='Searched Products']")
    WebElement searchedProductsText;
    
    @FindBy(xpath="//img[@src='/get_product_picture/1']")
    WebElement hoverFirstProduct;
    
    @FindBy(xpath="//a[@data-product-id='1']")
    WebElement btnAddToCart1;
    
    @FindBy(xpath="//button[normalize-space()='Continue Shopping']")
    WebElement btnContinueShopping;
    
    @FindBy(xpath="//a[@data-product-id='2']")
    WebElement btnAddToCart2;
    
    @FindBy(xpath="//u[normalize-space()='View Cart']")
    WebElement btnViewCart;

    public String getAllProductsText()
    {
        return allProducts.getText();
    }

    public void clickViewProduct()
    {
        BaseClass.javascriptClick(viewProductButton);
    }

    public boolean isListOfProductsDisplayed()
    {
        for(WebElement product : productsList)
        {
            if(!product.isDisplayed())
            {
                return false;
            }
        }
        return true;
    }

    public String getFirstProductName()
    {
        return nameOfFirstProduct.getText();
    }

    public List<String> getProductDetailsList()
    {
        List<String> productDetails=new ArrayList<String>();
        for(WebElement details : productDetailsList)
        {
            productDetails.add(details.getText());
        }

        return productDetails;
    }

    public void SetProductName(String productName)
    {
        txtProduct.sendKeys(productName);
    }

    public void clickSearchProductButton()
    {
        btnSearch.click();
    }

    public boolean isSearchedProductDisplayed()
    {
        return searchedProductsText.isDisplayed();
    }

    public boolean isSearchedProductListDisplayed(String productName)
    {
        for(WebElement product : listOfSearchedProducts)
        {
            if(!product.getText().toLowerCase().contains(productName))
            {
                return false;
            }
        }
        return true;
    }
    
    public void clickAddToCartFirst()
    {
    	BaseClass.javascriptClick(btnAddToCart1);  }
    
    public void clickContinueShopping()
    {
    	btnContinueShopping.click();
    }
    
    public void clickAddToCartSec()
    {
    	BaseClass.javascriptClick(btnAddToCart2);  
    }
    
    public void clickViewCart()
    {
    	btnViewCart.click();
    }
    
    
    





}
