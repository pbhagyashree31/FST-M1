package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class NewTestNGExamples {
	@Test(priority=2)
	public void One() {
	    System.out.println("This is the Test Case number One");
	}

	@Test(priority=1)
	public void Two() throws SkipException{
	    System.out.println("This is the Test Case number Two");
	    
	    String condition ="Skip Test";

	    if(condition.equals("Skip Test")){
		throw new SkipException("Skipping - This is not ready for testing ");
	    } else {
		//Execute test case when conditions are satisfied
	    }
	}

	@Test(priority=0)
	public void Three() {
	    System.out.println("This is the Test Case number Three");
	}
}


