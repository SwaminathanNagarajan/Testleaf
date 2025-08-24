package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// Initialize the browser, maximise the window and call leaftaps site
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		// Step 1 - Enter a username and password.
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Step 2 - Click the "Login" button.
		driver.findElement(By.className("decorativeSubmit")).click();

		// Step 3 - Click on the "CRM/SFA" link.
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Step 4 - Click on "Leads" tab
		driver.findElement(By.linkText("Leads")).click();

		// Step 5 - Click on the "Create Lead" button.
		driver.findElement(By.linkText("Create Lead")).click();

		// Step 6 - Enter a FirstName.
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Hari");

		// Step 7 - Enter a LastName.
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Krishnan");

		// Step 8 - Enter a CompanyName.
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ATHENA");

		// Step 9 - Enter a Title .
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("TEST AUTOMATION");

		// Step 10 - Click the "Create Lead" button.
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		// Step 11 - Verify that the Title is displayed correctly.
		WebElement Title = driver.findElement(By.xpath("//span[contains(text(),'TEST AUTOMATION')]"));
		String actualtitle = Title.getText();
		System.out.println("This is the actual title: " + actualtitle);

		// Step 12 - Close the browser window.
		Thread.sleep(3000);
		driver.close();

	}

}
