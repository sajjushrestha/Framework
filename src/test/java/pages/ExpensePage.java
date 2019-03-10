/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.ExpensePage_pageObject;
import reporting.Reporter;
import utility.BaseClass;


/**
 * @author esparja
 *
 */
public class ExpensePage extends BaseClass{
	
	//WebDriver driver;
	
	
	
	public ExpensePage(WebDriver driver){

	    this.driver = driver;

	}
	
	
	public void empTravelRequest(String currency,String expenseType,String padiBy,String path,String EmpName,String Destination,String Amount){
		
		try {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		driver.navigate().refresh();

		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.expenseModuleBtn)).click();
		 Reporter.report("PASS","Expenses module button is clicked");
		 
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.travelRequestBtn)).click();
		Reporter.report("PASS","Travel Request button is clicked");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.empTravelReqBtn)).click();
		Reporter.report("PASS","Employee Request button is clicked");
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ExpensePage_pageObject.frame));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.addBtn)).click();
		Reporter.report("PASS","Add button is clicked");
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.currencydropdown)).click();
		Reporter.report("PASS","Currency dropdown is clicked");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+currency+"']"))).click();
		Reporter.report("PASS","Currency "+currency+" is selected");
		
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.empNameTxt)).sendKeys(EmpName,Keys.ENTER);
		Reporter.report("PASS","Employee name :"+EmpName+" is entered");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.nextBtn)).click();
		Reporter.report("PASS","Next button is clicked");
		
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExpensePage_pageObject.travelInfoAddBtn)).click();
		Reporter.report("PASS","Travel Info Add button button  is clicked");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.mainDstTxt)).sendKeys(Destination,Keys.ENTER);
		Reporter.report("PASS","Destination :"+Destination+" is entered");
		
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExpensePage_pageObject.travelInfoSaveBtn)).click();
		Reporter.report("PASS","Travel Info Save button button  is clicked");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExpensePage_pageObject.travelReqAddBtn)).click();
		Reporter.report("PASS","Travel Request Add button is clicked");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.expenseTypedropdown)).click();
		Reporter.report("PASS","Expense Typedropdown  is clicked");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+expenseType+"']"))).click();
		Reporter.report("PASS","Expense Type :"+expenseType+"  is selected");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.paidBydropdown)).click();
		Reporter.report("PASS","Paid By dropdown is clicked");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+padiBy+"']"))).click();
		Reporter.report("PASS","Paid By :"+padiBy+"  is selected");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.currencyPaidIndropdown)).click();
		Reporter.report("PASS","Currency dropdown is clicked");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+currency+"']"))).click();	
		Reporter.report("PASS","Currency :"+currency+"  is selected");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.amountTxt)).sendKeys(Amount);
		Reporter.report("PASS","Amount :"+Amount+" is entered");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.formsaveBtn)).click();	
		Reporter.report("PASS","Save button is clicked");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.travelReqsaveBtn)).click();	
		Reporter.report("PASS","Travel Request Save button is clicked");
		
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.travelReqaddBtn)).click();
		Reporter.report("PASS","Travel Request Add button is clicked");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.attachBtn)).sendKeys(path);
		Reporter.report("PASS","Attachment added");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.uploadBtn)).click();
		Reporter.report("PASS","Upload button is clicked");
		
		Thread.sleep(1000);
	
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.assignBtn)).click();
		Reporter.report("PASS","Assign button  is clicked");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ExpensePage_pageObject.confirmSaveBtn)).click();
		
		Reporter.report("PASS","Confirm button  is clicked");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	


	
	
	
	
	
	}
	

