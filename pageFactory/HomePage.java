package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	 @FindBy(how=How.XPATH,using="//span[text()='Amazon']")
	 public static WebElement lnk_Amazon;
	 
	 @FindBy(how=How.XPATH,using="//span[text()='Departments']")
	 public static WebElement lnk_Departments;
	 
	 @FindBy(how=How.XPATH,using="//span[text()='Books & Audible']")
	 public static WebElement lnk_Books_Audible;
	 
	 @FindBy(how=How.LINK_TEXT,using="Books")
	 public static WebElement lnk_Books;
	
}
