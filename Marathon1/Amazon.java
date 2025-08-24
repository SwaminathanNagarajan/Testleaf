package Marathon1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Step 1 - Launch browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Step 2 - Load the URL and maximize browser.
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//Step 3 - Type "Bags for boys" in the Search box
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for boys");
		
		//Step 4 - Choose the item in the result (bags for boys)
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(text(),'bags for boys')])[1]")).click();
		
		//Step 5 -  Print the total number of results (like 50000)
		Thread.sleep(2000);
		String totalresult = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']")).getText();
		System.out.println("Total number of results for your search: "+totalresult);
		
		//Step 6 - Select the first 2 brands in the left menu (like American Tourister, Generic)
		driver.findElement(By.xpath("//span[text()='Brands']//following::span[@class='a-size-base a-color-base'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Brands']//following::span[@class='a-size-base a-color-base'][2]")).click();
		
		//Step 7 - Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("(//a[@class='a-dropdown-link'])[4]")).click();
		
		//Step 8 - Print the first resulting bag info (name, discounted price)
		driver.executeScript("window.scrollBy(0,450)");
		String name = driver.findElement(By.xpath("//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']//span")).getText();
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The name of your search: "+name);
		System.out.println("The price of the product: ₹"+price);
		
		//Step 9 - Get the page title and close the browser(driver.close())
		String title = driver.getTitle();
		System.out.println("Page title: "+title);
		driver.quit();
		
	
		

	}

}
