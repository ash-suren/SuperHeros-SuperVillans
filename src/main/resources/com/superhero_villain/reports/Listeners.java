package com.superhero_villain.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener{
	ExtentTest testStat;
	ExtentReports reprtExt = Report.getReport();
	public void onTestStart(ITestResult result) {
		testStat = reprtExt.createTest(result.getMethod().getMethodName()); 
	}

	public void onTestSuccess(ITestResult result) {
		testStat.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		testStat.log(Status.FAIL, "Test Failed");
	    String failMethod = result.getMethod().getMethodName();
	    testStat.fail(failMethod);
	    testStat.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reprtExt.flush();
	}


}
