package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class Pomlogin extends BaseHRMClass {
     //object repository
	
	@FindBy(id="ap_customer_name")
WebElement Username;
	@FindBy(id="ap_email")
	WebElement Email;
	@FindBy(id="ap_password")
	WebElement Password;
	@FindBy(id="ap_password_check")
	WebElement Passwordagain;
	@FindBy(id="continue")
	WebElement continuebtn;
	
	
	//initiate elements
	public Pomlogin() {
		PageFactory.initElements(driver, this);
	}
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	public void typeemail(String email) {
		Email.sendKeys(email);
	}
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	public void typepasswordagain(String passagain){
		Passwordagain.sendKeys(passagain);
	}
	public void clickcontinue() {
		continuebtn.click();
	}
	public String verify() {
		return driver.getTitle();
		
	}
}
