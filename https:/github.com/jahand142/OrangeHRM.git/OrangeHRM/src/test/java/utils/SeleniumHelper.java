package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumHelper{

	//private static final String XSSFWorkBook wb  = null;
	// will return the title of the page

	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait;

	public String getTitle() {
		return driver.getTitle();

	}
	//will go to the  given website
	public void getToURL(String url) {
		driver.get(url);

		// navigate to given website

	}public void navigateToURL(String url) {
		driver.navigate().to(url);

	}
	// go to previous page

	public void navigateBack() {
		driver.navigate().back();

		//navigate forward
	} public void navigateForward() {
		driver.navigate().forward();

		// refresh page
	} public void refreshPage() {
		driver.navigate().refresh();
	}
	//hard sleep with given amount in sec
	public void sleep(int sec)  {
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			System.out.println("Syetm broke while sleeping");
			e.printStackTrace();

		}

	}// will grab the element

	public WebElement getElement(String locator) {
		return	 driver.findElement(By.xpath(locator));
	}

	//explicit wait -will search for element untill given condition is met 

	public WebElement waitForElement(WebElement element) {
		wait = new WebDriverWait(driver,20);
		return wait.until(ExpectedConditions.visibilityOf(element));

	} 

	//fluent wait-interval
	public WebElement waitForElementFluent(WebElement element) {
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		highlightElement(element);
		unHighlightElement(element);
		return webElement;


	}

	// will check if webelement exists and return true or false.	
	public boolean ifWebElementExists(WebElement element) {
		boolean isPresent;
		try {
			wait=new WebDriverWait(driver, 20); 
			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			return isPresent;

		} catch (Exception e) {

			return false;	
		}
	}

	//highlight element:

	public void highlightElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element);
		sleep(2);


	}

	//UNhighlight element:
	public void unHighlightElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='0px solid red'",element);
		sleep(2);

	}
	//select from drop down by index
	public void selectFromDropDown(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);

	}
	//select by drop down by value// exp of overloadding
	public void selectFromDropDown(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByValue(value);

	}
	//handle alart: pop up handle without xpath
	public void acceptAlert() {
		Alert a =driver.switchTo().alert();
		a.accept();

	}
	//dismiss alert
	public void dismissAlert() {
		Alert a =driver.switchTo().alert();
		a.dismiss();

	}
	// handle to iframe index
	public void switchToIframe(int index) {
		driver.switchTo().frame(index);

	}
	//handle to iframe index
	public void switchToIframe(String value) {
		driver.switchTo().frame(value);

	}
	//switch to parents frame
	public void switchToParentframe(String value) {
		driver.switchTo().parentFrame();

	}
	//get window handle
	public String getCurrentWindowHadle() {
		return driver.getWindowHandle();

	}
	//switch to new window
	public String switchtWindow() {
		String parentWindow= getCurrentWindowHadle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windows: allWindows) {
			driver.switchTo().window(windows);
		}
		String childWindow = getCurrentWindowHadle();
		return childWindow;

	}
	//switch to nextWindow
	public void switchNextWindow() {
		String parent =getCurrentWindowHadle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String window: allWindow) {
			if(!window.equals(parent)) {
				driver.switchTo().window(window);
			}
		}

	}
	//open new Window/tab
	public void openNewWindow(WebElement element) {

		element.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));

	}
	//open URL in a new window
	public void openURLNewWindow(String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" +url+ "')");
		//"window.open('www.google.com')"
	}

	//date function.. provided by java
	public String date() {
		DateFormat df = new  SimpleDateFormat("MM-dd-yy HH.mm.ss");
		Date date = new Date();
		String finaldate =df.format(date);
		return finaldate;

	}
	//take screenshot.. to share document with business when fails we need to take screen shot. 
	//it comes from selenium but we can make it better.
	public void takeScreenShot() { 

		String name = "Screen Shot" + date() +".png";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			File localScreenshot = new File(new File("build"),"Screenshots");

			if(!localScreenshot.exists() || ! localScreenshot.isDirectory()) {
				localScreenshot.mkdirs();
			}

			File Screenshot= new File (localScreenshot,name);
			Files.copy(sourceFile, Screenshot);
		}

		catch(IOException e) {
			System.out.println("Screenshot capture failed");
		}
	}
	//To raed Excel sheet
	public String getDataFromExcelSheet(String path, String sheetName,int rownum,int cellnum ) {

		String data = null;
		try {

			File file = new File(path);
			FileInputStream fs = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet(sheetName);
			data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();

		}
		catch(IOException e) {
			System.out.println("Unable to raed file");
		}

		return data;
	}

	//Action- to handle keyboard and mouse action-
	public Actions action() {

		Actions actions = new Actions(driver);
		return actions;
	}
}