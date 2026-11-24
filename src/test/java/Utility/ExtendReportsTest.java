package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportsTest implements ITestListener {
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//htmlReposrt.html");
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Automation Tessting");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Environment", "QA Testing");
		extent.setSystemInfo("Version", "1.2.3");
		extent.setSystemInfo("QA Name", "Dikshit Rahangdale");

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.pass("Test Cases Pass");
		test.assignAuthor("Diskhit R.");
		test.assignCategory("Smoke Testing");
		test.assignDevice("Macbook Neo");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.fail("Test Case Fail");
		test.warning(result.getThrowable().toString());
		test.assignCategory("Test Case Fail");
		test.assignAuthor("Dikshit R.");
		test.assignDevice("Macbook Neo");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.skip("Test Case Skipped");
		test.warning(result.getThrowable().toString());
		test.assignAuthor("Diskhit R");
		test.assignCategory("Test Case Skipped");
		test.assignDevice("Macbook Neo");

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
