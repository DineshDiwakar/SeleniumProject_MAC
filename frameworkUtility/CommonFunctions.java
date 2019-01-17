package frameworkUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import businessKeywordLib.FunctionLibrary;

public class CommonFunctions {

	static WebDriver driver;
	
	public CommonFunctions(WebDriver driver) {
		CommonFunctions.driver = driver;
	}
	
	public static void click(WebElement Object, String Description) {
		try {
			Object.click();
			System.out.println("Clicked on the Object: "+Description);
		}catch(Exception e) {
			System.out.println("Error: Unable to click on "+Description+" Error is displayed below");
			e.printStackTrace();
		}
	}
	
	public static void hover(WebElement Object, String Description) {
		try {
			Actions action = new Actions(FunctionLibrary.driver);
			action.moveToElement(Object).build().perform();
			System.out.println("Mouse hovered on the Object: "+Description);
		}catch(Exception e) {
			System.out.println("Error: Unable to hover mouse over "+Description+" Error is displayed below");
			e.printStackTrace();
		}
	}
	
	public static void setValue(WebElement Object, String Value, String Description) {
		try {
			Object.sendKeys(Value);
		}catch(Exception e) {
			System.out.println("Error: Unable to set value "+Value+" in textbox "+Description+" Error is displayed below");
			e.printStackTrace();
		}
	}
	
	public static String getValue(WebElement Object) {
		String value = "";
		try {
			value = Object.getText();
			value = value.trim();
		}catch(Exception e) {
			System.out.println("Error: unable to get value from the object");
			e.printStackTrace();
		}
		return value;
	}	
}