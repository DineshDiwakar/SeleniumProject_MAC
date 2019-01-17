# SeleniumProject
I have designed the framework using Java language.
I choose not to use any of the existing frameworks since i took it as a challenge to create a fully functional framework from scratch.(Purely for learning purpose).
The script is designed to run using Chrome browser.(although it can run using any of the other browsers with very little configuration)
The reporting feature is a little basic.(due to time constraint)

Steps to follow to run the scripts:
* Pull the code to your local machine with the IDE of your choice(I prefer Eclipse)
* Make sure you have the latest version Chrome browser installed in your machine.
* Open the file "TestSuiteRunner" within the "testRunner" package
* Run the file "TestSuiteRunner" as "Java Application"

Contents of the Framework:
* The "FunctionLibrary" file within the "businessKeywordLib" package contains all the Keywords
* The "CommonFunctions" file within the "frameworkUtility" contains all the reusable functions for actions such as click,type.
* The "ExcelUtils" file within the "frameworkUtility" contains all the functions for working with the Test Data (Excel) File.
* The "pageFactory" package contains all the objects segregated in seperate java files based on the screen.
* The "supportLibs" package contains all the required jars and libs.
* The "testData" package contains the "DataSheet" excel file which is used to execute the test case and provide data.
* The "testRunner" package contains the "TestSuiteRunner" file which drives the script execution.
* The "ChromeDriver.exe" is present the project folder.
* After execution the "Report" text file is created which contains the Test Results
