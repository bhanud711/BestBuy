package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrderHistoryItems {

	@Test
	public void orderhistory() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver.get("https://www.bestbuy.ca/");
		driver.manage().window().maximize();
		WebElement account = driver.findElement(By.xpath("//span[text()='Account']"));
		account.click();
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("");
		WebElement signIn = driver.findElement(By.xpath("(//span[text()='Sign In'])[2]/.."));
		signIn.click();
		Thread.sleep(20000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement order = driver.findElement(By.xpath("//h3[text()='Order History']"));
		order.click();
		
	}
}
