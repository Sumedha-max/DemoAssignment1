package com.springer.app;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Search {
	
	@Test
	public void SearchFunc() {
		
		String driverPath = "/Users/idq5414/Downloads/chromedriver";
		String parentUrl = "https://link.springer.com/";
		String searchKey = "science";
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		
		//trigger landing page
		driver.get(parentUrl);
		
		//check if search functionality field is loaded
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-field")));
		
		//try searching
		driver.findElement(By.id("query")).click();
		driver.findElement(By.id("query")).sendKeys(searchKey);
		driver.findElement(By.id("search")).click();
		
		
		//wait for search results to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number-of-search-results-and-search-terms")));
		
		//fetch search results in a list
		List<WebElement> searchResultList = driver.findElements(By.className("lozenges"));
		
		System.out.println(searchResultList.size());
		Assert.assertTrue(searchResultList.size()>=1);
		
		
	}

}
