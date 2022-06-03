package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnBasicSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "./driver/firefoxdriver.exe");
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			System.out.println(driver);
			Options manage = driver.manage();
			manage.window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
			driver.get("http://leaftaps.com/opentaps/control/main");	
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");			
			driver.findElement(By.id("password")).sendKeys("crmsfa");		
			driver.findElement(By.className("decorativeSubmit")).click();
			String title = driver.getTitle();
			System.out.println(title);
	}

}
