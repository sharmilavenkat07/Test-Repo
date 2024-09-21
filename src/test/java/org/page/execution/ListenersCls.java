package org.page.execution;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersCls implements ITestListener, IRetryAnalyzer{
	private int minCount= 0;
	private int maxCount= 3;


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Started" + result.getName());
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped" + result.getName());
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("FailedButWithinSuccessPercentage" + result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("TimeOut" + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("OnStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
}

	@Override
	public boolean retry(ITestResult result) {
		if(minCount<maxCount) {
			minCount++;
			return true;
		}
		return false;
	}

}
