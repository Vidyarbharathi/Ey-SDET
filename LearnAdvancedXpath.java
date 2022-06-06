package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAdvancedXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		System.out.println(driver);
		Options manage = driver.manage();
		manage.window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("http://leaftaps.com/opentaps/control/main");	
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");			
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		//ctrl shift+o-import your classes
		login.click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Lead')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Find')]")).click();		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Hari");
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		
		
		
		
	}

}
