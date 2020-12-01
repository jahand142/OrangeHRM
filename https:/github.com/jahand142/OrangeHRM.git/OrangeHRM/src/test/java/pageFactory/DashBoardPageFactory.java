package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.SeleniumHelper;

public class DashBoardPageFactory {
	SeleniumHelper sh= new SeleniumHelper();

	//page object model: to organize everything based on pages.

	public DashBoardPageFactory(WebDriver driver) {

		driver=DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	public WebElement dashBoardlTitle;
	
	@FindBy(xpath = "//b[contains(text(),'PIM')]")
	public WebElement pimTitle;
	
	
	@FindBy(xpath = "//select[@id='empsearch_employee_status']")
	public WebElement employementStatus;

	public String getTextDashBoardlTitle() {
		return sh.waitForElement(dashBoardlTitle).getText();

	}
	public void click() {
		sh.waitForElement(pimTitle).click();
	
	}
	public void selectDropDown(int index) {
		sh.selectFromDropDown(employementStatus,index); 
	

}}
// Assert:

