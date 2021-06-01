package testNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/login-form");
		  
	}

	@DataProvider(name="Authentications")
	public static Object[][] credentials() {
		return new Object[][] {{"admin","password"}};
		
	}

	@Test(dataProvider="Authentications")
	
	public void f(String username, String password) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		  
		  //Assert Message
	        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	        Assert.assertEquals(loginMessage, "Welcome Back, admin");
		
	}

	 
	 @AfterClass
		public void afterClass(){
		 driver.close();
		
		}
 }
	
	

