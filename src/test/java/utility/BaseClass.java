package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import reporting.Reporter;

public class BaseClass {
	
	protected static WebDriver driver;

@BeforeSuite

public void cleanUp()
{
	File file=new File(".\\screenshots\\");
	if(file.exists())
	{
		try {
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}
}

	@BeforeClass
	
	public void setUp()
	{
		 System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		 ChromeOptions option=new ChromeOptions();
		 //option.addArguments("--headless");
		 
		 
		 driver = new ChromeDriver(option); 
	
		 driver.manage().window().maximize();
		 
		
		 
		 Reporter.initialize();
		 
	}
	
 @AfterClass
	 
	 public void close() {
		 String currentDir = System.getProperty("user.dir");
		
		 Reporter.writeResults();
		 
		 //commented the below line after jenkins integeration
		// driver.get(currentDir+"\\report.html");
	 }
	 
}
