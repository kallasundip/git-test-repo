package trsskillfill;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TrsSkillFillProduct {
	public WebDriver driver;

	public void LaunchApp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.get("https://trsskillfill.com/");
	}

	public void Product() throws Exception {
		driver.findElement(By.className("navbar-btn")).click();
		Thread.sleep(1000);
		String productName = driver.findElement(By.xpath("(//h6[@class='sub-title'])[2]")).getText();
		Assert.assertEquals("PRODUCTS", productName, "Product Page validation mismatch");
		System.out.println("Product Page Validate Sucussfully");
		Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='price']/strong)[1]")).isDisplayed(),
				"Front End Development is not displayed");
		Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='price']/strong)[2]")).isDisplayed(),
				"Test Automation is not displayed");
		Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='price']/strong)[3]")).isDisplayed(),
				"DevOps Engineering is not displayed");
		System.out.println("Its Displayed Properlly");
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='pricing-title mt-20']/span)[1]")).isDisplayed(),
				"Front End Development text is not displayed");
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='pricing-title mt-20']/span)[2]")).isDisplayed(),
				"Test Automation text is not displayed");
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='pricing-title mt-20']/span)[2]")).isDisplayed(),
				"DevOps Engineering text is not displayed");
		System.out.println("text is displayed properly");

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='pricing-list pt-20']/ul/li"));
		System.out.println("Totla link size" + list.size());
		int number = 1;
		for (WebElement element : list) {
			Assert.assertTrue(element.isDisplayed(), "some of the links are not displayed");
			System.out.println(number + " : " + element.getText());
			number++;
		}
		System.out.println("All links are displayed");
		driver.findElement(By.className("back-to-top")).click();

	}

	public static void main(String[] args) throws Exception {

		TrsSkillFillProduct trs = new TrsSkillFillProduct();
		trs.LaunchApp();
		trs.Product();

	}
}
