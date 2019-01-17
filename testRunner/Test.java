package testRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	public static void main(String[] args) {
			System.out.println("********** Beginning of 'invoke' function **********");
			//Get data from data sheet
			String URL ="https://www.google.com";
			//initialize chrome driver  
			WebDriver driver;
			driver = new ChromeDriver();
			//Set implicit wait as 10 seconds
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Navigate to the specified URL
			driver.get(URL);
			System.out.println("Navigating to :"+URL);
			//Maximize the window
			driver.manage().window().maximize();
			System.out.println("Maximizing the Window");
			
			driver.quit();
			
			
			System.out.println("********** End of 'invoke' function **********");
	}
}
