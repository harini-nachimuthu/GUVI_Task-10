package Ques_2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class jqueryui_droppable {
	protected static String url="https://jqueryui.com/droppable/";
	WebDriver driver=null;
  @Test(priority=1)
  public void before() {
	  WebElement frameid=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	  driver.switchTo().frame(frameid);
	  WebElement drag=driver.findElement(By.id("draggable"));
	  String dragstr=drag.getText();
	  System.out.println("Draggable text is :: "+dragstr);
	  WebElement drop=driver.findElement(By.id("droppable"));
	  String dropstr=drop.getText();
	  System.out.println("Draggable text is :: "+dropstr);
	  String beforedrop=drop.getCssValue("background-color");
	  System.out.println("Before attribute values of drop is : "+beforedrop);
  }
  @Test(priority=2)
  public void after() throws IOException, InterruptedException {
	  Actions actions=new Actions(driver);
	  WebElement drag=driver.findElement(By.id("draggable"));
	  WebElement drop=driver.findElement(By.id("droppable"));
	  actions.dragAndDrop(drag, drop);
	  actions.build().perform();
	  String afterdropstr=drop.getText();
	  System.out.println("Draggable text after dragging :: "+afterdropstr);
	  String afterdrop=drop.getCssValue("background-color");
	  System.out.println("After attribute values of drop is : "+afterdrop);
	  
	  
	  String values=driver.findElement(By.xpath("//p[normalize-space()='Dropped!']")).getText();
	  if(afterdropstr.equals(values)) {
		  System.out.println("Yes drag and drop is completed!!!");
	  }else {
		  System.out.println("No drag and drop action didn't occur");
	  }
	  Thread.sleep(2000);
	  
	  File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file1, new File("C:\\Users\\harin\\eclipse-workspace\\Task_10\\Task_Questions_Screenshot\\Ques_2.png"));
	  
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
