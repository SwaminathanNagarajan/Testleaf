package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LeadFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		WebElement button = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		button.click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@class='inputBox']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Swami");
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("N");
		WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drpdown = new Select (dropdown);
		drpdown.selectByIndex(5);
		//driver.findElement(By.xpath("//select[@name='dataSourceId']/option[5]")).click();
		driver.findElement(By.name("submitButton")).click();
		

	}

}
