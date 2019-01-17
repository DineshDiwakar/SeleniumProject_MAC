package testRunner;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import businessKeywordLib.FunctionLibrary;
import frameworkUtility.ExcelUtils;


public class TestSuiteRunner {

	public static FunctionLibrary functionLibrary;	
	public static Method method[];		
	public static int TestStep;
	public static int TestLastStep;
	public static String TestCaseID;
	public static String TestScenarioID;
	public static String RunMode;
	public static boolean Result;
	public static String arrActions[];
	public static String Action;
	
	//DataSheet Path
	public static String testDataPath = System.getProperty("user.dir")+"/testData/DataSheet.xls";
	
	//Data Sheet Column Numbers
	public static int Col_TestCaseID = 0;	
	public static int Col_TestScenarioID =1 ;
	public static int Col_PageObject =4 ;
	public static int Col_ActionKeyword =5 ;
	public static int Col_RunMode =2 ;
	public static int Col_Result =3 ;
	public static int Col_DataSet =6 ;
	public static int Col_TestStepResult =7 ;
		
	// Data Engine Excel sheets
	public static String Sheet_TestCases = "Test Cases";
	public static String Sheet_TestSteps = "Keywords";
	
	public TestSuiteRunner() throws NoSuchMethodException, SecurityException{
		functionLibrary = new FunctionLibrary();
		method = functionLibrary.getClass().getMethods();
		
	}
	
	public static void main(String[] args) throws Exception {
		frameworkUtility.ExcelUtils.setExcelFile(testDataPath);
        PrintStream o = new PrintStream(new File("Report.txt"));		 
        System.setOut(o);
		TestSuiteRunner runner = new TestSuiteRunner();
		runner.executeTestCase();	
	}
	
	private void executeTestCase() throws Exception {
    	int TotalTestCases = ExcelUtils.getRowCount(Sheet_TestCases);
		for(int Testcase=1;Testcase<TotalTestCases;Testcase++){
			Result = true;
			TestCaseID = ExcelUtils.getCellData(Testcase, Col_TestCaseID, Sheet_TestCases); 
			TestScenarioID = ExcelUtils.getCellData(Testcase, Col_TestScenarioID, Sheet_TestCases);
			RunMode = ExcelUtils.getCellData(Testcase, Col_RunMode,Sheet_TestCases);
			if (RunMode.equals("Yes")){				
				System.out.println("The test Script "+TestCaseID+" Execution Started");
				TestStep = ExcelUtils.getRowNumber(TestCaseID, Col_TestCaseID, Sheet_TestSteps);
				arrActions = ExcelUtils.getActions(TestStep, Sheet_TestSteps);		
				Result=true;
			
				for(int i=0;i<arrActions.length;i++) {
					Action = arrActions[i];
					execute_Actions();
					if(Result==false){
						ExcelUtils.setCellData("FAIL",Testcase,Col_Result,Sheet_TestCases);
						break;
					}
				}
				if(Result==true){
				ExcelUtils.setCellData("PASS",Testcase,Col_Result,Sheet_TestCases);
				}
				System.out.println("The test Script "+TestCaseID+" Execution Ended");
			}
		}
	}	
     
     private static void execute_Actions() throws Exception {
	
		for(int i=0;i<method.length;i++){
			
			if(method[i].getName().equals(Action)){
				
				method[i].invoke(null);				
			}
		}
    }
}
