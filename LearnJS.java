package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnJS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//to scroll to the bottom of window
		driver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//click the element which need to be scrolled
		Thread.sleep(3000);
		  WebElement widget = driver.findElement(By.linkText("Widget Factory"));
		  driver.executeScript("arguments[0].scrollIntoView();", widget);
		 Thread.sleep(3000);
		driver.executeScript("scroll(0,-150);");
		
	}

}
