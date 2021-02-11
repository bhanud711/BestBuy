package scripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NearestStores {
	
	@Test
	public void findNearestStores() throws InterruptedException
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
		String parent=driver.getWindowHandle();
		WebElement stores = driver.findElement(By.xpath("//div[text()='Stores']"));
		stores.click();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> i = all.iterator();
		while(i.hasNext())
		{
			String child=i.next();
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
			}
			
		}
		System.out.println("Child tab titile"+driver.getTitle());
		System.out.println("child tab URL"+driver.getCurrentUrl());
		WebElement searchPlace = driver.findElement(By.xpath("//input[@name='q']"));
		searchPlace.sendKeys("Cambridge, ON, Canada",Keys.ENTER);
		
		
		
		
	}

}
