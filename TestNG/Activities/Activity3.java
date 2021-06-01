package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;
	
	@BeforeMethod
	public  void method1(){
		driver=new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		
		
	}
  @Test
  public void f() {
	 
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
	  driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	  String msg=driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
	
	  System.out.println(msg);
	 Assert.assertEquals(msg, "Welcome Back, admin");
  }
 @AfterMethod
 public void driverClose() {
	 driver.close();
	 
	 
	 
 }
  
}
