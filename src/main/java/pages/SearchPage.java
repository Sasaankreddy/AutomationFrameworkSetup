package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		 
	}
	
	
	@FindBy (xpath="//*[contains(@id,'sauce-labs-backpack')]")
	private WebElement addProduct;
	
	@FindBy (xpath="//*[contains(@id,'sauce-labs-backpack')]")
	private WebElement remove;
	
	
	
	public void clickOnAddToCart() {
		addProduct.click();
		
	}
	
	public void clickOnRemove() {
		
		
	}
	
}
