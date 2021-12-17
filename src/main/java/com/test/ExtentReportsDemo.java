package com.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {

	@Test
	public void test1() throws IOException{
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		reports.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Selenium Automation Training");
		
		ExtentTest test = reports.createTest("First Test");
		test.pass("Checking the log for First test");
		
		ExtentTest test1 = reports.createTest("Second Test");
		test1.fail("Checking the log for Second test");
		
		reports.flush();

		ChromeDriver driver = new ChromeDriver();
		driver.getTitle();

		Capabilities cap = new DesiredCapabilities();
		
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
}
