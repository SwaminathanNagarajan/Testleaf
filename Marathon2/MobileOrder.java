package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class MobileOrder {

	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);

		// Step 1. Launch ServiceNow application
		driver.get("https://dev355356.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		// Step 2. Login with valid credentials username as admin and password
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("u-pN7/dGjKC4");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

		// Step 3. Click-All Enter Service catalog in filter navigator and press enter
		// or Click the ServiceCatalog
		Thread.sleep(3000);
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(7);
		shadow.findElementByXPath("//div[contains(text(),'All')]").click();
		shadow.findElementByXPath("//span[contains(text(),'Service Catalog')]").click();

		// Step 4. Click on mobiles
		WebElement Mobile = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(Mobile);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();

		// Step 5. Select Apple iphone13pro
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();

		// Step 6. Choose yes option in lost or broken iPhone
		driver.findElement(By.xpath("//label[text()='Yes']")).click();

		// Step 7. Enter phonenumber as 99 in original phonenumber field
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");

		// Step 8. Select Unlimited from the dropdown in Monthly data allowance
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select drop = new Select(dropdown);
		drop.selectByIndex(2);

		// Step 9. Update color field to SierraBlue and storage field to 512GB
		driver.findElement(By.xpath("(//label[@class='radio-label'])[5]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[11]")).click();

		// Step 10. Click on Order now option
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();

		// Step 11. Verify order is placed and copy the request number
		WebElement order = driver.findElement(By.xpath("//span[contains(text(),'Thank you, your request has been submitted')]"));
		String OrderConfirmation = order.getText();
		String Expected = "Thank you, your request has been submitted";
		if (OrderConfirmation.equals(Expected)) {
			System.out.println("Your Order is successfully placed");
		} else {
			System.out.println("Your Order is not successfully placed");
		}
		WebElement element = driver.findElement(By.xpath("//a[@id='requesturl']"));
		String RequestNumber = element.getText();
		System.out.println("Please find your order number: " + RequestNumber);

		// Step 12.Take a Snapshot of order placed page
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Eclipse\\TestLeaf Workspace\\LearnAutomation\\Screenshot2.png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot saved successfully at: " + destinationFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Failed to save screenshot: " + e.getMessage());
		}

		// Step 13. Browser close
		driver.close();

	}

}
