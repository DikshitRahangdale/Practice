package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;

public class ExtentReportsManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\Test_data\\Repeosrt.html");
		sparkReporter.config().setDocumentTitle("Automation Testing");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports(); 
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester NAme", "Dikshit");
		extent.setSystemInfo("Testing Server", "Release server");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Cases Passed: " + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
		test.skip("Skip");
		test.assignAuthor("Dikshit");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed: " + result.getName());
		test.log(Status.FAIL, "Test Case Failed Cause is: " + result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
