package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShopingTest {
	@Test
	public void shoping() throws InterruptedException
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
		username.sendKeys("ramaraod711@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Srirama@711");
		WebElement signIn = driver.findElement(By.xpath("(//span[text()='Sign In'])[2]/.."));
		signIn.click();
		Thread.sleep(50000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement searchBar= driver.findElement(By.xpath("//input[@name='search']"));
		searchBar.sendKeys("mobiles",Keys.ENTER);
		Thread.sleep(10000);
		WebElement item = driver.findElement(By.xpath("//div[@class='productsRow_DcaXn row_1Rbqw']/div[15]"));
		item.click();
		Thread.sleep(10000);
		WebElement cart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		cart.click();	
	}

}
