package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAxesXpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		System.out.println(driver);
		Options manage = driver.manage();
		manage.window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("http://leaftaps.com/opentaps/control/main");	
        driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("demoSalesManager");
        driver.findElement(By.xpath("//label[@for='password']/following-sibling::input")).sendKeys("crmsfa");
        driver.findElement(By.xpath("//label[@for='password']/following::input[2]")).click();	
		
	}

}
