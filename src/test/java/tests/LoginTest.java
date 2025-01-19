package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.TestUtil;


public class LoginTest extends TestBase{
	public LoginTest() {
		super();
	}
	public WebDriver driver;
	LoginPage login;
	@BeforeMethod
	public void setUp() {

		driver=initializeBrowser(prop.getProperty("browser"));

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	//here while using excel in sheet name must be passed as test name
	@Test(dataProviderClass=TestUtil.class,dataProvider="testdata")
	public void loginTest(String username,String password) {
		login=new LoginPage(driver);
		login.enterCredentials(username, password);
		login.clickOnLogin();


		//String Act=driver.findElement(By.xpath("//*[@class='header_label']//*[text()='Swag Labs']")).getText();
		//Assert.assertEquals(Act,"Swag Labs");

	

	}
	/*above instead of method name m and otherstuff simply we use below way
	 we can create method here and simply call that method that is another way
	 public object[][]supplyTestdata(){
	 object[][] data=TestUtil.getData("Sheetname here");
	 return data;
	/*@Test(priority=1)
	public void verifyWithInValidUsername() {


		driver.findElement(By.id("user-name")).sendKeys(invalidProp.getProperty("invalidUserName"));
		driver.findElement(By.id("password")).sendKeys(invalidProp.getProperty("invalidPassword"));
		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority=2)
	public void verifyWithInValidPassword() {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_saucee");
		driver.findElement(By.id("login-button")).click();

	}*/

}
