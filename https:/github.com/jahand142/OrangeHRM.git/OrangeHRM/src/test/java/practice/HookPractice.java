package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Hooks/Annotations- are used to run a piece of code over and over again without having to write it.
// There are few different Hooks, and each have their own functionality.
//1->  @Before method - it will run before each test method.
//2->  @Before class - it will run before that class.
//3->  @Before group - it will run before each test group.
//4->  @Before test - it will run before entire test run.
//5->  @Before suite - it will run before each test suite.
// All of them has after annotation also.


public class HookPractice {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is Before Suite.");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after Suite.");
	}
	
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("This is Before Group.");
	}

	@AfterGroups
	public void afterGroup() {
		System.out.println("This is after Group.");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("This is before All Test.");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("This is after All Test.");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after method");	
	}

		
	@Test (groups = {"Odd", "Red"} , priority = 0 ) 
	public void test1() {
		System.out.println("This is test 1");
	}

	@Test (groups = "Even")
	public void test2() {
		System.out.println("This is test 2");
	}

	@Test (groups = "Odd")
	public void test3() {
		System.out.println("This is test 3");
	}


}
