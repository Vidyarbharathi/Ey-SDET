package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnBrowserLevelVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();		
		System.out.println(title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String pageSource = driver.getPageSource();		
		System.out.println(pageSource);
		
		
		
		
	}

}
