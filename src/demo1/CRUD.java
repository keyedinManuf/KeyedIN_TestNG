package demo1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CRUD {
	public static WebDriver dr= new FirefoxDriver();
	public static String str;
  @Test (priority =0)
  public void AddSalesOrder() throws Exception {
	  try{
	  	System.out.println("-------------CRUD Operation----------------");
	  	System.out.println("------------------------------------------------");
	  	System.out.println("Sceario 1: Sales Order Creation");
		dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		dr.findElement(By.xpath(".//a[@href='/Dev03/Form/Create/70']")).click();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[5]/div/input")).sendKeys("Test");
		dr.findElement(By.xpath("html/body/div[5]/ul/li[2]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[5]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		Thread.sleep(1000);
		dr.findElement(By.xpath("html/body/div[6]/div/input")).sendKeys("KI Bikes");
		dr.findElement(By.xpath("html/body/div[6]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[7]/div/input")).sendKeys("CAD - Canadian Dollars");
		dr.findElement(By.xpath("html/body/div[7]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[8]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[8]/div/input")).sendKeys("Mark B");
		dr.findElement(By.xpath("html/body/div[8]/ul/li[1]/div")).click();
		dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Sales Order is created succefully");
	  
	  }	
  catch(Exception e){
		  throw e;
	  }
	  getScreenShot();
  }
  @Test(enabled=true, priority=1)
  public static void AddNewSOitem() throws Exception{
	  try{
		  System.out.println("------------------------------------------------");
		  System.out.println("Scenario 2: Adding new Sales Order item");
		  dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[3]")).click();
		  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  dr.findElement(By.xpath(".//*[@id='s2id_autogen5']")).click();
		  List<WebElement> PartNumber = dr.findElements(By.className("select2-results"));
		  String s1="html/body/div[5]/ul/li[";
		  String s2="]/div";
		  int Size=PartNumber.size();
		  Random rand = new Random(System.currentTimeMillis());
		  int rval = rand.nextInt(Size);
		  Thread.sleep(3000);
		  dr.findElement(By.xpath(s1+rval+s2)).click();
		  dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/a[1]")).click();
		  dr.switchTo().frame(0);
		  dr.findElement(By.xpath("html/body/div/form/div[2]/div[2]/div[2]/ul/li[1]/span/div/a/span[1]")).click();
		  List<WebElement> DDA = dr.findElements(By.xpath("html/body/div[3]/ul"));
		  dr.findElement(By.xpath("html/body/div[3]/ul/li[1]/div")).click();
		  dr.findElement(By.xpath(".//button[@class='btn btn-sm btn-default']")).click();
		  dr.findElement(By.xpath("html/body/div[1]/form/div[2]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/a")).click();
		  dr.findElement(By.id("Quantity")).sendKeys("10");
		  dr.findElement(By.id("List_Price")).sendKeys("100");
		  dr.findElement(By.id("Shipping_Charges")).sendKeys("12");
		  dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		  WebElement orderno = dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/a"));
			str =orderno.getText();
			System.out.println("Created Sales order is :"+str);
		 
	  }catch(Exception e){
		  throw e;
	  }
	  getScreenShot();
  }
  @Test (enabled=true,priority =2)
  public static void SearchSaleOrder() throws Exception{
	  try{
	  System.out.println("------------------------------------------------");
	  System.out.println("Scenario 3: Searching the newly created Sales Order");
	  dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
	  dr.findElement(By.xpath(".//div[@data-label='Sales Orders']")).click();
	  dr.findElement(By.xpath(".//input[@id='Name']")).sendKeys(str);
	  dr.findElement(By.xpath(".//button[@data-label='Search']")).click();
	  WebElement table = dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
	  boolean verify =table.isDisplayed();
	  System.out.println("Search result Table is Displayed:"+verify);
	  Thread.sleep(10000);
	  String Text = dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[3]")).getText();
	  System.out.println("Search result:"+Text);
	  	if(!Text.equals(str)){
		  System.out.print("Search fails\n");
	  	}else{
		  System.out.print("Searching is done with the newly created Sales order\n");
	  	}
	  	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	}catch (Exception e){
		  throw e;
	  }
	  getScreenShot();
  }
  @Test (enabled=true, groups="Mygroup", priority =3)
  public static void EditSalesOrder() throws Exception{
	  try {
	  System.out.println("------------------------------------------------");
	  System.out.println("Scenario 3: Editing the newly added Sales Order");
	  WebDriverWait wait = new WebDriverWait(dr,20);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/div[2]/a[2]/i")));
	  dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/div[2]/a[2]/i")).click();
	  dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[5]/div[1]/div/div/div[2]/div/div[1]/span/div/a")).click();
	  dr.findElement(By.xpath("html/body/div[5]/div/input")).sendKeys("Adult Training Bikes");
	  dr.findElement(By.xpath("html/body/div[5]/ul/li/div/span")).click();
	  dr.findElement(By.xpath(".//span[@id='select2-chosen-10']")).click();
	  dr.findElement(By.xpath("html/body/div[6]/div/input")).sendKeys("30 - Net 30 Days");
	  dr.findElement(By.xpath("html/body/div[6]/ul/li/div/span")).click();
	  dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
	  System.out.println("Editing done successfully");
	  dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
	  catch(Exception e){
		  throw e;
	  }
	  getScreenShot();
  }
  

  @Test (enabled=true,groups="Mygroup", priority=4)
  public static void ViewSalesOrder() throws Exception{
  try{
  System.out.println("------------------------------------------------");
  System.out.println("Scenario 4: View the Sales Order");
  dr.findElement(By.xpath(".//div[@data-label='Sales Orders']")).click();
  dr.findElement(By.xpath(".//input[@id='Name']")).sendKeys(str);
  dr.findElement(By.xpath(".//button[@data-label='Search']")).click();
  Thread.sleep(10000);
  dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/div[2]/a[6]")).click();
  dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/div[2]/ul/li[3]/a")).click();
  System.out.println("Edited Sales order is viewed succesfully");
  }catch (Exception e){
  throw e;
  }
  getScreenShot();
  }
  @Test (enabled=true,groups="Mygroup", priority=5)
  public static void DeleteSalesOrder() throws Exception{
  try{
  System.out.println("------------------------------------------------");
  System.out.println("Scenario 5: Deleting the Sales Order");
  dr.findElement(By.xpath(".//div[@data-label='Sales Orders']")).click();
  dr.findElement(By.xpath(".//input[@id='Name']")).sendKeys(str);
  dr.findElement(By.xpath(".//button[@data-label='Search']")).click();
  Thread.sleep(1000);
  dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/div[2]/a[6]")).click();
  dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/div[2]/ul/li[5]/a")).click();
  dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
  System.out.println("Deleted the newly created Sales order succesfully");
  }catch (Exception e){
  throw e;
  }
  getScreenShot();
  }
  @Test (enabled=true,groups = "Mygroup_2", priority = 6)
  public static void SaleOrderACK() throws InterruptedException, IOException {
	  System.out.println("------------------------------------------------");
	  System.out.println("Scenario 6: Sales order Acknowledgement");
	  	dr.findElement(By.xpath("html/body/div[1]/ul[2]/li[2]/div/a")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		dr.findElement(By.xpath(".//li[@class='select2-search-field']")).click();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String string1="html/body/div[5]/ul/li[";
		String string2="]/div";
		List<WebElement> SOID=dr.findElements(By.xpath("html/body/div[5]"));
		int Size =SOID.size();
		Random select = new Random(System.currentTimeMillis());
		int rval=select.nextInt(Size)+7;
		dr.findElement(By.xpath(string1+rval+string2)).click();
		dr.findElement(By.xpath(".//li[@class='select2-search-field']")).click();
		dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		System.out.println("Sales order Acknowledgement done successfully");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getScreenShot();
 	  	}
  @Test (enabled=true,groups = "Mygroup_2", priority=7)
  public void SalesOrderListing() throws InterruptedException, AWTException, IOException {
	  System.out.println("------------------------------------------------");
	  System.out.println("Scenario 7: Sales order Listing");
	  	dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
		
		dr.findElement(By.xpath(".//span[@id='select2-chosen-2']")).click();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String s1="html/body/div[5]/ul/li[";
		String s2="]/div";
		List<WebElement> options=dr.findElements(By.xpath("html/body/div[5]/ul"));
		int Size = options.size();
//		System.out.println("Size:" +Size);
		Random rand = new Random(System.currentTimeMillis());
		int rval=rand.nextInt(Size)+4;
//		System.out.println("R val is : "+rval);
		dr.findElement(By.xpath(s1+rval+s2)).click();
		FirefoxProfile prof = new FirefoxProfile();
		prof.setPreference("browser.download.folderlist",0);
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/div/a")).click();
		Robot object = new Robot();
		object.delay(3000);
		object.keyPress(KeyEvent.VK_ENTER);
		object.keyRelease(KeyEvent.VK_ENTER);
		object.keyPress(KeyEvent.VK_ALT);
		object.keyPress(KeyEvent.VK_ALT);
		object.keyRelease(KeyEvent.VK_F4);
		object.keyRelease(KeyEvent.VK_ALT);
		System.out.println("Sales order delivery listing done Succesfully");
		System.out.println("------------------------------------------------");
		getScreenShot();
  }
  
  public static void getScreenShot() throws IOException{
	  File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
      //The below method will save the screen shot in d drive with name "screenshot.png"
	  String Capture="C:\\ScreenCapture\\screenshot"+System.currentTimeMillis()+".png";
         FileUtils.copyFile(scrFile, new File(Capture));
  }
  @BeforeTest
  public void beforeTest() {
	  dr.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
	  dr.manage().window().maximize();
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
	  dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  dr.quit();
  }

}
