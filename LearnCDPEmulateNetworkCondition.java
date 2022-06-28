package learnSelenium;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.log.model.LogEntry;
import org.openqa.selenium.devtools.v100.log.Log;
import org.openqa.selenium.devtools.v101.browser.Browser;
import org.openqa.selenium.devtools.v101.browser.Browser.GetVersionResponse;
import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.ConnectionType;
import org.openqa.selenium.devtools.v101.performance.Performance;
import org.openqa.selenium.devtools.v101.performance.model.Metric;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnCDPEmulateNetworkCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
				
		devTools.send(Network.emulateNetworkConditions(false, 10, 1500, 2000, Optional.of(ConnectionType.WIFI)));
		driver.get("http://leaftaps.com/opentaps/control/main");		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");			
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");				
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
	
		
	}
}

