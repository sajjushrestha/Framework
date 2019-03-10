package pageObject;

import org.openqa.selenium.By;

public class ApplyLeave_pageObject {

	
	
	public static  By leaveModuleBtn = By.id("menu_leave_viewLeaveModule");
	public static  By applyLeaveBtn = By.id("menu_leave_applyLeave");
	
	public static  By leaveTypedropdown = By.xpath("//*[text()='Expense Types']//following::input[@class='select-dropdown']");
	public static  By fromTxt = By.id("from");
	public static  By toTxt = By.id("to");
	public static  By attachmentBtn = By.id("attachment");
	public static  By calendarIcon = By.xpath("//*[text()='To Date']//preceding::div[@class='picker']/following-sibling::i");
	
	public static  By calendarIconMyLeave = By.xpath("//label[text()='To']//preceding::i[text()='date_range']");
	
	
	public static  By applyBtn = By.xpath("//button[text()='Apply']");
	public static  By okBtn = By.xpath("//a[contains(@class,'primary-btn')]");
	public static  By myLeaveBtn = By.xpath("//span[text()='My Leave']");
	public static  By allChkbox = By.xpath("//label[text()='All']");
	public static  By pendingApprovalChkbox = By.xpath("//label[text()='Pending Approval']");
	public static  By searchBtn = By.xpath("//button[text()='Search']");
	
	public static  By status = By.xpath("//table[@class='highlight bordered']/tbody/tr[1]/td[6]");
}
