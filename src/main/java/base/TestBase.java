package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestUtil;

public class TestBase {

	WebDriver driver;
	public Properties prop;
	//public Properties invalidProp;

	public  TestBase() {
		prop=new Properties();

		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(propFile);
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/* if we want to use another config file we have to again use same below process
		 * 
		 */
		/*invalidProp=new Properties();

		File invalidpropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\invaliddata.properties");
		try {	
			FileInputStream fis2=new FileInputStream(invalidpropFile);
			invalidProp.load(fis2);
		}catch(Exception e) {
			e.printStackTrace();
		}*/


	}
	public WebDriver initializeBrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("testurl"));	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_TIME));	
		return driver;
	}






}
