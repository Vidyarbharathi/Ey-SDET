package learnSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// identify the table
		WebElement eleTable = driver.findElement(By.tagName("table"));

		// driver.findElement(By.xpath("//table//tr"));
		// to get the row elements from table
		List<WebElement> row = driver.findElements(By.tagName("tr"));
		System.out.println(row.size());
		// hit the data of the col
		List<WebElement> col = row.get(1).findElements(By.tagName("td"));
		System.out.println(col.size());

		// driver.findElement(By.xpath("//table//tr[]//td[]"));

		/*
		 * for (WebElement colVal : col) { String text = colVal.getText();
		 * System.out.println(text);
		 * 
		 * }
		 */
//		driver.findElement(By.xpath("//table//tr["+i+"]//td[2]"));
		List<String> colValue = new ArrayList<String>();
		List<Integer> progrssvalue = new ArrayList<Integer>();

		for (int i = 1; i < row.size(); i++)

		{
			List<WebElement> allcol = row.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < allcol.size(); j++) {
				String text = allcol.get(1).getText();
				// colValue.add(text);
				String replace = text.replace("%", "");
				int parsedValue = Integer.parseInt(replace);
				progrssvalue.add(parsedValue);

			}

		}
		// System.out.println(colValue);
		System.out.println(progrssvalue);
		Integer min = Collections.min(progrssvalue);
		System.out.println(min);

		driver.findElement(By.xpath("//table//tr//td[2]//font[contains(text(),'" + min + "')]/following::td/input"))
				.click();

	}

}
