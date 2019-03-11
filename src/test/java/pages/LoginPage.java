package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reporting.Reporter;
import reporting.Status;
import utility.BaseClass;



public class LoginPage extends BaseClass{

	//WebDriver driver;
	
public static  By username = By.id("txtUsername");
public static  By password = By.id("txtPassword");	
public static  By loginBtn = By.id("btnLogin");	


public  LoginPage(WebDriver driver){

    this.driver = driver;

}
//Set user name in textbox

public void setUserName(String strUserName){

	driver.findElement(username).clear();
	
	 Reporter.report(Status.PASS,"Usename field is cleared");
	 
    driver.findElement(username).sendKeys(strUserName);
    Reporter.report(Status.PASS,"Usename is entered");

}

//Set password in password textbox

public void setPassword(String strPassword){

	 driver.findElement(password).clear();
	 Reporter.report(Status.PASS,"Password field is cleared");
     driver.findElement(password).sendKeys(strPassword);
     Reporter.report(Status.PASS,"Password is entered");

}

//Click on login button

public void clickLogin(){

     driver.findElement(loginBtn).click();
     Reporter.report(Status.PASS,"Login Button  is clicked");
}



public void loginToHRM(String strUserName,String strPasword){

    //Fill user name

    this.setUserName(strUserName);

    //Fill password

    this.setPassword(strPasword);
    
  //  Screenshot.captureScreenShot(driver,"Login Page");

    //Click Login button

    this.clickLogin();        
}

	
}
