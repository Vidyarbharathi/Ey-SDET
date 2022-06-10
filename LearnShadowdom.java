package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class LearnShadowdom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub https://dev79735.service-now.com/navpage.do

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		System.out.println(driver);
		Options manage = driver.manage();
		manage.window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("https://dev79735.service-now.com/navpage.do");			
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("MuagE2bCJ%!3");
		
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(3000);		
		
		Shadow dom=new Shadow(driver);		
		Thread.sleep(30000);		

	    WebElement search = dom.findElementByXPath("//input[@id='sncwsgs-typeahead-input']");		
		search.sendKeys("incident");
		String attribute = search.getAttribute("value");
		System.out.println(attribute);
		
		
	}

}
