package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchTest {

	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Saravanan_N3\\Desktop\\Softwares\\Selenium Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: " + appTitle);

		if (appTitle.equals("Amazon.in")) {
			System.out.println("Enters Amazon Page and Title Matches ");
		} else {
			System.out.println(" Amazon page Title = " + appTitle);
		}

		WebElement tagName;
		tagName = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		// System.out.println("TagName == " + tagName.getText());

		Actions action = new Actions(driver);
		action.click(tagName).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]/option[37]")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Cricket");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        WebElement Element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[13]/div/span/div/div/div/div/div[2]/h2/a/span"));
//
//        //This will scroll the page till the element is found		
//        js.executeScript("arguments[0].scrollIntoView();", Element);

		System.out.println("");

		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"))
				.click();
		Set handles = driver.getWindowHandles();
		String handle1 = driver.getWindowHandle();
		handles.remove(handle1);

		String handle2 = handles.iterator().next().toString();
		String handle3 = "";

		if (handle1 != handle2) {

			handle3 = handle2;
			driver.switchTo().window(handle3);
			System.out.println("Handle3 ===> " + handle3);
		}

		Thread.sleep(2000);

		System.out.println();

		String bestSeller = "";
		bestSeller = driver.findElements(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).toString();
		System.out.println("Best Seller == " + bestSeller);

	}

}
