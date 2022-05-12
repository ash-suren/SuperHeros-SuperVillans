package com.superhero_villain.reports;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	
	static ExtentReports report;

	@BeforeTest
	public static ExtentReports getReport()
	{
		String reportPath = System.getProperty("user.dir")+ "\\ExtendReports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Superhero_SuperVillian Report");
		reporter.config().setDocumentTitle("Automation Test Results");
		
		report = new ExtentReports();
		report.attachReporter(reporter);
		return report;
	}
}
