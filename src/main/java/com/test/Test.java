package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Test {
	private Test() {
	}
	
	public void test(){
		
	}
	
	public void tes(){
		WebElement element = null;
		Select sl =new Select(element);
		
	}

	// public static String getValue(String key) throws Exception {
	// if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
	// throw new Exception("Property name " + key + " is not found. please check
	// the config.properties file");
	// }
	// return property.getProperty(key);
	// }

	// wait.until(driver->driver.findElement(link_logout)).isEnabled(); Java 8
	// way
	// Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS); related to wait
	
	//property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()))); it is related to property file
}
