package demos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest 
{

	@Parameters({"browser"})
	@Test
	public void gridDemo(String br,String os) throws MalformedURLException
	{
				
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(br.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName("firefox");
		}else if(br.equalsIgnoreCase("chrome"))
				{
					cap.setBrowserName("chrome");
				}else
				{
					throw new InvalidArgumentException("Browser not Fond!");  
				}
		
		
		URL huburl = new URL("http://192.168.1.14:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(huburl, cap);
		
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		
	}	
}
