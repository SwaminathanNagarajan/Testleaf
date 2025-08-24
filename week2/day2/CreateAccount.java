package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		
		//Initialize the browser, maximise the window and call leaftaps site
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
				
		//Step 1 - Enter a username and password. 
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Step 2 - Click the "Login" button. 
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Step 3 - Click on the "CRM/SFA" link. 
		driver.findElement(By.linkText("CRM/SFA")).click();		
		
		//Step 4 - Click on the "Accounts" tab. 
		driver.findElement(By.linkText("Accounts")).click();
		
		//Step 5 - Click on the "Create Account" button.
		driver.findElement(By.linkText("Create Account")).click();
		
		//Step 6 - Enter an account name. 
		driver.findElement(By.id("accountName")).sendKeys("Swami");
		
		//Step 7 - Enter a description as "Selenium Automation Tester." 
		driver.findElement(By.xpath("(//textarea[@class='inputBox'])[1]")).sendKeys("Selenium Automation Tester.");
		
		//Step 8 - Select "ComputerSoftware" as the industry.
		WebElement Industry = driver.findElement(By.xpath("(//select[@class='inputBox'])[2]"));
		Select SortBy = new Select(Industry);
		SortBy.selectByIndex(3);
		
		//Step 9 - Select "S-Corporation" as ownership using SelectByVisibleText. 
		WebElement Ownership = driver.findElement(By.xpath("(//select[@class='inputBox'])[3]"));
		Select Dropdown = new Select(Ownership);
		Dropdown.selectByIndex(4);
		
		//Step 10 - Select "Employee" as the source using SelectByValue. 
		WebElement Employee = driver.findElement(By.xpath("//select[@id='dataSourceId']"));
		Select Dropdown1 = new Select(Employee);
		Dropdown1.selectByIndex(4);
		
		//Step 11 - Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex. 
		WebElement MarketingCampaign = driver.findElement(By.xpath("//select[@id='marketingCampaignId']"));
		Select Dropdown2 = new Select(MarketingCampaign);
		Dropdown2.selectByIndex(6);
		
		//Step 12 - Select "Texas" as the state/province using SelectByValue. 
		WebElement State = driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		Select Dropdown3 = new Select(State);
		Dropdown3.selectByIndex(50);
		
		//Step 13 - Click the "Create Account" button. 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		//Step 14 - Verify that the account name is displayed correctly. 
		WebElement name = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]"));
		String Accountname = name.getText();
		System.out.println("This is the account name: "+Accountname);
		
		//Step 15- Close the browser window.
		Thread.sleep(3000);
		driver.close();

	}

}
