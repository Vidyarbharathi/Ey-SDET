package learnSelenium;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String folderName="doc";
		File folder=new File("./"+folderName);
		if(!folder.exists()) {
			folder.mkdir();
		}
		
	String property = System.getProperty("user.dir");
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		HashMap<String, Object> chrompref=new HashMap<String, Object>();
		chrompref.put("profile.default_content_settings.popups", 0);
		chrompref.put("download.default_directory",property+"\\"+folderName);
		option.setExperimentalOption("prefs", chrompref);
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://the-internet.herokuapp.com/download");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("upload_file.xlsx")).click();
		
		
		
		
	}

}
