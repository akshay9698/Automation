package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//td[@class='cart_description']")
	List <WebElement> numOfCartProducts;
	
	@FindBy(xpath="//td[@class='cart_price']")
	List <WebElement> productPrices;
	
	@FindBy(xpath="//tbody//button[@class='disabled'][normalize-space()='1']")
	List <WebElement> productQnty;
	
	@FindBy(xpath="//p[@class='cart_total_price']")
	List <WebElement> totalPrices;
	
	
	
	
	public int noOfProductsInCart()
	{
		return numOfCartProducts.size();
	}
	
	public List<String> getProductPrices()
	{
		List<String> Price=new ArrayList<String>();
		for(WebElement prices:productPrices)
		{
			 Price.add(prices.getText());
		}
		return Price;
	}
	
	public List<String> getProductsQnty()
	{
		List<String> qunty=new ArrayList<String>();
		for(WebElement qua:productQnty)
		{
			qunty.add(qua.getText());
		}
		
		return qunty;
	}
	
	public List<String> getProductTotalPrices()
	{
		List<String> total=new ArrayList<String>();
		for(WebElement tot:totalPrices)
		{
			total.add(tot.getText());
		}
		
		return total;
	}
	
	
}
