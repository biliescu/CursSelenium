package curs2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");	
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void loginTest() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement usernameField = driver.findElement(By.id("username"));
		//jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:5px solid red;')", usernameField);
		assertTrue(usernameField.isDisplayed());
		usernameField.click();
		usernameField.sendKeys("tomsmith");
		//usernameField.isEnabled();
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.click();
		passwordField.sendKeys("SuperSecretPassword!");
		
		//driver.findElement(By.className("fa fa-2x fa-sign-in")).click();; // 3 valori
		driver.findElement(By.cssSelector(".fa")).click(); // 1 valoare
		WebElement successMsg = driver.findElement(By.id("flash"));
		//assertTrue(successMsg.isDisplayed());
		assertTrue(successMsg.getText().contains("You logged into a secure area!"));
		
		
	}
}
