package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReporter;
/* here ITestListener is an interface which contains um implemented method so we
 * we have to implement them
 * if we trying to import thid ITestListeber interface it wont show us TestNG import bz
 * in pom.XML the scope will be test level we have to change that as compile then it
 * will apply entire project and we can use TestNG libraries entire project
 */
public class Mylisteners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	
/* for to override unimplemented methods simply select ItestListeners
 * click on sourse ment>select override implemented method
 * select what are the methods you required
 * 
 */
//here we have to use extentreports in listeners	
public void onStart(ITestContext context) {
	
	extentReport=ExtentReporter.generateExtentReport();
	
	
	
	}
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		//it will give name of the test whis is started
		 extentTest=extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+" started executing");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.PASS,testName+" got successfully Executed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		String testName=result.getName();
		
		
		 try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		
		
		System.out.println(result.getThrowable());
		extentTest.log(Status.FAIL,testName+" got failed");
		//above statement will priont all exception detalis for the failure
	}

	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		
		System.out.println(testName+   "Skipped test");
		System.out.println(result.getThrowable());
		extentTest.log(Status.SKIP,testName+" got skipped");
	}

	

	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
	

}
