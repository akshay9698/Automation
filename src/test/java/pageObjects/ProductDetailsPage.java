package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//div[@class='product-information']")
	WebElement productDetails;

	@FindBy(xpath = "//input[@id='quantity']")
	WebElement quantity;

	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	WebElement btnaddToCart;

	@FindBy(xpath = "//u[normalize-space()='View Cart']")
	WebElement lnkViewCart;

	public boolean isProductDetailsVisible() {
		return productDetails.isDisplayed();
	}

	public void setProductQuantity(String qnt) {
		quantity.clear();
		quantity.sendKeys(qnt);
	}

	public void clickAddToCart() {
		btnaddToCart.click();
	}

	public void clickViewCart() {
		lnkViewCart.click();
	}

}
