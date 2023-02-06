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
	
	By findProducts = By.cssSelector(".mb-3");
	
	
	public List<WebElement> getProductList(){
		
		waitForElements(findProducts);
		
		return products;
	}
	

}
