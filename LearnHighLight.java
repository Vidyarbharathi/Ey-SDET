package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHighLight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	    WebElement demos = driver.findElement(By.linkText("Demos"));
		
		for(int i=0;i<8;i++) {
		driver.executeScript("arguments[0].setAttribute('style',arguments[1]);",demos,"color:Yellow;");
		Thread.sleep(1000);
		driver.executeScript("arguments[0].setAttribute('style',arguments[1]);",demos,"color:transparent;");
		Thread.sleep(1000);
		}
		
		
			
			
			
		
		
		}
		
	}

}
