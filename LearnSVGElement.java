package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSVGElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();				
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//input[@name='search-suggestions-nykaa']")).sendKeys("L'Oreal Paris",Keys.ENTER);
		driver.findElement(By.xpath("//*[name()='svg' and @class='arrow-icon']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div")).click();
		Thread.sleep(3000);
		driver.executeScript("scroll(0,250);");
		driver.findElement(By.xpath("//span[text()='Category']/following::*[name()='svg'][@class='arrow-icon']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']/following::*[name()='svg'][@class='arrow-icon']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']/following::*[name()='svg'][@class='arrow-icon']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/following::div")).click();
		
	
		
			}

}
