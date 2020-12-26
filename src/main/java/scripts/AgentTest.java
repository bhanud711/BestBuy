package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AgentTest {
	@Test
	public void chatWithAgent() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver.get("https://www.bestbuy.ca/");
		driver.manage().window().maximize();
		WebElement service = driver.findElement(By.xpath("//a[text()='Services']"));
		service.click();
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Chat with an Agent']"));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		driver.switchTo().frame("covert-chat-app");
		WebElement drop = driver.findElement(By.xpath("//select[@name='help']"));
		Select s=new Select(drop);
		s.selectByVisibleText("Geek Squad Billing Inquiries");
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstName.sendKeys("Ramarao");
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastName.sendKeys("Derangulla");
		WebElement mail = driver.findElement(By.xpath("//input[@autocomplete='email']"));
		mail.sendKeys("ramaraod711@gmail.com");
		Thread.sleep(10000);
		WebElement button = driver.findElement(By.xpath("//span[text()='Start Chat']/.."));
		button.click();
		
		
	}

}
