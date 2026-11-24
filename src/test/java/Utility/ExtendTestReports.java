package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtendTestReports implements ITestListener {

	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//testexcuationReports.html");
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Automation Testing");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Environment Name", "QA Server");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("OS", "Window 10");
		extent.setSystemInfo("Release Version", "V1.2.3");
		extent.setSystemInfo("Device", "Lenovo ThinkPad");
		extent.setSystemInfo("QA Name", "Dikshit Rahangdale");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.pass("Test Case Pass");
		test.assignCategory("Pass Test Cases");
		test.assignAuthor("Dikshit Rahangdale");
		test.assignDevice("Lenovo ThinkPad");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.fail("Test Case Fail");
		test.warning("Warning:-->" + result.getThrowable());
		test.assignCategory("Failed Test cases");
		test.assignAuthor("Dikshit Rahangdale");
		test.assignDevice("Lenovo ThinkPad");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.skip("Test Skipp");
		test.log(Status.SKIP, "Test Skipped" + result.getThrowable());
		test.assignCategory("Skipp Test Cases");
		test.assignAuthor("Dikshit Rahangdale");
		test.assignDevice("Lenovo ThinkPad");

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
