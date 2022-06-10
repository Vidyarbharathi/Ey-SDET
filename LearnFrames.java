package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		System.out.println(driver);
		Options manage = driver.manage();
		manage.window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("http://www.leafground.com/pages/frame.html");	
		
		WebElement frameele1 = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(0);		
		WebElement click1 = driver.findElement(By.id("Click"));
		click1.click();
		String text = click1.getText();
		System.out.println(text);
		driver.switchTo().defaultContent();		
		
		
		WebElement frame2 = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[2]"));		
		driver.switchTo().frame(frame2);
		driver.switchTo().frame("frame2");
		WebElement click2 = driver.findElement(By.id("Click1"));
		click2.click();
		System.out.println(click2.getText());
		driver.switchTo().parentFrame();
		String attribute = driver.findElement(By.tagName("iframe")).getAttribute("src");
		System.out.println(attribute);
		
		
	
		
		
		

				

	}

}
