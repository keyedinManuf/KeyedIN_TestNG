package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import DDaddSalesOrder.*;

public class DDtestSuite {

	public static WebDriver dr= new FirefoxDriver();
	
	public static void main(String[] args) throws Exception{
		
		DDwithPOI.SetExcelPath("C:\\Users\\sakthivel\\Documents\\testdata\\Datadriven.xlsx", "Sheet2");
		dr.get("http://kimdev01.keyedinuat.com/Dev03/User/SignIn");
		dr.manage().window().maximize();
		dr.findElement(By.xpath(".//input[@name='username']")).sendKeys("lizc-admin");
		dr.findElement(By.xpath(".//input[@name='password']")).sendKeys("password");
		dr.findElement(By.xpath(".//input[@value='Sign In']")).click();
		dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		dr.findElement(By.xpath(".//a[@title='Sales Orders']")).click();
		dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
		for(int i=1; i<=13; i++){
		String Customer = DDwithPOI.GetExcelData(i, 0);
		String SalesorderStatus = DDwithPOI.GetExcelData(i, 1);
		String BusinessUnit = DDwithPOI.GetExcelData(i, 2);
		dr.findElement(By.xpath(".//*[@id='select2-chosen-2']")).click();
		WebElement Cus =dr.findElement(By.xpath(".//*[@id='s2id_autogen2_search']"));
		List<WebElement> option1=dr.findElements(By.xpath(".//*[@id='select2-results-2']"));
		Cus.sendKeys(Customer);
		TimeUnit.SECONDS.sleep(3);
		for(WebElement s: option1){
			String verify= s.getText();
			Cus.sendKeys(Keys.ENTER);
			if(verify.contains("No matches found")){
			Cus.sendKeys(Keys.TAB);
			DDwithPOI.WriteExceldata("Fail", i, 3);
			System.out.println("--------------------------------------------");
			System.out.println("Try again, test fail");
			System.out.println("--------------------------------------------");
			}else {
				dr.findElement(By.xpath(".//*[@id='select2-chosen-4']")).click();
				WebElement SOS =dr.findElement(By.xpath(".//*[@id='s2id_autogen4_search']"));
				List<WebElement> option2=dr.findElements(By.xpath(".//*[@id='select2-results-4']"));
				SOS.sendKeys(SalesorderStatus);
				TimeUnit.SECONDS.sleep(5);
				for(WebElement s1: option2){
					String verify1= s1.getText();
					SOS.sendKeys(Keys.ENTER);
					if(verify1.contains("No matches found")){
					SOS.sendKeys(Keys.TAB);
					DDwithPOI.WriteExceldata("Fail", i, 3);
					System.out.println("--------------------------------------------");
					System.out.println("Try again, test fail");
					System.out.println("--------------------------------------------");
					}else {
						dr.findElement(By.xpath(".//*[@id='select2-chosen-6']")).click();
						WebElement Business =dr.findElement(By.xpath(".//*[@id='s2id_autogen6_search']"));
						List<WebElement> option3=dr.findElements(By.xpath(".//*[@id='select2-results-6']"));
						Business.sendKeys(BusinessUnit);
						TimeUnit.SECONDS.sleep(3);
						for(WebElement s2: option3){
							String verify2= s2.getText();
							Business.sendKeys(Keys.ENTER);
							if(verify2.contains("No matches found")){
							Business.sendKeys(Keys.TAB);
							DDwithPOI.WriteExceldata("Fail", i, 3);
							System.out.println("--------------------------------------------");
							System.out.println("Try again, test fail");
							System.out.println("--------------------------------------------");
							}else {
								dr.findElement(By.xpath(".//*[@id='MainWrapper']/div/form/div[3]/div/button[1]")).click();
								TimeUnit.SECONDS.sleep(3);
								String ExpURL = dr.getPageSource();
								if(ExpURL.contains("Add New SO Item")){
									DDwithPOI.WriteExceldata("Pass", i, 3);
									System.out.println("--------------------------------------------");
									System.out.println("Sales order added succesfully");
									WebElement SO = dr.findElement(By.xpath(".//*[@id='MainWrapper']/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
									String result =SO.getText();
									System.out.println("Newly created Sale Order is: "+result);
									System.out.println("--------------------------------------------");
									dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
									
								} else {
									DDwithPOI.WriteExceldata("Fail", i, 3);
									System.out.println("Try again, test fail");
									dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
								       }
			                        }

					            }
                            }
                        }
                    }
                }
            }
		dr.close();
        }
    }