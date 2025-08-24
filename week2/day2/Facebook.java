package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// Initialize the browser, maximise the window and call leaftaps site
				ChromeOptions option = new ChromeOptions();
				option.addArguments("guest");
				WebDriver driver = new ChromeDriver(option);
				driver.get("https://en-gb.facebook.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				
				//Step 1 - Click on the Create new account button.
				driver.findElement(By.xpath("//a[text()='Create new account']")).click();
				
				//Step 2 - Enter the First name.
				driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys("John");
				
				//Step 3 - Enter the Surname.
				driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys("Brito");
				
				//Step 4 - Enter the Mobile number or email address.
				driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[5]")).sendKeys("1234567890");
				
				//Step 5 - Enter the New password.
				driver.findElement(By.id("password_step_input")).sendKeys("ABCD_1234");
				
				//Step 6 - Handle all three dropdowns in Date of birth
				//Day
				WebElement DayDropdown = driver.findElement(By.id("day"));
				Select day = new Select(DayDropdown);
				day.selectByIndex(14);
				//Month
				WebElement MonthDropdown = driver.findElement(By.id("month"));
				Select Month = new Select(MonthDropdown);
				Month.selectByIndex(11);
				//Year
				WebElement YearDropdown = driver.findElement(By.id("year"));
				Select Year = new Select(YearDropdown);
				Year.selectByVisibleText("2000");
				
				//Step 7 - Select the radio button in Gender.
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//label[@class='_58mt'])[2]")).click();
				


	}

}
