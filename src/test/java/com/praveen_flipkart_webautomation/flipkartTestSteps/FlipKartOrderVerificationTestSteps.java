package com.praveen_flipkart_webautomation.flipkartTestSteps;




import org.testng.annotations.Test;

import com.praveen_flipkart_webautomation.flipkartPages.AddtoCartTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.FlipkartHomePageTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.ProductcategoryTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.ProductdetailTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.ResultsbyproductcategoryTestPage;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class FlipKartOrderVerificationTestSteps extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testFlipKartOrderVerification()
	{
	FlipkartHomePageTestPage flipkartHomePageTestPage= new FlipkartHomePageTestPage();
	flipkartHomePageTestPage.launchTestSite();

	flipkartHomePageTestPage.validateHomepageTitle();
	flipkartHomePageTestPage.selectProductByBrand("Electronics", "Apple");
	ProductcategoryTestPage page= new ProductcategoryTestPage();
	page.selectProductByCategory("iPad");
	ResultsbyproductcategoryTestPage resultPage= new ResultsbyproductcategoryTestPage();
	resultPage.verifyProductResultPage();
	resultPage.selectProductInResultPage(0);
	ProductdetailTestPage detailPage= new ProductdetailTestPage();
	detailPage.verifyProductDetails();
	detailPage.addProductToCart();
	AddtoCartTestPage cartPage=new AddtoCartTestPage();
	cartPage.verifyProductInAddtoCart();
	
	}
	
	
	

}
