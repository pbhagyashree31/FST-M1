package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void method1() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");

	}

	@Test(groups= {"HeaderTests","ButtonTests"})
	public void titleTest() {

		System.out.println(driver.getTitle());

		Assert.assertEquals(driver.getTitle(), "Target Practice");
	}

	@Test(dependsOnMethods= {"titleTest"},groups= {"HeaderTests"})
	public void headerTest1() {

		WebElement header3 = driver.findElement(By.xpath("//h3[@id='third-header']"));
		Assert.assertEquals(header3.getText(), "Third header");
	}

	@Test(dependsOnMethods= {"titleTest"},groups= {"HeaderTests"})
	public void hearerTest2() {
		WebElement header5 = driver.findElement(By.xpath("//h5[contains(text(),'Fifth header')]"));
		System.out.println(header5.getCssValue("color"));
		Assert.assertEquals(header5.getCssValue("color"), "rgb(33, 186, 69)");
	}

	@Test(dependsOnMethods= {"titleTest"},groups= {"ButtonTests"})
	public void buttonTest1() {
		WebElement button1 = driver.findElement(By.xpath("//div/button[contains(text(),'Olive')]"));
		Assert.assertEquals(button1.getText(), "Olive");

	}

	@Test(dependsOnMethods= {"titleTest"},groups= {"ButtonTests"})
	  public void buttonTest2() {
		
		WebElement button2 = driver.findElement(By.xpath("//div/button[contains(text(),'Brown')]"));
		System.out.println(button2.getCssValue("color"));
		Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
	}

	@AfterMethod
	public void driverClose() {
		driver.close();

	}

}
