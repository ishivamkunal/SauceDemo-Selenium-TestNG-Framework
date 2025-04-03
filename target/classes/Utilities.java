package resources;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

	public static String takeScreenshot(WebDriver driver, String testName) {
	    String screenshotDir = "screenshots/";
	    File directory = new File(screenshotDir);
	    
	    // Create directory if it doesn't exist
	    if (!directory.exists()) {
	        directory.mkdirs();
	    }

	    String screenshotPath = screenshotDir + testName + ".png";
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File destFile = new File(screenshotPath);
	    
	    try {
	        FileUtils.copyFile(srcFile, destFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return screenshotPath;
	}
}