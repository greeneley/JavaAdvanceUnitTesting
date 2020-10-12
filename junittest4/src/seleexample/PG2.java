package seleexample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.firefox.FirefoxDriver;

public class PG2 {

	@Test
	public void testWebDriverSample() throws InterruptedException {
		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.gecko.driver", "D:\\java\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// comment the above 2 lines and uncomment below 2 lines to use Chrome
//		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//		 WebDriver driver = new ChromeDriver();
//
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		String expectedProb = "10";
		String actualProb = "";

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);

		// FUNCTION TEST LOGIN

		expectedProb = "Thank you for Loggin.";

		// input u/p
		driver.findElement(By.name("userName")).sendKeys("abc");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("123");
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);

		actualProb = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b"))
				.getText().trim();

		// get the actual value of the title
//		actualTitle = driver.getTitle();
//		driver.findElement(By.xpath(""));
//		System.out.println(actualProb);
		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualProb.contentEquals(expectedProb)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		// close Fire fox
		driver.close();

	}
}
