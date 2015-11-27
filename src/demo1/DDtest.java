package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import DDaddSalesOrder.*;

public class DDtest {

	public static WebDriver dr= new FirefoxDriver();
	
	public static void main(String[] args) throws Exception{
		
		DDwithPOI.SetExcelPath("C:\\Users\\sakthivel\\Documents\\testdata\\Datadriven.xlsx", "Sheet1");
		dr.get("http://kimdev01.keyedinuat.com/Dev03/User/SignIn");
		dr.manage().window().maximize();
		dr.findElement(By.xpath(".//input[@name='username']")).sendKeys("lizc-admin");
		dr.findElement(By.xpath(".//input[@name='password']")).sendKeys("password");
		dr.findElement(By.xpath(".//input[@value='Sign In']")).click();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.xpath(".//a[@title='Sales Orders']")).click();
		dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
		String Customer = DDwithPOI.GetExcelData(1, 0);
		String SalesorderStatus = DDwithPOI.GetExcelData(1, 1);
		String BusinessUnit = DDwithPOI.GetExcelData(1, 2);
		dr.findElement(By.xpath(".//*[@id='select2-chosen-2']")).click();
		WebElement Cus =dr.findElement(By.xpath(".//*[@id='s2id_autogen2_search']"));
		Cus.sendKeys(Customer);
		TimeUnit.SECONDS.sleep(2);
		Cus.sendKeys(Keys.ENTER);
		dr.findElement(By.xpath(".//*[@id='select2-chosen-4']")).click();
		WebElement SOS =dr.findElement(By.xpath(".//*[@id='s2id_autogen4_search']"));
		SOS.sendKeys(SalesorderStatus);
		TimeUnit.SECONDS.sleep(2);
		SOS.sendKeys(Keys.ENTER);
		dr.findElement(By.xpath(".//*[@id='select2-chosen-6']")).click();
		WebElement Business =dr.findElement(By.xpath(".//*[@id='s2id_autogen6_search']"));
		Business.sendKeys(BusinessUnit);
		TimeUnit.SECONDS.sleep(2);
		Business.sendKeys(Keys.ENTER);
		dr.findElement(By.xpath(".//*[@id='MainWrapper']/div/form/div[3]/div/button[1]")).click();
		TimeUnit.SECONDS.sleep(3);
		String ExpURL = dr.getPageSource();
		if(ExpURL.contains("currently has no items.")){
			DDwithPOI.WriteExceldata("Pass", 1, 3);
			System.out.println("Sales order added succesfully");
			dr.close();
		} else {
			DDwithPOI.WriteExceldata("Fail", 1, 3);
			System.out.println("Try again, test fail");
		}
		
	}
}