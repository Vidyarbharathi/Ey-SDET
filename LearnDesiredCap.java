package learnSelenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnDesiredCap {


		//TODO Auto-generated method stub
		public RemoteWebDriver driver = null;
		  String username = "vidyar1926";
		  String accessKey = "xqHmrSa12TjL04iSMDva7kF07xB1ElHQWuIjm7u5oa3JJFbXRl";
			
			@BeforeTest
			public void setUp() throws Exception {
			  DesiredCapabilities capabilities = new DesiredCapabilities();
			  
		    capabilities.setCapability("browserName", "Chrome");
		    capabilities.setCapability("version", "92.0");
		    capabilities.setCapability("platform", "Windows 10");
		    capabilities.setCapability("resolution","1024x768");
			  capabilities.setCapability("build", "First Test");
			  capabilities.setCapability("name", "Sample Test");
			  capabilities.setCapability("network", true); // To enable network logs
			  capabilities.setCapability("visual", true); // To enable step by step screenshot
			  capabilities.setCapability("video", true); // To enable video recording
			  capabilities.setCapability("console", true); // To capture console logs

			  try {
			    driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
			  } catch (MalformedURLException e) {
			    System.out.println("Invalid grid URL");
			  }
			}

			@Test(enabled = true)
			public void testScript() throws Exception {
			  try {
				  driver.get("http://leaftaps.com/opentaps/control/main");				
					driver.findElement(By.id("username")).sendKeys("DemoSalesManager");			
					WebElement pwd = driver.findElement(By.id("password"));
					pwd.sendKeys("crmsfa");				
					driver.findElement(By.className("decorativeSubmit")).click();
					String title = driver.getTitle();
					System.out.println(title);
			    driver.quit();
			  } catch (Exception e) {
			    System.out.println(e.getMessage());
			  }

	}

}
