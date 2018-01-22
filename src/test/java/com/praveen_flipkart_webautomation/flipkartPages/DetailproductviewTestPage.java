package com.praveen_flipkart_webautomation.flipkartPages;

import java.util.HashMap;

import org.hamcrest.Matchers;

import com.praveen_flipkart_webautomation.databean.FlipKartProductBean;
import com.praveen_flipkart_webautomation.productUtility.ProductUtil;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class DetailproductviewTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "detailview.product.productname")
	private QAFWebElement detailviewProductProductname;
	@FindBy(locator = "detailview.product.productprice")
	private QAFWebElement detailviewProductProductprice;
	@FindBy(locator = "detailview.product.viewdetails")
	private QAFWebElement detailviewProductViewdetails;
	@FindBy(locator = "detailview.product.addtocart")
	private QAFWebElement detailviewProductAddtocart;
	@FindBy(locator = "detailview.product.flipkartassured")
	private QAFWebElement detailviewProductFlipkartassured;
	@FindBy(locator= "detailview.popup.closebutton")
	private QAFWebElement detailviewPopupClosebutton;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

	public QAFWebElement getDetailviewProductProductname() {
		return detailviewProductProductname;
	}

	public QAFWebElement getDetailviewProductProductprice() {
		return detailviewProductProductprice;
	}

	public QAFWebElement getDetailviewProductViewdetails() {
		return detailviewProductViewdetails;
	}

	public QAFWebElement getDetailviewProductAddtocart() {
		return detailviewProductAddtocart;
	}

	public QAFWebElement getDetailviewProductFlipkartassured() {
		return detailviewProductFlipkartassured;
	}
	public QAFWebElement getDetailviewPopupClosebutton()
	{
		return detailviewPopupClosebutton;
	}
	
	public void verifyProductDetailsPage()
	{
		if(driver.getWindowHandles().size()>1)
		{
			ProductUtil.switchWindow(driver);
		}
		HashMap<String, FlipKartProductBean> prodItem = ProductUtil.getFlipkartProductItem();
		for(String key: prodItem.keySet())
		{
			FlipKartProductBean prodDetails = prodItem.get(key);
			
			Validator.verifyThat(getDetailviewProductProductname().getText(), Matchers.containsString(prodDetails.getProductName()));
			Validator.verifyThat(getDetailviewProductProductprice().getText(), Matchers.containsString(prodDetails.getProductPrice()));
		}
		
	}
	
	public void selectViewDetailofProduct()
	{
		Validator.verifyThat(true, Matchers.equalTo(getDetailviewProductViewdetails().isDisplayed()&&getDetailviewProductViewdetails().isPresent()));
		getDetailviewProductViewdetails().click();
	}
	public void verifyDetailViewOfProduct(String matchingString)
	{
		
		QAFExtendedWebElement element= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("detailview.product.viewdetails"), matchingString));
		Validator.verifyThat(true, Matchers.equalTo(element.isDisplayed()&&element.isPresent()));
		getDetailviewPopupClosebutton().click();
	}
	
	public void addProductToCart()
	{
		getDetailviewProductAddtocart().click();
	}

	

	
	
	

}
