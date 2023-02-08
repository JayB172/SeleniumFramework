package SeleniumFramework.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFramework.pageobjects.LandingPageObject;   
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPageObject landingPageObject ;
	
	
	public WebDriver initializeBrowser() throws IOException {
		
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/automation-mac/Selenium-workspace/SeleniumFramework/src/main/java/Resources/GlobalData.properties");
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}
		
		      //Create a driver object
				
				
				//Create a landing page object for using page object model
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				driver.manage().window().maximize();
				
				return driver;
				
		
	}
	
	@BeforeMethod
	public LandingPageObject launchApplication() throws IOException {
		
		
		driver = initializeBrowser();
		landingPageObject = new LandingPageObject(driver);
		landingPageObject.hitUrl();
		return landingPageObject;
		
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		String JsonContent = FileUtils.readFileToString(new File(filePath));
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String , String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String , String>>>() {});
		
		return data;
	}

}
