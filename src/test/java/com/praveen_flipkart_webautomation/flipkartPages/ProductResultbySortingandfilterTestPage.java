package com.praveen_flipkart_webautomation.flipkartPages;



import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;

import com.praveen_flipkart_webautomation.databean.FlipKartProductBean;
import com.praveen_flipkart_webautomation.productUtility.ProductUtil;
import com.praveen_flipkart_webautomation.productdivision.ProductResultPageComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductResultbySortingandfilterTestPage
		extends
			WebDriverBaseTestPage<WebDriverTestPage> {
	
	static int productNumber=0;
	
	@FindBy(locator = "product.result.division")
	private List<ProductResultPageComponent> productResultDivision;
	
	@FindBy(locator = "product.result.sortby")
	private List<QAFWebElement> productResultSortby;
	@FindBy(locator = "product.result.filter")
	private QAFWebElement productResultFilter;
	@FindBy(locator = "product.result.numberofproducts")
	private QAFWebElement productResultNumberofproducts;
	@FindBy(locator = "product.result.flipkartassured")
	private QAFWebElement productResultFlipkartassured;

	public List<ProductResultPageComponent> getProductResultDivision() {
		return productResultDivision;
	}
	
	public List<QAFWebElement> getProductResultSortby() {
		return productResultSortby;
	}

	public QAFWebElement getProductResultFilter() {
		return productResultFilter;
	}

	

	public QAFWebElement getProductResultNumberofproducts() {
		return productResultNumberofproducts;
	}

	public QAFWebElement getProductResultFlipkartassured() {
		return productResultFlipkartassured;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	public void verifyProductSearchResultPage()
	{
		productResultDivision.get(0).waitForVisible();
		Validator.verifyThat(productResultDivision.size(),Matchers.greaterThan(0));
		for(ProductResultPageComponent prodComp: getProductResultDivision())
		{
			System.out.println(prodComp.getProductResultProductname().getText());
			System.out.println(prodComp.getProductResultProductprice().getText());
		}
	}
	
	public void getNumberOfProductWithoutFilter()
	{
		productResultNumberofproducts.waitForVisible();
		String[] numb=productResultNumberofproducts.getText().split(" ");
		productNumber=Integer.parseInt(numb[6]);    
	}
	
	public void selectSortProductBy(String basedOn)
	{
		
		QAFExtendedWebElement element= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("product.result.sortby"),basedOn ));
		element.click();
	}
	
	public void selectFilterBy(String FilterOn)
	{
		QAFTestBase.pause(2000);
		driver.manage().window().maximize();
		Actions action= new Actions(driver);
		action.dragAndDrop(productResultDivision.get(0),productResultDivision.get(4)).build().perform();
		QAFExtendedWebElement element= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("product.result.filter"),FilterOn));
		if(element.isDisplayed()&&element.isPresent())
		{
		element.click();
		}
	}
	public void validateNumberOfProductAfterFilter()
	{
		QAFTestBase.pause(2000);
		productResultNumberofproducts.waitForVisible();
		String[] numb1=productResultNumberofproducts.getText().split(" ");
		Validator.verifyThat(Integer.parseInt(numb1[6]), Matchers.not(productNumber));
		
	}
	
	public void selectProduct(int index)
	{
		FlipKartProductBean infoBean= new FlipKartProductBean();
		
		infoBean.setProductName(getProductResultDivision().get(index).getProductResultProductname().getText());
		infoBean.setProductPrice(getProductResultDivision().get(index).getProductResultProductprice().getText());
		HashMap<String, FlipKartProductBean> productInfo= new HashMap<String, FlipKartProductBean>();
		productInfo.put(infoBean.getProductName(), infoBean);
		getProductResultDivision().get(index).getProductResultProductname().click();
		ProductUtil.setFlipkartProductItem(productInfo);
	}
	
	public void verifyFlipkartAssured()
	{
		getProductResultFlipkartassured().waitForVisible();
		Validator.verifyThat(true, Matchers.equalTo(getProductResultFlipkartassured().isDisplayed()&&getProductResultFlipkartassured().isPresent()));
	}
	
}
