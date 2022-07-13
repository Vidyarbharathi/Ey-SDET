package learnSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	public String incidentNo;
	public ChromeDriver driver;
	@BeforeMethod
	public void preCondition() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		System.out.println(driver);
		Options manage = driver.manage();
		manage.window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("https://dev85018.service-now.com/nav_to.do");		
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("SNow@321");		
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(3000);		
		driver.findElement(By.id("filter")).sendKeys("incidents");
		driver.findElement(By.partialLinkText("Incidents")).click();
		driver.switchTo().frame("gsft_main");

	}
	
@Test
	public void TC_01createIncident() throws InterruptedException {
		// TODO Auto-generated method stub https://dev79735.service-now.com/navpage.do

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		incidentNo = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(incidentNo);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test");
		driver.findElement(By.id("sysverb_insert")).click();
	
		
	}


@Test
public void TC_02updateIncident() {
	WebElement searchIncident = driver.findElement(By.xpath("//input[@class='form-control']"));
	searchIncident.click();
	searchIncident.sendKeys(incidentNo,Keys.ENTER);
	WebElement incident = driver.findElement(By.xpath("//td[@class='vt']//a"));
	incident.click();	
	WebElement urgency = driver.findElement(By.name("incident.urgency"));
	Select opt=new Select(urgency);
	opt.selectByValue("1");	
	WebElement state = driver.findElement(By.name("incident.state"));
	Select op=new Select(state);
	op.selectByValue("2");	
	driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	System.out.println(windowHandles.size());
	 List<String> Window= new ArrayList<String>(windowHandles); 
	 driver.switchTo().window(Window.get(1)).getTitle();
	 WebElement serchinLookup = driver.findElement(By.xpath("//input[@class='form-control']"));
	 serchinLookup.click();
	 serchinLookup.sendKeys("System",Keys.ENTER);
	 driver.findElement(By.linkText("System Administrator")).click();
	 driver.switchTo().window(Window.get(0)).getTitle();
	 driver.switchTo().frame("gsft_main");
	 driver.findElement(By.id("sysverb_update")).click();
	 String inProgress = driver.findElement(By.xpath("(//td[@class='vt']/following-sibling::td)[3]")).getText();
		System.out.println("Verified with Urgency" +inProgress);
		String high = driver.findElement(By.xpath("//td[text()='1 - High']")).getText();
		System.out.println("Verified with" +high);
}
@Test
public void TC_03deleteIncident() throws InterruptedException {
	
	WebElement searchIncident = driver.findElement(By.xpath("//input[@class='form-control']"));
	searchIncident.click();
	searchIncident.sendKeys(incidentNo,Keys.ENTER);
	WebElement incident = driver.findElement(By.xpath("//td[@class='vt']//a"));
	incident.click();
	driver.findElement(By.id("sysverb_delete")).click();
	driver.findElement(By.id("ok_button")).click();
	Thread.sleep(4000);

	WebElement searchIncident1 = driver.findElement(By.xpath("//input[@class='form-control']"));
	searchIncident1.click();
	searchIncident1.sendKeys(incidentNo,Keys.ENTER);
	String noRecordsTo = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
	System.out.println(noRecordsTo);
	
	
}

@AfterMethod
public void postCondition() {
	driver.close();
}

}
