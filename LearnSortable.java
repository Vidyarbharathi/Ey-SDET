package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));		
		WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));		
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));		
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));		
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));		
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));		
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));		
	

		Actions build = new Actions(driver);
		build.dragAndDrop(item7, item1).dragAndDrop(item6, item1).pause(2000).dragAndDrop(item5, item1)
		.dragAndDrop(item4, item1).dragAndDrop(item3, item1).dragAndDrop(item2, item1).perform();

	}

}
