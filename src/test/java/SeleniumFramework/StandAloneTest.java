package SeleniumFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFramework.TestComponents.BaseTest;
import SeleniumFramework.pageobjects.CartItems;
import SeleniumFramework.pageobjects.ProductCatalogue;
 


public class StandAloneTest extends BaseTest {
	
	@Test(dataProvider = "getData")

	public void submitOrder(HashMap<String , String> input) throws IOException {
		// TODO Auto-generated method stub
//		
//		WebDriverManager.chromedriver().setup();
//		
//		//Create a driver object
//		WebDriver driver = new ChromeDriver();
//		
//		//Create a landing page object for using page object model
//		
//		LandingPageObject landingPageObject = new LandingPageObject(driver);
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		
//		driver.manage().window().maximize();
//		
//		landingPageObject.hitUrl();
		
		
		
		ProductCatalogue productCatalog = landingPageObject.performlogin("123abc@gmail.com" , "Abc@123456");
		
		 productCatalog.productName(input.get("product"));
		
		 CartItems cartItem = productCatalog.addProductToCart(input.get("product"));	

		cartItem.clickCartButton();		
		
		boolean match = cartItem.checkSelectedProduct(input.get("product"));
		
		
		
		cartItem.selectCountry(input.get("country"), ".ta-item:nth-of-type(2)");		

		cartItem.getOrderId();	
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String , String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//SeleniumFramework//Data//Data.json");
		
		return new Object[][] {{data.get(0)} , {data.get(1)} , {data.get(2)}};
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
