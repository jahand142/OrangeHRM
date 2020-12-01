package pageFactory;
// a frame work is multiple component put together to meet your goal.
//my goal is to create a frame work that has all the component that creates.
//required tracability metrix. what are the steps. what you need to to, 
//
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.SeleniumHelper;

public class HomePageFactory {
	SeleniumHelper sh= new SeleniumHelper();
	//page object model: to organize everything based on pages.

	public HomePageFactory(WebDriver driver) {

		driver=DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='logInPanelHeading']")
	public WebElement logInPanelTitle;

	@FindBy(xpath="//input[@id='txtUsername']")
	public WebElement userNametextBox;

	@FindBy(xpath="//input[@id='txtPassword']")
	public WebElement passWordTextBox;

	@FindBy(xpath="//input[@id='btnLogin']")
	public WebElement logInButton;

	public void enterUserName(String userName) {
		//userNametextBox.sendKeys(userName);
		sh.waitForElement(userNametextBox).sendKeys(userName);
		
	}

	public void enterPassWord(String PassWord) {
		//passWordTextBox.sendKeys(PassWord);
		sh.waitForElement(passWordTextBox).sendKeys(PassWord);
	}

	public void clickLogInButton() {
		sh.waitForElement(logInButton).click();
		//logInButton.click();
	}

	}
