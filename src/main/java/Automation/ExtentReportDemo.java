package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;

	@BeforeTest
	public void config() {
		// ExtentReports, ExtentSparkReporter
		// creates reports
		String filePath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(filePath);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("Test Results");

		// attach created report to main calss responsible to create and consolidate all
		// testcase execution
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Tamil");

	}

	@Test
	public void initialDemo() {
		ExtentTest test1 =  extent.createTest("Test Extent Reports 1");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
		
		ExtentTest test2 =  extent.createTest("Test Extent Reports 2");
		System.out.println(driver.getTitle());
		test2.fail("Failed Test case do not match");
		extent.flush();
		driver.close();
	}

}
