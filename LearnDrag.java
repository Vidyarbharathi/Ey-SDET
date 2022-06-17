package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDrag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement drag = driver.findElement(By.id("draggable"));	
		
		Point location = drag.getLocation();
		int x = location.getX();
		int y = location.getY();
		Actions build=new Actions(driver);
	    build.dragAndDropBy(drag, x+50, y+70).perform();
		
	}

}
