package com.Limeroad.runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features=".\\src\\test\\java\\com\\Limeroad\\Features\\limeroad.feature",
glue="com.Limeroad.stepdefinition",
monochrome=true,
dryRun=false,
strict=true,
plugin= {"html:Reports/HtmlReport",
		"pretty",
		"json:Reports/JsonReport.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunnerClass{
	public static WebDriver driver;
	

}