package learnSelenium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.log.Log;
import org.openqa.selenium.devtools.v101.browser.Browser;
import org.openqa.selenium.devtools.v101.browser.Browser.GetVersionResponse;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCDPConsoleLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
				
		devTools.send(Log.enable());
		devTools.addListener(Log.entryAdded(), logEntry-> {
		System.out.println(logEntry.getText());
		System.out.println(logEntry.getLevel());
		System.out.println(logEntry.getCategory());
		System.out.println(logEntry.getSource());
		
		
		
		});
		
		GetVersionResponse bv = devTools.send(Browser.getVersion());
		System.out.println(bv.getUserAgent());
		
		driver.get("http://leaftaps.com/opentaps/control/main");		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");			
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");				
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
	
	}

}
