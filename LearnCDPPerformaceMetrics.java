package learnSelenium;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.performance.Performance;
import org.openqa.selenium.devtools.v101.performance.Performance.EnableTimeDomain;
import org.openqa.selenium.devtools.v101.performance.model.Metric;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCDPPerformaceMetrics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Performance.enable(Optional.of(EnableTimeDomain.TIMETICKS)));

			driver.get("http://leaftaps.com/opentaps/control/main");		
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");			
			WebElement pwd = driver.findElement(By.id("password"));
			pwd.sendKeys("crmsfa");				
			driver.findElement(By.className("decorativeSubmit")).click();
			String title = driver.getTitle();
			System.out.println(title);
			
			List<Metric> send = devTools.send(Performance.getMetrics());
			for (Metric metric : send) {
				System.out.println(metric.getName()+ "=>" +metric.getValue());
		
		
	}
	}
}
