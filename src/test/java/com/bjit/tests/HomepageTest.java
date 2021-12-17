package com.bjit.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bjit.drivers.DriverManager;

public final class HomepageTest extends BaseTest {

	private HomepageTest() {
	}
/*
 * validate whether the title is containing Google Search or google search
 * validate whether title is not null and length of title is greater that 15 and less than 100
 * check for the links in the page--> Testing mini bytes - Youtube
 * number of links displayed exactly 10 or 15
 */
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		
		assertThat(title)
		.as("Object is actually null").isNotNull()
		.as("It dose not contins exact text").containsIgnoringCase("google search")
		.matches("\\w.*"+"Google Search")
		.hasSizeBetween(15,  100);
			
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//*[@id='rso']/div[2]/div/div/div/div[1]/a/h3"));
		
		assertThat(elements)
		.hasSize(10)
		.extracting(WebElement :: getText)
		.contains("Testing Mini Bytes - YouTube");
			
	}
}
