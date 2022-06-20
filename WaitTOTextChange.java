package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitTOTextChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		
		wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));		
		String text = driver.findElement(By.id("btn")).getText();
		System.out.println(text);
		
		
		
		
		
	}

}
