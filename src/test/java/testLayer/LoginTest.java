package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pomPackage.Pomlogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMClass {
Pomlogin Log;
	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshots("Login");
		Log=new Pomlogin();
	}
@Test(priority=1)
public void Title() {
	String actual=Log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual,"Amazon Registration");
}

@DataProvider
public Object[][] Details(){
	Object result[][]=Excelsheet.readdata("Sheet1");
	return result;
}
@Test(priority=2, dataProvider="Details")
public void Login(String name,String email,String password,String passwordagain) throws InterruptedException {
Log.typeusername(name);
Thread.sleep(500);
Log.typeemail(email);
Thread.sleep(500);
Log.typepassword(password);
Thread.sleep(500);
Log.typepasswordagain(passwordagain);
//Thread.sleep(500);
//Log.clickcontinue();
}

@AfterMethod
public void close() {
	driver.close();
}




}
