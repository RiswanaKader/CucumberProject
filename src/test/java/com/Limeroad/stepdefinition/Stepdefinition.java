package com.Limeroad.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.Limeroad.base.BaseClass;
import com.Limeroad.pom.PageObjectManager;
import com.Limeroad.runner.RunnerClass;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends BaseClass {
	public static WebDriver driver=RunnerClass.driver;
	static PageObjectManager pom=new PageObjectManager(driver);
	
	@Given("Enter the url")
	public void enter_the_url() throws InterruptedException {
		launchUrl("chrome");
		urlLaunch("https://www.limeroad.com/");
		Thread.sleep(3000);
	}

	@When("Click the men for shopping")
	public void click_the_men_for_shopping() throws InterruptedException {
	   
		clickOnElement(pom.getHp().getMen());
		Thread.sleep(3000);
	}
	@When("Click the jeans in the men")
	public void click_the_jeans_in_the_men() throws InterruptedException {
		clickOnElement(pom.getHp().getJeans());
		Thread.sleep(3000);
}
	@Then("Click the denim jeans")
	public void click_the_denim_jeans() throws InterruptedException {
		clickOnElement(pom.getHp().getSelect());
		Thread.sleep(3000);
	  
	}
	@Then("Select the navy blue jean in denim jeans")
	public void select_the_navy_blue_jean_in_denim_jeans() throws InterruptedException {
		clickOnElement(pom.getHp().getBlueJean());
		Thread.sleep(3000);
	}
	@Then("Select size")
	public void select_size() throws InterruptedException {
		clickOnElement(pom.getHp().getSize());
		Thread.sleep(3000);
	}
	@Then("Add to cart")
	public void add_to_cart() throws InterruptedException {
		clickOnElement(pom.getHp().getCart());
		Thread.sleep(3000);
		
	}
	
}

