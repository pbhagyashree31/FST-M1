package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	
	@BeforeMethod
	public  void method1(){
		driver=new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		
		
	}
  @Test
  public void f() {
	  driver.getTitle();
	  Assert.assertEquals(driver.getTitle(), "Target Practice");
	  
  }
  @Test
  public void f2() {
	  
	  WebElement webButton=driver.findElement(By.xpath("//div/button[contains(text(),'Black')]"));
	  Assert.assertTrue(webButton.isDisplayed());
	  Assert.assertEquals(webButton.getText(), "black");
	  
  }
  
  @Test(enabled=false)
  public void f3() {
	  
  }
  @Test
  public void f4(){
	  throw new SkipException("Skipping test case");  
  }
 @AfterMethod
 public void driverClose() {
	 driver.close();
	 
	 
	 
 }
  
}
