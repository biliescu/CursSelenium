package curs2;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindElementExample extends BaseTest{
	
	@Test
	public void findElementsExample1() throws InterruptedException {
		List<WebElement> booksPictures = driver.findElements(By.cssSelector("figure[class*='sc-image']"));		
		for (WebElement picture : booksPictures) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:5px solid red;')", picture);
			Thread.sleep(3000);
		}
		
	}
	
	@Test(priority=1)
	public void findElementsExample(){
	    List<WebElement> bookList = driver.findElements(By.cssSelector("h3[class*='sc_title']"));
	    int size = bookList.size();
	    System.out.println(size);
	    bookList.get(2).click();
	    
	    String expectedUrl = "https://keybooks.ro/shop/life-in-the-garden/";
	    assertEquals(driver.getCurrentUrl(), expectedUrl);
	    
	    String pageTitle = driver.getTitle();
	    assertEquals(pageTitle, "Life in the garden – Booklovers");
	    
	    WebElement bookTitle = driver.findElement(By.cssSelector("h1[class*='product_title']"));
	    assertEquals(bookTitle.getText(), "Life in the garden");
	    
	}

}
