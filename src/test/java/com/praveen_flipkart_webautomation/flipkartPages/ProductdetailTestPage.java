package com.praveen_flipkart_webautomation.flipkartPages;

import java.util.HashMap;

import org.hamcrest.Matchers;

import com.praveen_flipkart_webautomation.databean.FlipKartProductBean;
import com.praveen_flipkart_webautomation.productUtility.FlipKartUtil;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductdetailTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "product.detailpage.productname")
	private QAFWebElement productDetailpageProductname;
	@FindBy(locator = "product.detailpage.addtocart")
	private QAFWebElement productDetailpageAddtocart;
	@FindBy(locator = "product.detailpage.productprice")
	private QAFWebElement productDetailpageProductprice;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProductDetailpageProductname() {
		return productDetailpageProductname;
	}

	public QAFWebElement getProductDetailpageAddtocart() {
		return productDetailpageAddtocart;
	}

	public QAFWebElement getProductDetailpageProductprice() {
		return productDetailpageProductprice;
	}
	
	public void verifyProductDetails()
	{
		if(driver.getWindowHandles().size()>1)
		{
			FlipKartUtil.switchToWindow(driver);
		}
		
		HashMap<String, FlipKartProductBean> detailsPage = FlipKartUtil.getProductItem();
		for(String key:detailsPage.keySet())
		{
			FlipKartProductBean detail = detailsPage.get(key);
			Validator.verifyThat(getProductDetailpageProductname().getText(), Matchers.containsString(detail.getProductName()));
			System.out.println("_____________________________________________"+detail.getProductName());
			Validator.verifyThat(getProductDetailpageProductprice().getText(),Matchers.containsString(detail.getProductPrice()));
		}
		
	}
	public void addProductToCart()
	{
		if(productDetailpageAddtocart.isDisplayed()&&productDetailpageAddtocart.isPresent())
		{
			productDetailpageAddtocart.click();
		}
	}


}
