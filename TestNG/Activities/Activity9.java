package testNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Activity9 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
		//open firefox browser
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//open the given url in browser
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("browser opened");

	}

	@BeforeMethod
	public void beforeMethod() {
		//switch focus to the page
		driver.switchTo().defaultContent();
		Reporter.log("focus is on main page");
	}

	@Test

	public void simpleAlertTestCase() {
		Reporter.log("simpleAlertTestCase() started |");
		driver.findElement(By.xpath("//button[@id='simple']")).click();
		 Reporter.log("Simple Alert opened |");
		Alert simpleAlert= driver.switchTo().alert();
		Reporter.log("Switched foucs to alert |");
		String text1=simpleAlert.getText();
		System.out.println(text1);
		 Reporter.log("Alert text is: " + text1 + " |");
		Assert.assertEquals(text1, "This is a JavaScript Alert!");
		simpleAlert.accept();
		Reporter.log("Alert closed");
		 
        Reporter.log("Test case ended |");
		
	}

	@Test

	public void confirmAlertTestCase() {
		Reporter.log("confirmAlertTestCase() started |");
		driver.findElement(By.xpath("//button[@id='confirm']")).click();
		 Reporter.log("confirmation Alert opened |");
		Alert confirmAlert= driver.switchTo().alert();
		Reporter.log("Switched foucs to alert |");
		String text2=confirmAlert.getText();
		System.out.println(text2);
		 Reporter.log("Alert text is: " + text2 + " |");
		Assert.assertEquals(text2, "This is a JavaScript Confirmation!");
		confirmAlert.dismiss();
		Reporter.log("Alert closed");
		 
        Reporter.log("Test case ended |");
		

	}

	@Test

	public void promptAlertTestCase() {
		Reporter.log("promptAlertTestCase() started |");
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		
		 Reporter.log("confirmation Alert opened |");
		Alert promptAlert= driver.switchTo().alert();
		Reporter.log("Switched foucs to alert |");
		promptAlert.sendKeys("hello");
		String text3=promptAlert.getText();
		System.out.println(text3);
		 Reporter.log("Alert text is: " + text3 + " |");
		Assert.assertEquals(text3, "This is a JavaScript Prompt!");
		promptAlert.dismiss();
		Reporter.log("Alert closed");
		 
        Reporter.log("Test case ended |");

	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}
}
