package org.pack.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTestNG {
	public static WebDriver driver;

	public static void openBrowser(String Web) {
		if(Web.equalsIgnoreCase("chrome"))
			driver= new ChromeDriver();
		else if(Web.equalsIgnoreCase("edge"))
			driver= new EdgeDriver();
		else {System.out.println("not defined");
		}driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		 driver.get(url);
	}

	public static void applywaits() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void browserClose() {
		driver.close();
	}

	public static String siteDetails(String Keys) throws IOException {
		File file = new File(
				"C:\\Users\\loksh\\eclipse-workspace\\LearnTestNG\\src\\test\\resources\\Cred\\Cred.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(Keys);

	}
}
