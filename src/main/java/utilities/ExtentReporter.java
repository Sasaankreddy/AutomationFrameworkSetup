package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport=new ExtentReports();
		//we have different types of extent repots spark report is free version
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReport=new ExtentSparkReporter(extentReportFile);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Mt test Automation results");
		sparkReport.config().setDocumentTitle("Automation title");
		sparkReport.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReport);
		Properties configProp=new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(configPropFile);
		configProp.load(fis);
		}catch(Exception e) {
		e.printStackTrace()	;
		}
		//the below statements will print all these details like browsername username etc
		extentReport.setSystemInfo("Application URL",configProp.getProperty("testurl"));
		
		extentReport.setSystemInfo("browser Name",configProp.getProperty("browser"));
		extentReport.setSystemInfo("USERNAME",configProp.getProperty("username"));
		extentReport.setSystemInfo("PASSWORD",configProp.getProperty("password"));
	/* we can print java version and os details also
	 * for that create seperate package like experiments and create class as demo with main method
	 * write code in main mathod
	 * we can igonere this statement System.getProperties().list(System.out);
	 * System.out.println(System.getProperty("os.name"));
	 * System.out.println(System.getProperty("user.name"));
	 * System.out.println(System.getProperty("java.version"));
	 * 
	 * run it as java application thyen it will show all the details 
	 * 
	 * 
	 */
	//extentReport.setSystemInfo("Operating System",System.getProperty("os.name") );
	
	
		return extentReport;
		
	}

}
