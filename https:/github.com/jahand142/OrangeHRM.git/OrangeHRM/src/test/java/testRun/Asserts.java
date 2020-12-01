package testRun;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Asserts {

	//there are 2 types of Asserts. it helps us to determine the result of the test.
	//1. Hard Assert: if we have multiple asserts, if the first assert failed, it fails the entire 
	//test. it doesn't continue.
	//2.soft assert: however, soft assert continues throughout the test run, before failing the test.

	@Test
	public void hardAssert() {
		Assert.assertEquals(2, 2);

		Assert.assertEquals("Shishir", "Shishir");

		Assert.assertEquals(12, 12);

	} 

	@Test
	public void softAssert() {
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(2, 1);

		sa.assertEquals("Shishir", "Shishir");

		sa.assertEquals(12, "shish");

		//anytime we are using softassert we have TO end it with assert all.
		
		sa.assertAll();
	}

}
