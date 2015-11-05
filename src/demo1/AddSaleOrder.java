package demo1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AddSaleOrder {
	public static WebDriver driver;
 
  @Test (groups = "Mygroups", priority = 1)
  public static void function() throws InterruptedException {
	  driver.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
	  	driver.findElement(By.xpath("html/body/div[1]/ul[2]/li[2]/div/a")).click();
		driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		driver.findElement(By.xpath(".//li[@class='select2-search-field']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String string1="html/body/div[5]/ul/li[";
		String string2="]/div";
		List<WebElement> SOID=driver.findElements(By.xpath("html/body/div[5]"));
		int Size =SOID.size();
		Random select = new Random(System.currentTimeMillis());
		int rval=select.nextInt(Size)+7;
		driver.findElement(By.xpath(string1+rval+string2)).click();
		driver.findElement(By.xpath(".//li[@class='select2-search-field']")).click();
		driver.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		System.out.println("Sales order Acknowledgement done successfully");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
 	  	}
  @Test(enabled = false, priority=0)
  public void salesorderack() throws InterruptedException {
	    driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		driver.findElement(By.xpath(".//a[@href='/Dev03/Form/Create/70']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
	    driver.findElement(By.xpath("html/body/div[1]/ul[2]/li[2]/div/a")).click();
		driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[5]/div[1]/a[3]")).click();
		driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset/div/div/div/div/div/div/div/div[2]/div/div[1]/span/div/ul")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String string3="html/body/div[5]/ul/li[";
		String string4="]/div";
		List<WebElement> SOID1=driver.findElements(By.xpath("html/body/div[5]"));
		int Size =SOID1.size();
		Random select = new Random(System.currentTimeMillis());
		int rval=select.nextInt(Size)+7;
		driver.findElement(By.xpath(string3+rval+string4)).click();
		driver.findElement(By.xpath(".//li[@class='select2-search-field']")).click();
		driver.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		System.out.println("Sales order Acknowledgement done successfully");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	  	}
  
  @Test (groups = "Mygroups", priority=2)
  public void SalesReport() throws InterruptedException, AWTException {
	    driver.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
	  	driver.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
		
		driver.findElement(By.xpath(".//span[@id='select2-chosen-2']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String s1="html/body/div[5]/ul/li[";
		String s2="]/div";
		List<WebElement> options=driver.findElements(By.xpath("html/body/div[5]/ul"));
		int Size = options.size();
		System.out.println("Size:" +Size);
		Random rand = new Random(System.currentTimeMillis());
		int rval=rand.nextInt(Size)+4;
		System.out.println("R val is : "+rval);
		driver.findElement(By.xpath(s1+rval+s2)).click();
		FirefoxProfile prof = new FirefoxProfile();
		prof.setPreference("browser.download.folderlist",0);
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
		driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/div/a")).click();
		Robot object = new Robot();
		object.delay(3000);
		object.keyPress(KeyEvent.VK_ENTER);
		object.keyRelease(KeyEvent.VK_ENTER);
		object.keyPress(KeyEvent.VK_ALT);
		object.keyPress(KeyEvent.VK_ALT);
		object.keyRelease(KeyEvent.VK_F4);
		object.keyRelease(KeyEvent.VK_ALT);
		System.out.println("Sales order delivery listing done Succesfully");
		
  }
  @BeforeTest
  public void beforeMethod() {
	  	
	 
  }

  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }

}
