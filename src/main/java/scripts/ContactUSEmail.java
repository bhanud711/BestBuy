package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ContactUSEmail {
	@Test
	public void contactEmail() throws InterruptedException
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
		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUs.click();
		Thread.sleep(20000);
		WebElement email = driver.findElement(By.xpath("//h3[text()='Email']"));
		email.click();
		Thread.sleep(20000);
		WebElement helpDropDown = driver.findElement(By.xpath("//select[@id='subject']"));
		Select s=new Select(helpDropDown);
		s.selectByVisibleText("Returns and Exchanges");
		WebElement text = driver.findElement(By.xpath("//textarea[@id='returnBody']"));
		text.sendKeys("This product is defective i am not satisfied with this product");
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.sendKeys("Baskar");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("b");
		WebElement mail = driver.findElement(By.xpath("//input[@id='email']"));
		mail.sendKeys("baskar@gmail.com");
		WebElement sendMessage = driver.findElement(By.xpath("//span[text()='Send Message']"));
		sendMessage.click();
	}

}
