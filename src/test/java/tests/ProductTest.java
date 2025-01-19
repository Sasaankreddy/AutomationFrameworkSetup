package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductTest {
WebDriver driver;
	@Test(priority=1)
	public void addTocart() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.findElement(By.xpath("//*[contains(@id,'sauce-labs-backpack')]")).click();
		driver.quit();
		
	}
	@Test(priority=1)
	public void remove() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.findElement(By.xpath("//*[contains(@id,'sauce-labs-backpack')]")).click();
		
		driver.quit();
	}
}
