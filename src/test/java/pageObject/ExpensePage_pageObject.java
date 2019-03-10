package pageObject;

import org.openqa.selenium.By;

public class ExpensePage_pageObject {

	
	public static  By expenseModuleBtn = By.id("menu_expense_viewExpenseModule");
	public static  By travelRequestBtn = By.id("menu_expense_TravelRequests");
	
	public static  By empTravelReqBtn = By.id("menu_expense_viewEmployeeEstimateRequest");
	public static  By addBtn = By.xpath(".//*[text()='add']");
	
	public static  By currencydropdown = By.xpath("//input[contains(@value,'Select')]");
	
	
	public static  By empNameTxt = By.id("ExpenseEstimate_empName_empName");
	public static  By nextBtn = By.id("btnSave");
	
	public static  By travelInfoAddBtn = By.id("addTravelInformationBtn");
	public static  By travelReqAddBtn = By.id("addExpenseTypeBtn");
	public static  By mainDstTxt = By.id("TravelInformation_main_destination");
	public static  By travelInfoSaveBtn = By.id("travelInformationSave");
	
	
	public static  By expenseTypedropdown = By.xpath("//*[text()='Expense Types']//following::input[@class='select-dropdown']");
	public static  By currencyPaidIndropdown = By.xpath("//*[text()='Currency Paid In']//following::input[@class='select-dropdown']");
	public static  By paidBydropdown = By.xpath("//*[@id='estimation_currency_id']//following::input[@class='select-dropdown']");
	

	public static  By amountTxt = By.id("estimation_amount");
	
	public static  By formsaveBtn = By.id("formSave");
	public static  By travelReqsaveBtn = By.id("btnSave");
	
	public static  By travelReqaddBtn = By.id("addExpenseAttachmentBtn");
	public static  By attachBtn = By.id("ESTIMATE_ufile");
	public static  By uploadBtn = By.id("ESTIMATE_btnSaveAttachment");
	
	public static  By assignBtn = By.id("btnAssign");
	public static  By confirmSaveBtn = By.id("submitConfirmationSaveBtn");
	
	
	
	public static  By frame = By.id("noncoreIframe");
}
