package Ques_1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jqueryui_datepicker {
	protected static String url="https://jqueryui.com/datepicker/";
	WebDriver driver=null;
  @Test
  public void f() throws IOException, InterruptedException {
	  driver.switchTo().frame(0);
	  WebElement date=driver.findElement(By.id("datepicker"));
	  date.click();
	  WebElement month=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
	  month.click();
	  WebElement select=driver.findElement(By.xpath("//a[@data-date='22']"));
	  select.click();
	  String selecteddate=date.getAttribute("value");
	  System.out.print("Datepicker : "+selecteddate);
	  Thread.sleep(2000);
	  
	  File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file1, new File("C:\\Users\\harin\\eclipse-workspace\\Task_10\\Task_Questions_Screenshot\\Ques_1.png"));
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
