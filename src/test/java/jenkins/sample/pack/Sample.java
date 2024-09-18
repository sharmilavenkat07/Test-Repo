package jenkins.sample.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	@Test
	public void verifyFacebookTitle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		Assert.assertTrue(driver.getTitle().contains("log in"), "Title doesn't match");
		driver.quit();
	}
}
