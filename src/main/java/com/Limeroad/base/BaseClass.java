package com.Limeroad.base;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseClass {
      protected static WebDriver driver;
     static Actions a;
	public static void launchUrl(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("Incognito");
		driver=new ChromeDriver(ch);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
	}
		public static void urlLaunch(String url) {
			
		
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	public static boolean elementDisplayed(WebElement element)
	{
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public static boolean elementEnabled(WebElement element)
	{
		boolean enabled = element.isEnabled();
		return enabled;
	}
	public static void clickOnElement(WebElement element)
	{
		if(elementDisplayed(element))
		{
				element.click();
		}
	}
	public static void input(WebElement element,String value)
	{
		if(elementDisplayed(element))
		{
			element.sendKeys(value);	
		}
	}
	public static void scrollUp(int x,int y) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	public static void screenShot(String fileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Admin\\eclipse-workspace\\NykaaMaven\\Screenshot\\nykaa.png");
		FileHandler.copy(src, dest);
	}
	public static void simpleAlert() {
		driver.switchTo().alert().accept();
	}
	public static void confirmAlert(String option)
	{
		if(option.equals("accept")) {
			driver.switchTo().alert().accept();
	}
		else if(option.equals("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
	}
	public static void promptAlert(String input,String option) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(input);
		if(option.equals("accept")) {
			alert.accept();
		}
		else if(option.equals("dismiss"))
		{
			alert.dismiss();
		}
	}
	public static void mouseHover(WebElement element)
	{
		a=new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public static void rightClick(WebElement element)
	{
		a=new Actions(driver);
		a.contextClick(element).build().perform();
	}
	public static void dragAndDrop(WebElement src,WebElement dest)
	{
		a=new Actions(driver);
	    a.dragAndDrop(src, dest).build().perform();
	}
	public static void selectFromDropdown(WebElement element,String option,String value)
	{
		Select s=new Select(element);
		if(option.equals("index"))
		{
			int index=Integer.parseInt(value);
			s.selectByIndex(index);
		}
		else if(option.equals("value"))
		{
			s.selectByValue(value);
		}
		else if(option.equals("text"))
		{
			s.selectByVisibleText(value);
		}
	}
public static void frameUsingIndex(int index)
{
	driver.switchTo().frame(index);
}
public static void frameUsingIdOrName(String value)
{
	driver.switchTo().frame(value);
}
	
public static void frameUsingElement(WebElement element)
	{
		driver.switchTo().frame(element);
	}
public static void switchToWindow(int index)
{
Set<String> tab_id = driver.getWindowHandles();
List<String> id_list=new LinkedList<>(tab_id);
String id = id_list.get(index);
driver.switchTo().window(id);

}
public static void implicitWait()
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
public static void explicitWait(WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public static void explicit(WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
}

