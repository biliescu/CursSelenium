package curs2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class TemaCurs2 extends BaseTest {

	@Test
	public void checkIfElementsAreDisplayed() {

		WebElement loginButton = driver
				.findElement(By.cssSelector("a[class*='popup_link popup_login_link icon-user inited']"));
		WebElement userNameField = driver.findElement(By.id("log"));
		WebElement passwordField = driver.findElement(By.id("password"));
		assertTrue(loginButton.isDisplayed(), "Login button is displayed on web page");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(!userNameField.isDisplayed(), "Username field is still NOT displayed");
		sa.assertTrue(!passwordField.isDisplayed(), "Password field is still NOT displayed");
		loginButton.click();
		sa.assertTrue(userNameField.isDisplayed(), "Username field is now displayed");
		sa.assertTrue(passwordField.isDisplayed(), "Password field is now displayed");
		

	}

}
