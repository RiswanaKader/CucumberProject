package com.Limeroad.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Limeroad.base.BaseClass;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver1)
	{
		driver=driver1;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="shopMen")
	private WebElement men;
	public WebElement getMen() {
		return men;
	}
	@FindBy(xpath="//div[@class='loaderCat vipmenjeansLdr dIb mA pA r0   h80 b4 l0 t0 ']")
	private WebElement jeans;
	public WebElement getJeans() {
		return jeans;
	}
	@FindBy(xpath="//img[@alt='Funk It Up A Notch']")
	private WebElement select;
	public WebElement getSelect() {
		return select;
	}
	@FindBy(id="18532147")
	private WebElement blueJean;
	public WebElement getBlueJean() {
		return blueJean;
	}
	@FindBy(id="size_29887079")
	private WebElement size;
	public WebElement getSize() {
		return size;
	}
	
	@FindBy(xpath="//div[@data-pgn='Add to Cart']")
	private WebElement cart;
	public WebElement getCart() {
		return cart;
	}
	
	
	
}
