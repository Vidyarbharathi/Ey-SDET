package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnPageStatus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		Object executeScript = driver.executeScript("return document.readyState");
		String pageState = executeScript.toString();		
		System.out.println(pageState);
		
		//to verify the pagestate
	
		switch(pageState) {
		case "loading":{
			System.out.println("The page is loading");
			break;
		}
		
		case "Interactive":{
			System.out.println("The page is ready but the elements are yet to load");
			break;
		}
		
		case "complete":{
			System.out.println("The page fully loaded");
			break;
		}
		default:
			break;
		
	
		
			
			
		
		
		
		
	}

}
