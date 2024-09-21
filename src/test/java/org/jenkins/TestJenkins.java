package org.jenkins;

import java.io.IOException;

import org.pack.base.BaseTestNG;
import org.testng.annotations.Test;

public class TestJenkins {
	@Test
	public void openBrowser() throws IOException {
		BaseTestNG.openBrowser("edge");
		BaseTestNG.launchUrl(BaseTestNG.siteDetails("AmazonUrl"));
		BaseTestNG.applywaits();
	}
}
