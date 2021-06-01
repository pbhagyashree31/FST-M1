package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public  void method1(){
		driver=new FirefoxDriver();
		driver.get("https://www.training-support.net");
		
		
	}
  @Test
  public void f() {
	  driver.getTitle();
	  Assert.assertEquals(driver.getTitle(), "Training Support");
	  driver.findElement(By.linkText("About Us")).click();
	  String newTitle=driver.getTitle();
	  System.out.println(newTitle);
	 Assert.assertEquals(newTitle, "About Training Support");
  }
 @AfterMethod
 public void driverClose() {
	 driver.close();
	 
	 
	 
 }
  
}
