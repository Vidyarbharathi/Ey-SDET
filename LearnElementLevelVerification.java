package learnSelenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnElementLevelVerification {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();
		System.out.println(title);

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		String text = "Username";

		WebElement label = driver.findElement(By.xpath("//label[@for='username']"));
		String text2 = label.getText();

		if (text.equals(text2)) {
			System.out.println("Both the text are same");
		} else {
			System.out.println("Both the text are not same");

		}

		WebElement username = driver.findElement(By.id("username"));
		String attributeValue = username.getAttribute("name");
		System.out.println(attributeValue);

		username.sendKeys("demosalesManager");
		String value = username.getAttribute("value");
		System.out.println(value);

		Point location = username.getLocation();
		System.out.println(location);
		int x = location.getX();
		int y = location.getY();
		System.out.println(y);
		System.out.println(x);

		Dimension size = username.getSize();
		System.out.println(size);
		int height = size.getHeight();
		int width = size.getWidth();

		String cssValue = username.getCssValue("background-color");
		System.out.println(cssValue);

		String font = label.getCssValue("font-size");
		System.out.println(font);

		String WebPage = driver.findElement(By.tagName("title")).getAttribute("textContent");
		System.out.println(WebPage);
		// refresh the webpage/webelement
		// driver.navigate().refresh();

		// driver.get(currentUrl);
		/*
		 * driver.navigate().to(currentUrl); Thread.sleep(3000); WebElement username1 =
		 * driver.findElement(By.id("username")); username1.sendKeys("demosalesManager",
		 * Keys.TAB);
		 */

		double random = Math.random();
		int r=(int) (random*999);
		System.out.println(r);
		
		
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snap/shot"+r+".png");
		FileUtils.copyFile(screenshotAs, destination);
		
		File screenshotAs1 = username.getScreenshotAs(OutputType.FILE); File
		destination1=new File("./snap/shot"+r+".png");
		FileUtils.copyFile(screenshotAs1,destination1);
		 
		
		
		
	}

}
