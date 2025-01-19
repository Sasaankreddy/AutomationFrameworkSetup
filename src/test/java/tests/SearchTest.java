package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends TestBase{

	public SearchTest() {
		super();
	}
	public WebDriver driver;
	SearchPage search;
	LoginPage login;
	@BeforeClass
	public void setUp() {

		driver=initializeBrowser(prop.getProperty("browser"));

	}
	@AfterClass
	public void tearDown() {
		driver.quit();

	}



	@Test(priority=1)
	public void addTocart() {
		login=new LoginPage(driver);
		search=new SearchPage(driver);
		login.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
		login.clickOnLogin();
		search=new SearchPage(driver);
		search.clickOnAddToCart();



	}
	@Test(priority=2)
	public void remove() {
		search=new SearchPage(driver);
		search.clickOnRemove();

	}
}
