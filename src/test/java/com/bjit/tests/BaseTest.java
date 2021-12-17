package com.bjit.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bjit.drivers.Driver;

import java.lang.reflect.Method;
import java.util.Map;

public class BaseTest {

	protected BaseTest() {
	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) throws Exception{
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quiteDriver();
	}
}
