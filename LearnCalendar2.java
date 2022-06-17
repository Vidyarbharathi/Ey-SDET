package learnSelenium;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnCalendar2 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Calendar.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		String requiredDate = "10-03-2022";
		String eDate = requiredDate.split("-")[0];
		String eMonth = requiredDate.split("-")[1];
		String eYear = requiredDate.split("-")[2];

		int monthToSelect = Integer.parseInt(eMonth);

		driver.findElement(By.id("datepicker")).click();
		String cMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String cYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		System.out.println(cMonth + "" + cYear);

		// set the format of calendar to the month(June)
		SimpleDateFormat input = new SimpleDateFormat("MMMM");// -->january-December
		Calendar cal = Calendar.getInstance();
		cal.setTime(input.parse(cMonth));

		// convert the month to integer
		SimpleDateFormat output = new SimpleDateFormat("MM");
		System.out.println(output.format(cal.getTime()));
		int currentMonth = Integer.parseInt(output.format(cal.getTime()));

		// forward click from the current month
		if (monthToSelect > currentMonth) {
			for (int i = 0; i < monthToSelect - currentMonth; i++) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		} // to click the previous months
		else if (monthToSelect < currentMonth) {

			for (int i = 0; i < currentMonth - monthToSelect; i++) {
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
		}
		driver.findElement(By.linkText(eDate)).click();

	}

}
