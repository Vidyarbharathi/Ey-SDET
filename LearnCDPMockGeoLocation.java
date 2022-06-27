package learnSelenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCDPMockGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> gl=new HashMap<String,Object>();
		gl.put("latitude", 47.1625);
        gl.put("longitude", 19.5033);
        gl.put("accuracy", 1);    		
				
		driver.executeCdpCommand("Emulation.setGeolocationOverride",gl);
		driver.get("https://www.netflix.com/");		
	
		
		
		
	}

}
