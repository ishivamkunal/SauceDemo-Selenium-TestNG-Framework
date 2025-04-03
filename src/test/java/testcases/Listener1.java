package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import resources.ExtentReporter1;
import resources.Utilities;

import java.lang.reflect.Field;

public class Listener1 extends Base implements ITestListener {

    ExtentReports extentReport = ExtentReporter1.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>(); // To manage parallel execution

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        WebDriver driver = null;
        try {
            // Use reflection to get driver from the test class instance
            Object testInstance = result.getInstance();
            Field driverField = testInstance.getClass().getDeclaredField("driver");

            // Make the field accessible (if it's private)
            driverField.setAccessible(true);

            // Get the driver value
            driver = (WebDriver) driverField.get(testInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (driver != null) {
            try {
                String screenshotPath = Utilities.takeScreenshot(driver, result.getMethod().getMethodName());
                extentTest.get().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            extentTest.get().log(Status.WARNING, "WebDriver is null, could not capture screenshot.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }
}