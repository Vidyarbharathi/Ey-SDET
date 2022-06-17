package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnMouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement editPage = driver.findElement(By.linkText("Edit"));
		
		Actions build=new Actions(driver);
		build.moveToElement(editPage).click().perform();	
		
		WebElement doubleClick = driver.findElement(By.xpath("//input[@value='Append ']"));		
		build.doubleClick(doubleClick).contextClick().perform();
		
	}

}
