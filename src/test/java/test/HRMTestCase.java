package test;


import org.testng.annotations.Test;
import reporting.Reporter;
import reporting.Status;
import pages.ApplyLeavePage;
import pages.ExpensePage;
import pages.LoginPage;
import utility.BaseClass;
import utility.ReadExcel;



public class HRMTestCase extends BaseClass{

	//WebDriver driver;
	LoginPage objLogin;
	ApplyLeavePage objLeavePage;
	ExpensePage objExpensePage;
	

	 @Test(dataProvider="userData",dataProviderClass = ReadExcel.class)
	 public void login(String url,String username,String password) {
		 
	  objLogin = new LoginPage(driver);
		
	  driver.get(url);

	    objLogin.loginToHRM(username,password);
	     

	 }

	 @Test(priority=1,dataProvider="applyLeave",dataProviderClass = ReadExcel.class)
	 public void applyLeave(String LeaveType, String date,String FilePath) {

	    objLeavePage=new ApplyLeavePage(driver);
 
	    objLeavePage.applyLeave(LeaveType,date, System.getProperty("user.dir")+"\\src\\test\\resources\\"+FilePath);

	 }

	 @Test(priority=2,enabled=true)
	 public void checkLeave() {

		 try {
	 
	objLeavePage.myLeave();
	
	String Statusues = objLeavePage.getStatus();
	
	if(Statusues.contains("Pending aApproval"))
	{
		Reporter.report(Status.PASS,"Pending Approval Status is displayed");
	}
	
	else
	{
		Reporter.report(Status.FAIL,"Pending Approval Status is not displayed");
	}
	

	
		 }
		 	catch(Exception e)
		 	{
		 		e.printStackTrace();
		 	} 
	 
	 }	 
	 
   
	 @Test(priority=3,dataProvider="expense",dataProviderClass = ReadExcel.class)
	 public void expense(String Currency,String ExpenseType,String PaidBy,String FilePath,String EmpName,String DstName,String Amount) {

		/* String Currency=ExcelUtils.getData("Expenses_Data","Currency");
		 String ExpenseType=ExcelUtils.getData("Expenses_Data","ExpenseType");
		 String PaidBy=ExcelUtils.getData("Expenses_Data","PaidBy");
		 String FilePath=ExcelUtils.getData("Apply_Leave","FilePath");
		 String EmpName=ExcelUtils.getData("Expenses_Data","EmpName");
		 String DstName=ExcelUtils.getData("Expenses_Data","Destination");
		 String Amount=ExcelUtils.getData("Expenses_Data","Amount");*/
		 String currentDir = System.getProperty("user.dir");
	
	objExpensePage=new ExpensePage(driver);
	 
	objExpensePage.empTravelRequest(Currency, ExpenseType, PaidBy,currentDir+"\\src\\test\\resources\\"+FilePath,EmpName,DstName,Amount);
	
		
	 
	 }	 
	 
	
	 
	
	
}