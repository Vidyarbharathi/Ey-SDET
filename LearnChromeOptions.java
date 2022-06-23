package learnSelenium;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnChromeOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		//option.addArguments("--disable-notifications");
		//option.setHeadless(false);
		//option.addArguments("--start-maximized");
		//option.addArguments("--start-fullscreen");
	//	option.addArguments("--disable-infobars");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	//	driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	


		Dimension size = driver.manage().window().getSize();		
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(height+ "and " +width) ;
		
		Dimension newSize=new Dimension(500,800);
		driver.manage().window().setSize(newSize);		
		Dimension newSetsize = driver.manage().window().getSize();		
		int newheight = newSetsize.getHeight();
		int newwidth = newSetsize.getWidth();
		System.out.println(newheight+ "and " +newwidth) ;
		
		
		
	}

}
