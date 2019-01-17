package businessKeywordLib;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import frameworkUtility.CommonFunctions;
import frameworkUtility.ExcelUtils;
import pageFactory.Books;
import pageFactory.HomePage;

public class FunctionLibrary {
	//Initializing webDriver interface
	public static WebDriver driver;
	//Initializing explicit wait with condition as 30 seconds 

	public static void invoke() {
		try {
			System.out.println("********** Beginning of 'invoke' function **********");
			//Get data from data sheet
			String URL = ExcelUtils.getdata("Login", "URL");			
			//initialize chrome driver  
			driver = new ChromeDriver();
			//driver = new FirefoxDriver();
			//Set implicit wait as 10 seconds
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Navigate to the specified URL
			driver.get(URL);
			System.out.println("Navigating to :"+URL);
			//Maximize the window
			driver.manage().window().maximize();
			System.out.println("Maximizing the Window");
			System.out.println("********** End of 'invoke' function **********");
		} catch (Exception e) {
			System.out.println("Exception occured in 'invoke' function");
			e.printStackTrace();
		}				
	}

	public static void navigatetoBooksPage() {
		try {
			System.out.println("********** Beginning of 'navigatetoBooksPage' function **********");
			// initializing the webElements in the pageFactory
			PageFactory.initElements(driver, HomePage.class);
			WebDriverWait wait = new WebDriverWait(driver,30);
			//Wait for the page to load
			wait.until(ExpectedConditions.visibilityOf(HomePage.lnk_Departments));
			//Perform hover action
			CommonFunctions.hover(HomePage.lnk_Departments, "Departments");
			//Wait for the element to be visible
			wait.until(ExpectedConditions.visibilityOf(HomePage.lnk_Books));
			//Perform hover action
			CommonFunctions.hover(HomePage.lnk_Books, "Books & Audible");
			//Wait for the element to be visible
			wait.until(ExpectedConditions.visibilityOf(HomePage.lnk_Books));
			//Perform click action
			CommonFunctions.click(HomePage.lnk_Books, "Books");
			
			System.out.println("********** End of 'navigatetoBooksPage' function **********");
		} catch (Exception e) {
			System.out.println("Exception occured in 'invoke' function");
			e.printStackTrace();
		}	
	}
	
	public static void searchForBook() {
		try {
			System.out.println("********** Beginning of 'searchForBook' function **********");
			WebDriverWait wait = new WebDriverWait(driver,30);
			// initializing the webElements in the pageFactory
			PageFactory.initElements(driver, Books.class);			
			//Get data from data sheet
			String SearchText = ExcelUtils.getdata("Books", "SearchText");			
			//Wait for the page to load
			wait.until(ExpectedConditions.visibilityOf(Books.img_BooksatAmazon));
			//Input value in Search Bar
			CommonFunctions.setValue(Books.txt_SearchBar, SearchText, "Search Bar");
			//Click on search button
			CommonFunctions.click(Books.btn_Search, "Search Bar");
			System.out.println("********** End of 'searchForBook' function **********");
		} catch (Exception e) {
			System.out.println("Exception occured in 'searchForBook' function");
			e.printStackTrace();
		}
	}
	
	public static void getBookDetails() {
		try {
			System.out.println("********** Beginning of 'getBookDetails' function **********");
			WebDriverWait wait = new WebDriverWait(driver,30);
			// initializing the webElements in the pageFactory
			PageFactory.initElements(driver, Books.class);
			//Wait for the page to load
			wait.until(ExpectedConditions.visibilityOf(Books.lnk_FirstResult));
			//Click on first link
			CommonFunctions.click(Books.lnk_FirstResult, "First link in the Book result page");
			//Wait for the page to load
			wait.until(ExpectedConditions.visibilityOf(Books.lbl_BookName));
			//Click on paperback link
			CommonFunctions.click(Books.lnk_Paperback, "Paperback link in the Book details page");
			
			String bookName = CommonFunctions.getValue(Books.lbl_BookName);
			String newPrice = CommonFunctions.getValue(Books.lbl_priceBuynew);
			String userPrice = CommonFunctions.getValue(Books.lbl_priceBuyUsed);
			String kindlePrice = CommonFunctions.getValue(Books.lbl_priceKindle);
			
			System.out.println("name of the book is : "+bookName);
			System.out.println("The price of new book is : "+newPrice);
			System.out.println("The price of old book is : "+userPrice);
			System.out.println("The price of kindle edition is : "+kindlePrice);
			
			System.out.println("********** End of 'getBookDetails' function **********");
		} catch (Exception e) {
			System.out.println("Exception occured in 'getBookDetails' function");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
	}

	
	public static void logout() {
		System.out.println("********** Beginning of 'logout' function **********");
		driver.quit();
		System.out.println("Closed the Browser");
		System.out.println("********** End of 'logout' function **********");
	}
}
