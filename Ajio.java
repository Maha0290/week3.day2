package week3.day2.assignment;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ajio.com/");
		WebElement findElement = driver.findElement(By.xpath("//input[@placeholder='Search AJIO']"));
		findElement.click();
		findElement.sendKeys("Bags", Keys.ENTER);
		// driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Men']/following-sibling::label")).click();
		
		Thread.sleep(3000);
		WebElement findElement2 = driver
				.findElement(By.xpath("//input[@id='Men - Fashion Bags']//following-sibling::label"));
		findElement2.click();
		String text = findElement2.getText();
		String replaceAll = text.replaceAll("[^0-9]", "");
		System.out.println("The count of Men's fashion bags is: " + replaceAll);
		
		Thread.sleep(4000);
		// getting list of elements in the brand
		List<WebElement> findElements = driver.findElements(By.className("brand"));
		
		for (WebElement webElement : findElements) {
			System.out.println("The brand name is: " + webElement.getText());

		}

		Thread.sleep(5000);
		List<WebElement> bagNameList = driver.findElements(By.className("name"));

		for (WebElement webElement : bagNameList) {
			System.out.println("The bags name is: " + webElement.getText());
		}

	}

}
