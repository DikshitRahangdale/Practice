package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportes2 implements ITestListener {

	public ExtentSparkReporter spark;
	public ExtentTest test;
	public ExtentReports extent;

	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\Test_data\\testRepeorts2.html");
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Smoke Testing");
		spark.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Testing Type", "Smoke Testing");
		extent.setSystemInfo("Testing Server", "PreProducation");
		extent.setSystemInfo("Testing device", "Laptop");
		extent.setSystemInfo("Browsers", "Chrome");
		extent.setSystemInfo("QA Name", "Dikshit R");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName() + "Verify Login");
		test.log(Status.PASS, "Test Case Pass: " + result.getName());
		test.pass("Test Case Pass");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed: " + result.getName() + " " + result.getThrowable());
		test.fail("Test Failed "+result.getName());
		test.warning("Test Case Failes pls Chekc Manually");
		test.assignAuthor("Dikshit R");
		test.addScreenCaptureFromPath("C:\\Users\\ADMIN\\Pictures\\Screenshots\\screenshot1.png");
		

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped " + result.getName());
		test.skip("Test Casse Skip");
		test.info("Test Case Skip bc this Test case may be depends on ANother ");
		test.assignCategory("Dependent Methods");
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
