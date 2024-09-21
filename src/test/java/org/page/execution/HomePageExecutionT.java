package org.page.execution;

import java.io.IOException;

import org.pack.base.BaseTestNG;
import org.page.factory.HomePageT;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class HomePageExecutionT {
	@BeforeMethod
	public void openBrowser() throws IOException {
		BaseTestNG.openBrowser("edge");
		BaseTestNG.launchUrl(BaseTestNG.siteDetails("AmazonUrl"));
		BaseTestNG.applywaits();
	}

	@AfterMethod
	public void closeBrowser() {
		BaseTestNG.browserClose();
	}

//	@Parameters({"videos"})
	@Test
	public void random() {
//		BaseTestNG.openBrowser(videos);
//		System.out.println(videos);
		HomePageT hp = new HomePageT();
		hp.category.click();
		hp.book.click();
		hp.choose.click();
	}
	@Parameters({"name"})
	@Test
	public void book(String value) {
		BaseTestNG.openBrowser(value);
		System.out.println(value);
	}
	@Test
	public void getMobile() {
		HomePageT hp = new HomePageT();
		hp.phone.click();
	}

	@Test
	public void sellclk() {
		HomePageT hp = new HomePageT();
		AssertJUnit.assertTrue(true);
		hp.sell.click();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("DB Connection open");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("DB Connection close");
	}

	@BeforeGroups({ "Study" })
	public void beforeGroup() {
		System.out.println("Before Group");
	}

	@AfterGroups({ "Business" })
	public void afterGroup() {
		System.out.println("Before Group");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Before Test");
	}
}
