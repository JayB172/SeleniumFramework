package SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumFramework.pageobjects.CartItems;
import SeleniumFramework.pageobjects.LandingPageObject;
import SeleniumFramework.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;



public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		//Create a driver object
		WebDriver driver = new ChromeDriver();
		
		//Create a landing page object for using page object model
		
		LandingPageObject landingPageObject = new LandingPageObject(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		landingPageObject.hitUrl();
		
		ProductCatalogue productCatalog = landingPageObject.performlogin("123abc@gmail.com" , "Abc@123456");
		
		 productCatalog.productName("ADIDAS ORIGINAL");
		
		 CartItems cartItem = productCatalog.addProductToCart("ADIDAS ORIGINAL");	

		cartItem.clickCartButton();		
		
		boolean match = cartItem.checkSelectedProduct("ADIDAS ORIGINAL");
		
		Assert.assertTrue(match, "Matched");
		
		cartItem.selectCountry("India", ".ta-item:nth-of-type(2)");		

		cartItem.getOrderId();	
	}

}

/*
 * //driver.findElement(By.id("userEmail")).sendKeys("123abc@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Abc@123456");
		//driver.findElement(By.id("login")).click();
		
		
		//List<WebElement> products = productCatalog.getProductList();
		
		//WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
				
		//WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
			
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
					
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
			
			
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//driver.findElement(By.cssSelector("[routerlink= '/dashboard/cart']")).click();
		//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		//boolean match = cartProducts.stream().anyMatch(product -> product.getText().equals("ADIDAS ORIGINAL"));
		
		//Assert.assertTrue(match, "Matched");
		
		//driver.findElement(By.cssSelector(".subtotal .btn")).click();
				
		//Actions a = new Actions(driver);
		
		//a.sendKeys(driver.findElement(By.cssSelector(".user__address .input")), "India").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		//driver.findElement(By.cssSelector(".btnn")).click();
		
		//String orderId = driver.findElement(By.cssSelector("table label.ng-star-inserted")).getText();
 * */
