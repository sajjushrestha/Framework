/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.ApplyLeave_pageObject;
import reporting.Reporter;
import reporting.Status;
import utility.BaseClass;


/**
 * @author esparja
 *
 */
public class ApplyLeavePage extends BaseClass{
	
	//WebDriver driver;
	
	
	
	
	
	public ApplyLeavePage(WebDriver driver){

	    this.driver = driver;

	}
	
	
	public void applyLeave(String LeaveType,String date,String path) {
		
		try {
		
		
		WebDriverWait wait=new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.leaveModuleBtn)).click();
		 Reporter.report(Status.PASS,"Leave module button is clciked");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.applyLeaveBtn)).click();
		 Reporter.report(Status.PASS,"Apply button is clciked");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.leaveTypedropdown)).click();
		Reporter.report(Status.PASS,"Leave Type dropdown is clicked");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+LeaveType+"']"))).click();
		Reporter.report(Status.PASS,"Leave Type - "+LeaveType+" is selected");
		
		Thread.sleep(3000);

		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.calendarIcon)).click();
		Reporter.report(Status.PASS,"Calendar icon is clicked");
		
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'picker__day')][text()='"+date+"'])[1]"))).click();
		Reporter.report(Status.PASS,"Date is selected");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.attachmentBtn)).sendKeys(path);
		Reporter.report(Status.PASS,"Attachment attached");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.applyBtn)).click();
		Reporter.report(Status.PASS,"Apply button is clicked");
	
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(ApplyLeave_pageObject.okBtn)).click();
		Reporter.report(Status.PASS,"Ok button is clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void myLeave() throws Exception{
		
		try {
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		driver.navigate().refresh();
		
		driver.findElement(ApplyLeave_pageObject.myLeaveBtn).click();
		Reporter.report(Status.PASS,"My Leave button is clicked");

		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ApplyLeave_pageObject.allChkbox)).click();
		Reporter.report(Status.PASS,"All Checkbox  is clicked");
		
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ApplyLeave_pageObject.pendingApprovalChkbox)).click();
		Reporter.report(Status.PASS,"Pending Approval Checkbox is clicked");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.searchBtn)).click();
		Reporter.report(Status.PASS,"Search button is clicked");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public String getStatus() {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(ApplyLeave_pageObject.status));
		System.out.println(driver.findElement(ApplyLeave_pageObject.status).getText());
		
		Reporter.report(Status.PASS,"Status is retrived");
		
		
		 return    driver.findElement(ApplyLeave_pageObject.status).getText();

	}
	
	
	
	
	
	
	}
	

