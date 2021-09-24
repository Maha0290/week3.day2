package week3.day2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://erail.in/");
		WebElement findElement = driver.findElement(By.id("txtStationFrom"));
		findElement.clear();
		findElement.sendKeys("Chennai Egmore", Keys.ENTER);
		// driver.findElement(By.id("txtStationFrom")).sendKeys("Chennai Egmore");

		WebElement findElement2 = driver.findElement(By.id("txtStationTo"));
		findElement2.clear();
		findElement2.sendKeys("Madurai Jn", Keys.ENTER);
		// driver.findElement(By.id("txtStationTo")).sendKeys("Madurai");
		boolean enabled = driver.findElement(By.id("chkSelectDateOnly")).isEnabled();
		if (enabled == true) {
			driver.findElement(By.id("chkSelectDateOnly")).click();
		} else {
			System.out.println("The check box is already unchecked");
		}
		Thread.sleep(1000);
		List<WebElement> trainNumber = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[1]"));

		System.out.println("The number of trains: " + trainNumber.size());
		Thread.sleep(2000);
		List<WebElement> trainNameList = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));

		Set<WebElement> trainNameSet = new LinkedHashSet<WebElement>(trainNameList);
		String text = null;
		List<String> strList = new ArrayList<String>();
		for (WebElement trainName : trainNameSet) {
			text = trainName.getText();

			System.out.println("The train names is: " + text);
			strList.addAll(Arrays.asList(text));

		}

		Collections.sort(strList);
		System.out.println("The sorted list is: " + strList);

	}



	}


