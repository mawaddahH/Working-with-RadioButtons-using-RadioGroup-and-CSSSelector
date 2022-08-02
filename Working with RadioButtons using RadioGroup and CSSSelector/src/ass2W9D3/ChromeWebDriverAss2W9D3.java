package ass2W9D3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeWebDriverAss2W9D3 {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 * @throws InterruptedException 
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://formstone.it/components/checkbox/");
		System.out.println(driver.getTitle());
	}

	/**
	 * Test RadioButton
	 * 
	 * @throws InterruptedException
	 */
		@Test
		public void LearnEnglishWebSite() throws InterruptedException {
			
			// find RadioButton
			WebElement radioButton = driver.findElement(By.cssSelector("#radio-2"));
			boolean isCheck1 = radioButton.isSelected();
			System.out.println("is radioButton selected  "+isCheck1);
			if(isCheck1) {
				System.out.println("radioButton is selected by default");
			}
			else {
				Actions action = new Actions(driver);
				//Right click 
				action.click(radioButton).build().perform();
				System.out.println("radioButton is selected manally");

			}
			Thread.sleep(2000);

		}
		
		/**
		 * Tear down the setup after test completes
		 */
		@AfterTest
		public void terminateBrowser() {
			// Close the browser
			driver.close();

			// Quite the selenium
			driver.quit();
		}
}
