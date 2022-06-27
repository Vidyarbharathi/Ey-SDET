package learnSelenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCDPPerformaceMetrics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> dm=new HashMap<String,Object>();
		dm.put("width", 600);
        dm.put("height", 1000);
        dm.put("deviceScaleFactor", 70);
        dm.put("mobile", true);						
				
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",dm);
		driver.get("http://leaftaps.com/opentaps/control/main");		
	
		
		
		
	}

}
