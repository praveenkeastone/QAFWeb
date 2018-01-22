package com.praveen_flipkart_webautomation.flipkartPages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductcategoryTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "product.category")
	private QAFWebElement productCategory;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProductCategory() {
		return productCategory;
	}
	
	public void verifyProductCategoryPage()
	{
		Validator.verifyThat(driver.getTitle().toString(), Matchers.containsString("Apple Store | Buy Apple Store at Best Price in India | Flipkart.com"));
	}
	
	public void selectProductByCategory(String Category)
	{
		QAFWebElement prodByCate= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("product.category"), Category));
		prodByCate.waitForVisible();
		verifyProductCategoryPage();
		prodByCate.click();
	}

}
