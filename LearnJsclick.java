package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnJsclick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		System.out.println(driver);
		Options manage = driver.manage();
		manage.window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("http://leaftaps.com/opentaps/control/main");				
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");			
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");				
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		driver.executeScript("arguments[0].click()", loginButton);
		
		/*
		 * WebElement zoomin = driver.findElement(By.tagName("html"));
		 * zoomin.sendKeys(Keys.CONTROL ,Keys.ADD);
		 */
		
		driver.executeScript("document.body.style.zoom= '0%'", "");
		Robot robot = new Robot();

for (int i = 0; i < 3; i++) {
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_ADD);
robot.keyRelease(KeyEvent.VK_ADD);
robot.keyRelease(KeyEvent.VK_CONTROL);
}


ro.keyPress(KeyEvent.VK_CONTROL);
ro.keyPress(KeyEvent.VK_SUBTRACT);
ro.keyRelease(KeyEvent.VK_SUBTRACT);
ro.keyRelease(KeyEvent.VK_CONTROL);

		
	}

}
