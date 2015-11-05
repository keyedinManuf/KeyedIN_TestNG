package demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static String S1, S2;
	public static void main(String[] ars)
	{
		
		test2();
	}
		public static void test1()
		{
			WebDriver dr = new FirefoxDriver();
			S1 = "TESTNG";
			//return S1;
			
		}
		public static void test2()
		{
			test1();
			S1=S2;  
			System.out.println("Value: "+S2);
		}
}
