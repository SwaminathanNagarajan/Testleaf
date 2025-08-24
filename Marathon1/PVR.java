package Marathon1;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PVR {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Step 1 - Launch browser
		ChromeDriver driver = new ChromeDriver();
		
		//Step 2 - Load the URL and maximize browser.
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		
		//implicit wait		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Step 3 - Choose Your location as "Chennai". Interact with location element and choose the location.
		driver.findElement(By.xpath("//div[@class='show-desktop-view']")).click();
		driver.findElement(By.xpath("(//div[@class='cities-overlay cities-active'])[6]")).click();
		
		//Step 4 - Click on Cinema under Quick Book
		driver.findElement(By.className("cinemas-inactive")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//span[contains(text(), 'Select Cinema')]")).click();
		
		//Step 5 - Select Your Cinema
		driver.findElement(By.xpath("(//div[@class='p-dropdown-items-wrapper']//li)[5]")).click();
		Thread.sleep(2000);
		
		//Step 6 - Select Your Date as Tomorrow
		driver.findElement(By.xpath("//div[@class='p-dropdown-items-wrapper']//li[2]")).click();
		
		//Step 7 - Select Your Movie
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='p-dropdown-items-wrapper']//li[2]//span")).click();
		
		//Step 8 - Select Your Show Time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='p-dropdown-items-wrapper']//li[1]//span")).click();
		
		//Step 9 - Click on Book Button
		driver.findElement(By.xpath("(//button[name()='button'])[8]")).click();
		
		//Step 10 - Click Accept on Term and Condition
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		//Step 11 - Click any one available seat
		driver.findElement(By.xpath("//span[@class='seat-current-pvr']")).click();
		
		//Step 12 - Click Proceed Button
		driver.findElement(By.xpath("//button[contains (text(),'Proceed')]")).click();
		
		//Step 13 - Print the Seat info under book summary
		String seatInfo = driver.findElement(By.xpath("//div[@class='seat-info']")).getText();
		System.out.println("Please find the seat information " + seatInfo);
		
		//Step 14 - Print the grand total under book summary
		String grandtotal = driver.findElement(By.xpath("//div[@class='all-grand']//h6//span")).getText();
		System.out.println("Please find the grand total for your booking summary - "+grandtotal);
		
		//Step 15 - Click Proceed and Continue Button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		//Step 16 - Close the popup
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
				
		//Step 17 - Print Your Current Page title
		String pagetitle = driver.getTitle();
		System.out.println("The title of the current page "+pagetitle);
		 
		//Step 18 - Close Browser
		driver.close();
		driver.quit();
		
	}
}
