package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	//test commit
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");  
    static Date date = new Date();  
    static String newdate=formatter.format(date); 
	
	public static void captureScreenShot(WebDriver driver,String Description){
		
		
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					try {
						 String currentDir = System.getProperty("user.dir");			
			
		FileUtils.copyFile(src, new File(currentDir+"//Screenshot//"+newdate+"//"+Description+""+System.currentTimeMillis()+".png"));
		}
		catch(Exception e)
					{
			System.out.println(e);
					}
					

		}
}
