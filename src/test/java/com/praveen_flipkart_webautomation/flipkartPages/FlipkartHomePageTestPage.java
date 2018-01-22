package com.praveen_flipkart_webautomation.flipkartPages;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlipkartHomePageTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "login.popup.closeButton")
	private QAFWebElement loginPopupCloseButton;
	@FindBy(locator = "homepage.mainmenu")
	private QAFWebElement homepageMainmenu;
	@FindBy(locator = "homepage.maincategory.submenu")
	private QAFWebElement homepageMaincategorySubmenu;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLoginPopupCloseButton() {
		return loginPopupCloseButton;
	}

	public QAFWebElement getHomepageMainmenu() {
		return homepageMainmenu;
	}

	public QAFWebElement getHomepageMaincategorySubmenu() {
		return homepageMaincategorySubmenu;
	}
	
	public void launchTestSite()
	{
		driver.get("/");
	}
	public void validateHomepageTitle()
	{
		if(loginPopupCloseButton.isDisplayed()&&loginPopupCloseButton.isPresent())
		{
			loginPopupCloseButton.click();
		}
		else
		{
			Reporter.log("Pop is not displayed");
		}
		Validator.verifyThat(driver.getTitle(),Matchers.containsString("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"));
	}
	
	public void selectProductByBrand(String mainMenu,String subMenuByCategory)
	{
		QAFExtendedWebElement element= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("homepage.mainmenu"), mainMenu));
			if(element.isDisplayed()&&element.isPresent())
		
		{
			Actions action= new Actions(driver);
			action.moveToElement(element).perform();
		}
		QAFExtendedWebElement element2= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("homepage.maincategory.submenu"), subMenuByCategory));
		element2.waitForVisible();	
		element2.click();
	System.out.println();
	System.out.println();
	System.out.println();
	}

}
