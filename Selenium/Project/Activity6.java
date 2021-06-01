package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
		String title = driver.getTitle();
		// Print the title of the page
		System.out.println("Page title is: " + title);
		// Assertion for page title
		// title.equals("Alchemy LMS – An LMS Application");
		// Finnding element
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		// Assertion for new page title
		// driver.getTitle().equals("My Account – Alchemy LMS");
		// Finding Login button
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and @id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@type='password' and @id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Log In']")).click();
		String heading=driver.findElement(By.xpath("//h1[contains(text(),'My Account')]")).getText();
		Assert.assertEquals(heading, "My Account");
		

		
		  // Locating the Main Menu (Parent element) 
		WebElement mainMenu = driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a"));
		  
		  //Instantiating Actions class 
		  Actions actions = new Actions(driver);
		  
		  //Hovering on main menu
		  actions.moveToElement(mainMenu);
		  actions.click(mainMenu).build().perform();
		  
		  // Locating the element from Sub Menu 
		  WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
		  actions.moveToElement(subMenu);
		  //To mouseover on sub menu 
		  actions.click(subMenu).build().perform();
		  System.out.println("logged out");
		  
		
		 
		  

		driver.close();
	}

}
