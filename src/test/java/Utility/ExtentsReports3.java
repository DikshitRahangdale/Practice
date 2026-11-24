package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsReports3 implements ITestListener {
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public ExtentReports extent;

	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter("C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\Test_data\\reports3.html");
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Smoke Testing");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Tester", "Dikshit");
		extent.setSystemInfo("Environment", "Devlopment Server");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Device", "Mobile");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Pass" + result.getName());
		test.assignDevice("Desktops");
		test.assignCategory("Smoke Testing");
		test.assignAuthor("Dikshit R.");
		test.pass("Tets Cases Passed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Fail " + result.getName() + result.getThrowable());
		test.assignDevice("Desktops");
		test.assignCategory("Smoke Testing");
		test.assignAuthor("Dikshit R.");
		test.fail("Tets Cases Failed");

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped " + result.getName());
		test.skip("Test Skipped");
		test.assignAuthor("Nits");
		test.assignDevice("Mobile");
		test.assignCategory("Dependent Methods");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
