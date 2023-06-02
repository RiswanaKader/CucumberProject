package com.Limeroad.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.Limeroad.base.BaseClass;

public class PageObjectManager extends BaseClass {
		public PageObjectManager(WebDriver driver1){
			driver=driver1;
			PageFactory.initElements(driver, this);
	}
		private HomePage hp;
		public HomePage getHp() {
			if(hp==null)
				hp=new HomePage(driver);
			return hp;
		}
		}

