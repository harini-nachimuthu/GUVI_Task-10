package Ques_3;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class Guvi_signupandlogin {
	protected static String url="https://www.guvi.in/";
	WebDriver driver=null;
  @Test
  public void signup() throws InterruptedException, IOException {
	  //I have created guvi account and activated the account through this signup() method initially
	  // So now when you run the script this fails.
	  WebElement signup=driver.findElement(By.xpath("//a[normalize-space()='Sign up']"));
	  signup.click();
	  
	  WebElement firstname=driver.findElement(By.id("name"));
	  firstname.sendKeys("Divya");
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("harivasanthan37@gmail.com");
	  
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys("Guvi@1234");
	  
	  WebElement mobilenumber=driver.findElement(By.id("mobileNumber"));
	  mobilenumber.sendKeys("9076542210");
	  
	  WebElement submit=driver.findElement(By.xpath("(//a[normalize-space()='Sign Up'])[1]"));
	  submit.click();
	  
	  Thread.sleep(2000);
	  
	  File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file1, new File("C:\\Users\\harin\\eclipse-workspace\\Task_10\\Task_Questions_Screenshot\\guvi_signup.png"));

	  
	  //maybelate button
	  driver.findElement(By.id("laterBtn")).click();
	  Thread.sleep(2000);
	  
	  
  }
  @Test
  public void login() throws InterruptedException, IOException {
	  
	  //I am trying to signup with created account error pop ups so i am login with below script and this pass the script.
	  WebElement signup=driver.findElement(By.xpath("//a[normalize-space()='Sign up']"));
	  signup.click();
	  
	  WebElement firstname=driver.findElement(By.id("name"));
	  firstname.sendKeys("Divya");
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("harivasanthan37@gmail.com");
	  
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys("Guvi@1234");
	  
	  WebElement mobilenumber=driver.findElement(By.id("mobileNumber"));
	  mobilenumber.sendKeys("9076542210");
	  
	  WebElement submit=driver.findElement(By.xpath("(//a[normalize-space()='Sign Up'])[1]"));
	  submit.click();
	  
	  Thread.sleep(3000);
	  File file2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file2, new File("C:\\Users\\harin\\eclipse-workspace\\Task_10\\Task_Questions_Screenshot\\guvi_sign_up.png"));

	  
	    WebElement login=driver.findElement(By.linkText("Click here to Login"));
		login.click();
		
		WebElement email1=driver.findElement(By.id("email"));
		email1.sendKeys("harivasanthan37@gmail.com");
		
		WebElement password1=driver.findElement(By.id("password"));
		password1.sendKeys("Guvi@1234");
		
		WebElement login1=driver.findElement(By.linkText("Login"));
		login1.click();
		
		Thread.sleep(2000);
		
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("C:\\Users\\harin\\eclipse-workspace\\Task_10\\Task_Questions_Screenshot\\guvi_login.png"));
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeClass
  public void beforclass() {
	  driver.navigate().to(url);
  }
  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.close();
	  }
  }

}
