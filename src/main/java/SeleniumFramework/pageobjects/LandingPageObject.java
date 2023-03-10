package SeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class LandingPageObject extends AbstractComponents {
	
	//Initialise the driver variable
	
	WebDriver driver;
	
	//Create a constructor with web driver argument
	
	public LandingPageObject(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue performlogin(String email , String passwd) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(passwd);
		submit.click();
		ProductCatalogue productCatalog = new ProductCatalogue(driver);
		return productCatalog;
	}
	
	public void hitUrl() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	public String getErrorMessage() {
		waitForWebElement(errorMessage);
		return errorMessage.getText();
	}

}
