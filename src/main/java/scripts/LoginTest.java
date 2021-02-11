package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void loginPageValidScenario() throws InterruptedException
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
	    Thread.sleep(50000);
		signIn.click();
		Thread.sleep(50000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		/*
		 * 
		 * To verify the payment details adding successfully
		 * 
		 */
	
		WebElement Bill = driver.findElement(By.xpath("//h3[text()='Payment Methods']"));
		Bill.click();
		WebElement card = driver.findElement(By.xpath("//span[text()='Add a new credit card']/.."));
		card.click();
		WebElement cardNumber = driver.findElement(By.xpath("//input[@id='shownCardNumber']"));
		cardNumber.sendKeys("4114360123456785");
		WebElement Month = driver.findElement(By.xpath("//select[@id='expirationMonth']"));
		Select s=new Select(Month);
		s.selectByValue("9");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='expirationYear']"));
		Select selectYear=new Select(year);
		selectYear.selectByValue("2025");
		/*
		 * 
		 * To verify the billing address details adding to the account
		 * 
		 */
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.sendKeys("Baskar");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("Canada");
		WebElement address = driver.findElement(By.xpath("//input[@id='addressLine1']"));
		address.sendKeys("Canada");
		WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
		city.sendKeys("canada");
		WebElement province = driver.findElement(By.xpath("//select[@id='regionCode']"));
		Select se=new Select(province);
		se.selectByValue("MB");
		WebElement postal = driver.findElement(By.xpath("//input[@id='postalCode']"));
		postal.sendKeys("040345");
		WebElement phone = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
		phone.sendKeys("123456789");
		WebElement ext = driver.findElement(By.xpath("//input[@id='primaryPhoneExtension']"));
		ext.sendKeys("456789");
		WebElement AddressNick = driver.findElement(By.xpath("//input[@id='friendlyName']"));
		AddressNick.sendKeys("Near petrolBunk");
		WebElement check = driver.findElement(By.xpath("//input[@id='isDefault']"));
		check.click();
		
		
	

	}

}
