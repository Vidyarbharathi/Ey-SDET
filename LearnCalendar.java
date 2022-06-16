package learnSelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Calendar.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String requiredDate="10-10-2022";		
		String eDate = requiredDate.split("-")[0];
		String eMonth = requiredDate.split("-")[1];
		String eYear = requiredDate.split("-")[2];		
		
		driver.findElement(By.id("datepicker")).click();
		
		String cMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	
		String cYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
		System.out.println(cMonth +""+cYear);
		
		while(true) {
		
		if(cMonth.equalsIgnoreCase(eMonth) || cYear.equals(eYear)) {
		
			
			break;
		}	else {	driver.findElement(By.xpath("//span[text()='Prev']")).click();
		
		}
		}
		List<WebElement> clickableDate = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		for (WebElement date : clickableDate) {
			
			String text = date.getText();
			if(eDate.equals(text)) {
				date.click();
			
		}
		}
		
		
		
		
	}

}
