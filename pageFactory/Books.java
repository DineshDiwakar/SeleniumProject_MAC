package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class Books {

	WebDriver driver;
	
	public Books(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH,using="//img[@alt='Books at Amazon']")
	public static WebElement img_BooksatAmazon;
	 
	@FindBy(how=How.XPATH,using="//input[@id='twotabsearchtextbox']")
	public static WebElement txt_SearchBar;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	public static WebElement btn_Search;
	
	@FindBy(how=How.XPATH,using="//li[@id='result_0']//a")
	public static WebElement lnk_FirstResult;
	
	@FindBy(how=How.XPATH,using="//span[@id='productTitle']")
	public static WebElement lbl_BookName;
	
	@FindBy(how=How.XPATH,using="//li[contains(@id,'mediaTab_heading')]/a[contains(@href,'paperback')]")
	public static WebElement lnk_Paperback;
	
	@FindBy(how=How.XPATH,using="//span[@class='a-size-medium a-color-price header-price']")
	public static WebElement lbl_priceBuynew;
	
	@FindBy(how=How.XPATH,using="//span[@class='a-size-medium a-color-secondary header-price']")
	public static WebElement lbl_priceBuyUsed;
	
	@FindBy(how=How.XPATH,using="//li[contains(@id,'mediaTab_heading')]/a[contains(@href,'kindle')]/span/div[2]/span")
	public static WebElement lbl_priceKindle;
}
