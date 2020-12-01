package testRun;


//when a class object gets created all the variable get initialized with null.
//Unconditional: we have Thread.sleep()
//conditional:implicit weight, explicit wait and fluent wait for synchronization. 
//Implicit wait you use it only once throughout the run.it is a wait for the DOM.
//Implicit wait-it is only used for find elements and find elements.
//Explicit wait-has more condition not just time. it will only wait for that specific element.
//it is used by 
//fluent wait:similar to explicit wait. but it has polling time meaning it has intervals. for ex: chehcing every 5 sec in the duration of the entire waittime.
//
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageFactory.DashBoardPageFactory;
import pageFactory.HomePageFactory;
import utils.DriverManager;
import utils.SeleniumHelper;

public class PracticeTest {
	//Assert:
	@Test
	public void fristTest() {
		DriverManager dm =new DriverManager();
		dm.openBrowser("Chrome");
		SeleniumHelper sh = new SeleniumHelper();
		HomePageFactory homePage= new HomePageFactory(DriverManager.getDriver());
		DashBoardPageFactory dashBoard= new DashBoardPageFactory(DriverManager.getDriver());
		SoftAssert sa = new SoftAssert();

		//		hpf.userNametextBox.sendKeys("Admin");
		//		hpf.passWordTextBox.sendKeys("admin123");
		//		hpf.logInButton.click();

		sh.getToURL("https://opensource-demo.orangehrmlive.com/");
		//		sh.highlightElement(homePage.userNametextBox);
		//		sh.unHighlightElement(homePage.userNametextBox);
		String window1=sh.getCurrentWindowHadle();
		System.out.println(window1);
		homePage.enterUserName("Admin");
		//	sh.highlightElement(homePage.passWordTextBox);
		homePage.enterPassWord("admin123");
		homePage.clickLogInButton();

		//sh.openNewWindow(dashBoard.dashBoardlTitle);
//		sh.openURLNewWindow("https://opensource-demo.orangehrmlive.com/");
//		sh.sleep(1);
//		sh.getToURL("https://www.google.com/");
//		//sh.switchtWindow();
//		sh.switchNextWindow();
//		sh.getToURL("https://www.google.com/");
//		String window2=sh.getCurrentWindowHadle();
//		System.out.println(window2);
		sh.takeScreenShot();
		//		dashBoard.click();
		//		
		//		dashBoard.selectDropDown(3);
		//		sh.sleep(2);
		//		


		String actual = dashBoard.getTextDashBoardlTitle();
		//		String expected ="Dashboard";
		//		sa.assertEquals(actual, expected);
		//		sa.assertAll();
		//		WebElement header= sh.getElement("//input[@id='txtUsername']");
		//		String title = header.getText();
		//		System.out.println(title);
		//		String title2=sh.waitForElement(header).getText();
		//		String title3 =sh.waitForElement(header).getText();
		//		System.out.println(sh.waitForElement(header).getText());
		//		System.out.println(title2);
		//		System.out.println(title3);
		//		System.out.println(sh.ifWebElementExists(header));
		//		
		//	sh.navigateToURL("https://www.google.com/");
		//		sh.navigateBack();
		//		sh.navigateForward();
		//		sh.refreshPage();
		//		System.out.println(sh.getTitle());
		sh.sleep(2);

		dm.quitBrowser();
	}
	@Test
	public void test2() {
		
		SeleniumHelper sl = new SeleniumHelper();
		
		String cell1 = sl.getDataFromExcelSheet("documents/employees.xlsx","Sheet1", 1,0);
		System.out.println(cell1);
	}



}
