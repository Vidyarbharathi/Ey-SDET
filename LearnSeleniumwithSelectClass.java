package learnSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSeleniumwithSelectClass {

	public static void main(String[] args) {	
		
	//	System.setProperty("webdriver.chrome.driver", "./driver/firefoxdriver.exe");
				
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		System.out.println(driver);
		Options manage = driver.manage();
		manage.window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("http://leaftaps.com/opentaps/control/main");	
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");			
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();		
		System.out.println(title);
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vidya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select value=new Select(source);
		value.selectByIndex(3);
				
		List<WebElement> options = value.getOptions();
		for (WebElement vv : options) {
			System.out.println(vv.getText());		
			}
				
		List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
		System.out.println(dropdowns.size());		
		WebElement dd = dropdowns.get(2);		
		Select dd1 =new Select(dd);
		dd1.selectByIndex(4);
		dd1.selectByValue("AFA");
		dd1.selectByVisibleText("ALL - Albanian Lek");
		//dd1.deselectByIndex(4);
		
		boolean multiple = dd1.isMultiple();
		System.out.println(multiple);
		driver.findElement(By.className("smallSubmit")).click();
		
		
		//driver.close();
		
		
		
		

	}

}
