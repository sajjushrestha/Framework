package reporting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utility.BaseClass;

public class Reporter extends BaseClass {
	
	private static List<Result> details;
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = ".\\src\\test\\resources\\ReportTemplate\\report_template.html";
	private static final Boolean includeScreenshots = true;
	private static final String screenshotPath = ".\\screenshots\\";
			
	public Reporter() {
	}
	
	public static void initialize() {
		details = new ArrayList<Result>();
	}
	
	public static void report(String actualValue,String Description) {
		String screenshotPath = "";
		try
		{	
			Thread.sleep(1000);
			if(includeScreenshots) {
				screenshotPath = getScreenshot(driver);
			}
			
			Result r = new Result(actualValue,Description,screenshotPath);
			details.add(r);
		} 
		
		catch(Exception e)
		{

			if(includeScreenshots) {
				screenshotPath = getScreenshot(driver);
			}
			Result r = new Result("FAIL",Description,screenshotPath);
			details.add(r);
		}
	}
	
	public static void showResults() {
		for (int i = 0;i < details.size();i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}
	
	private static String getScreenshot(WebDriver driver) {

		// generate screenshot as a file object
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String currentDateTime = getCurrentDate();
		String location = screenshotPath + currentDateTime + ".png";
		
		try {
			// copy file object to designated location
			FileUtils.copyFile(scrFile, new File(location));
		} catch (IOException e) {
			System.out.println("Error while generating screenshot:\n" + e.toString());
		}
		
		return location.replace("\\","\\\\");
	}
	
	private static String getCurrentDate() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(cal.getTime());
	}
	
	public static void writeResults() {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));

			
			for (int i = 0; i < details.size();i++) {
				if(details.get(i).getResultScreenshot().equals("")) {
					reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td><td></td></tr>" + resultPlaceholder);
				} else {
					reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResultText() + "</td><td  class='result'>" + details.get(i).getResult() + "</td><td><a href=\"" + new File(details.get(i).getResultScreenshot()).toURI().toURL() + "\">screenshot</a></td></tr>" + resultPlaceholder);
				}
				
			}
			
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String reportPath = ".\\report.html";
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
}