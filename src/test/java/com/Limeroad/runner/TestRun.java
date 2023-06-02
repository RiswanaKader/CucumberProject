package com.Limeroad.runner;



import com.Limeroad.base.BaseClass;
import com.Limeroad.pom.PageObjectManager;

public class TestRun extends BaseClass {
	static PageObjectManager pom=new PageObjectManager(driver);
	
	public static void browserLaunch()
	{
		launchUrl("chrome");
		urlLaunch("https://www.limeroad.com/");
	}
	public static void search() {
		clickOnElement(pom.getHp().getMen());
		implicitWait();
		clickOnElement(pom.getHp().getJeans());
		implicitWait();
		clickOnElement(pom.getHp().getSelect());
		implicitWait();
		clickOnElement(pom.getHp().getBlueJean());
		implicitWait();
		clickOnElement(pom.getHp().getSize());
		implicitWait();
		clickOnElement(pom.getHp().getCart());
		implicitWait();
		driver.close();
	}
}
