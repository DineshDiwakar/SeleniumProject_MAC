package frameworkUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import testRunner.TestSuiteRunner;

public class ExcelUtils {
	//private static XSSFSheet ExcelWSheet;
	//private static XSSFWorkbook ExcelWBook;
	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static org.apache.poi.ss.usermodel.Cell Cell;
	private static HSSFRow Row;
	
    public static void setExcelFile(String Path) throws Exception {
    	try {
            FileInputStream ExcelFile = new FileInputStream(Path);
            ExcelWBook = new HSSFWorkbook(ExcelFile);
    	} catch (Exception e){
    		TestSuiteRunner.Result = false;
    	}
    }
    
	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception{
        try{
        	ExcelWSheet = ExcelWBook.getSheet(SheetName);
          	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
          	String CellData = Cell.getStringCellValue();
          	return CellData;
         }catch (Exception e){
            TestSuiteRunner.Result = false;
            return"";
        }
    }
	
	public static String getdata(String SheetName, String ColumnName) throws Exception{
        String value = "";
		try{        	
        	ExcelWSheet = ExcelWBook.getSheet(SheetName);
        	int rowNumber = 0, columnNumber = 0;
        	int rowCount, columnCount;
        	columnCount = ExcelWSheet.getRow(0).getLastCellNum();
        	for(int i =1;i<columnCount;i++) {
        		if(getCellData(0,i,SheetName).equals(ColumnName)) {
        			columnNumber = i;
        			break;
        		}
        	}

        	rowCount = ExcelUtils.getRowCount(SheetName);
        	for(int i =0;i<rowCount;i++) {
        		if(getCellData(i,0,SheetName).equals(TestSuiteRunner.TestCaseID)) {
        			rowNumber = i;
        			break;
        		}
        	}
        	
        	value = getCellData(rowNumber, columnNumber, SheetName);
        	
         }catch (Exception e){
            TestSuiteRunner.Result = false;            
        }
		return value;
    }
            	
    public static int getRowCount(String SheetName){
    	int iNumber=0;
    	try {
    			ExcelWSheet = ExcelWBook.getSheet(SheetName);
    			iNumber=ExcelWSheet.getLastRowNum()+1;
    	} catch (Exception e){
    			TestSuiteRunner.Result = false;
    	}
    	return iNumber;
    }
    	
	public static int getRowNumber(String sTestCaseName, int colNum,String SheetName) throws Exception{
		int iRowNum=0;	
		try {
		    //ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelUtils.getRowCount(SheetName);
			for (; iRowNum<rowCount; iRowNum++){
				if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}       			
		} catch (Exception e){
			TestSuiteRunner.Result = false;
		}
		return iRowNum;
	}
	
	public static String[] getActions(int rowNum,String SheetName) throws Exception{
		int noOfColumns=0;
		String[] Actions = new String[noOfColumns];
		try {
			noOfColumns = ExcelWSheet.getRow(rowNum).getLastCellNum();			
			Actions = new String[noOfColumns];
			
			for (int i=0;i<noOfColumns;i++){
				Actions[i] = ExcelWSheet.getRow(rowNum).getCell(i+1).getStringCellValue();
            }			
		} catch (Exception e){
			TestSuiteRunner.Result = false;
		}		
		return Actions;
	}
		
	public static void setCellData(String Result, int RowNum, int ColNum, String SheetName) throws Exception {
       try{        	   
    	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
           Row  = ExcelWSheet.getRow(RowNum);
           Cell = Row.getCell(ColNum);
           if (Cell == null) {
        	   Cell = Row.createCell(ColNum);
        	   Cell.setCellValue(Result);
           } else {
            	Cell.setCellValue(Result);
           }
           FileOutputStream fileOut = new FileOutputStream(TestSuiteRunner.testDataPath);
           ExcelWBook.write(fileOut);
           //fileOut.flush();
           fileOut.close();
           ExcelWBook = new HSSFWorkbook(new FileInputStream(TestSuiteRunner.testDataPath));
        }catch(Exception e){
        	TestSuiteRunner.Result = false;          
        }
    }
}