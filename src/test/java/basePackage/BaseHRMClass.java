package basePackage;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import utility.TimeUtils;

public class BaseHRMClass{
 public static Properties prop= new  Properties();
 public static WebDriver driver;
 
 //step1
	public BaseHRMClass() {
		try {
FileInputStream file=new FileInputStream("C:\\Users\\kinna\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\config.properties");
prop.load(file);
		}
		
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException a) {
		a.printStackTrace();
	}
	}
	//step 2
		public static void initiate() {
	String browsername=	prop.getProperty("browser");
	
	if (browsername.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver=new ChromeDriver();
	}
	else if(browsername.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	driver.get(prop.getProperty("url"));
	Actions action =new Actions(driver);
	action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	driver.findElement(By.cssSelector("#nav-flyout-ya-newCust > a")).click();
		}
	public static void screenshots(String Filename) {
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(file, new File("C:\\Users\\kinna\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
	}
	catch(IOException e) {
		e.printStackTrace();
	}
		
		
	}

}

