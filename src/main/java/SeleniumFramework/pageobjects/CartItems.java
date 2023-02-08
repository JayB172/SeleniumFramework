package SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class CartItems extends AbstractComponents {

	WebDriver driver;

	public CartItems(WebDriver driver) {

		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink= '/dashboard/cart']")
	WebElement CartBtn;

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = ".subtotal .btn")
	WebElement CheckoutBtn;

	@FindBy(css = ".user__address .input")
	WebElement dropDown;
	
	@FindBy(css = ".btnn")
	WebElement placeOrder;
	
	@FindBy(css = "table label.ng-star-inserted")
	WebElement Order;
	

	
	By results = By.cssSelector(".ta-results");
	





	public void clickCartButton() {
		CartBtn.click();
	}

	public boolean checkSelectedProduct(String Item) {

		boolean match = cartProducts.stream().anyMatch(product -> product.getText().equals(Item));
		return match;
		
	}

	public void selectCountry(String type , String select) {
		CheckoutBtn.click();
		Actions a = new Actions(driver);
		a.sendKeys(dropDown, type).build().perform();
		waitForElements(results);
		driver.findElement(By.cssSelector(select)).click();
	}
	
	public void getOrderId() {
		
		placeOrder.click();
		String OrderID = Order.getText();
		System.out.println(OrderID);	
	}


}
