package Marathon2;

import java.io.*;
import java.time.Duration;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TataCliq {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		// Step 1 - Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 2. MouseHover on 'Brands'
		WebElement ElementToHover = driver.findElement(By.xpath("//div[text()='Brands']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ElementToHover).perform();

		// Step 3. MouseHover on 'Watches & Accessories'
		WebElement Watch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		actions.moveToElement(Watch).perform();

		// Step 4. Choose the first option from the 'Featured brands'.
		driver.findElement(By.xpath("//div[text()='Casio']")).click();

		// Step 5. Select sortby: New Arrivals
		WebElement Sort = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select SortBy = new Select(Sort);
		SortBy.selectByIndex(3);

		// Step 6. choose men from catagories filter.
		driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilName'])[1]")).click();

		// Step 7. print all price of watches
		Thread.sleep(5000);
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
		for (int i = 0; i < priceList.size(); i++) {
			System.out.println(priceList.get(i).getText());
		}

		// Step 8. Save the amount in variable for first resulting match and click on
		// the first resulting watch.

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)"); // Scrolls down by 500 pixels

		// Locate the first price element using XPath
		WebElement firstPriceElement = driver.findElement(By.xpath("(//h3[text()='₹4995'])[1]"));

		// Get the text of the price
		String firstWatchPrice = firstPriceElement.getText().replaceAll("[A-B]", " ");
		System.out.println("This is the price of casio watch (Expected price):" + firstWatchPrice);

		// Click on the first resulting match
		WebElement NewTab = driver.findElement(By.xpath("//div[@class='ProductDescription__header']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].click();", NewTab);

		Set<String> allWindows = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(allWindows);

		driver.switchTo().window(windowList.get(1));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement priceElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")));

		String price = priceElement.getText().replaceAll("[A-B]"," ");
		System.out.println("This is the price of casio watch (Actual price):" + price);

		// Step 9. compare two price are similar
		if (firstWatchPrice.equals(price)) {
			System.out.println("The price of the watch in Parent and Child window matches");
		} else {
			System.out.println("The price of the watch in Parent and Child window does not match");
		}

		// Step 10. click Add to cart and get count from the cart icon.
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		WebElement cartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
		String CartCount = cartCount.getText();
		System.out.println("The count of your cart is : " + CartCount);

		// Step 11. Click on the cart
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();

		// Step 12. Take a snap of the resulting page.
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Eclipse\\TestLeaf Workspace\\LearnAutomation\\Screenshot.png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot saved successfully at: " + destinationFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Failed to save screenshot: " + e.getMessage());
		}

		// Step 13. Close All the opened windows one by one.
		driver.close();
		driver.switchTo().window(windowList.get(0));
		driver.close();

	}

}
