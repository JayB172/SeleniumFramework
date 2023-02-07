package SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	//Initialise the driver variable
	
	WebDriver driver;
	
	//Create a constructor with web driver argument
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement loading;
	
	By findProducts = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");
	By loadingAnimation = By.cssSelector(".ng-animating");
	
	
	public List<WebElement> getProductList(){
		
		waitForElements(findProducts);
		
		return products;
	}
	
	public WebElement productName(String productName) {
		
		WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		return prod;
	}
	
	public CartItems addProductToCart(String productName) {
		WebElement prod = productName(productName);
		prod.findElement(addToCart).click();
		waitForElements(toastContainer);
		waitForElementToDisappear(loading);
		CartItems cartItem = new CartItems(driver);
		return cartItem;

		
	}

										
	

}
