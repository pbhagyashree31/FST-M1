package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGExamples {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		
	}
	
	@Test
	public void TestCase1(){
		String str=driver.findElement(By.xpath("//div[@class='companylogo']/img")).getAttribute("src");
		System.out.println(str);
		
	}
		
		

	

}
