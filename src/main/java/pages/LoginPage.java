package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//here class var driveris this.driver is eqial to constructor parameter driver
//we can use this also instead of LoginPage.class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		 
	}
	
	
	/* here @FindBy it self find webelement on webpage
	 * with the given locator and noneed to use finelements by
	 * every thing here and we are storing that element in awebelement
	 */
	//object repository
	@FindBy (id="user-name")
	private WebElement username;
	
	@FindBy (id="password")
	private WebElement password;
	
	@FindBy (id="login-button")
	private WebElement login;
	
	//Respective action methods
	public void enterCredentials(String uName,String pwd) {
		username.sendKeys(uName);
		password.sendKeys(pwd);
		
	}
	public void clickOnLogin() {
		login.click();
	}
	
	

}
