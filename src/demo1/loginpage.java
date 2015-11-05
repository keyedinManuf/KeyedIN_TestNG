package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginpage {
	public static WebDriver dr;
  @Test
  public void function() {
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
	  dr.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
  }
  @BeforeTest
  public void beforetest(){
	  dr=new FirefoxDriver();
	  dr.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
	  dr.manage().window().maximize();
  }
}
