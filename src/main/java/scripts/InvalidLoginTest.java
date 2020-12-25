package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class InvalidLoginTest {
	@Test
	public void invalidloginScenario()
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
       
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bestbuy.ca/");
		driver.manage().window().maximize();
		WebElement account = driver.findElement(By.xpath("//span[text()='Account']"));
		account.click();
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("alpha@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Beta@711");
		WebElement signIn = driver.findElement(By.xpath("(//span[text()='Sign In'])[2]/.."));
		signIn.click();	
	}

}
