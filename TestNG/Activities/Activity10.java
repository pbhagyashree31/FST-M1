package testNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity10 {

	WebDriver driver;
	Actions builder;
	@BeforeClass
	public void beforeClass() {
		
		//open firefox browser
		driver = new FirefoxDriver();
		builder= new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//open the given url in browser
		driver.get("https://www.training-support.net/selenium/sliders");
		Reporter.log("browser opened");

	}
	@Test

	public void middleOfTheSlider() {
		WebElement slider=driver.findElement(By.xpath("//input[@id='slider']"));
		slider.click();
		builder.clickAndHold(slider).moveByOffset(50, 0).build().perform();
		String text=driver.findElement(By.cssSelector("span#value")).getText();
		Assert.assertEquals(text, "50");
		
	}

	@Test

	public void maxOfTheSlider() {
		WebElement slider=driver.findElement(By.xpath("//input[@id='slider']"));
		slider.click();
		builder.clickAndHold(slider).moveByOffset(100, 0).build().perform();
		String text=driver.findElement(By.cssSelector("span#value")).getText();
		Assert.assertEquals(text, "100");
		

	}

	@Test

	public void minOfTheSlider() {
		
		 //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
        
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "0");
	}
	@Test

	public void Slider30() {
		
		 //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
        
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "30");
	}
	@Test

	public void Slider80() {
		//Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(45, 0).release().build().perform();
        
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "80");

	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}
}
