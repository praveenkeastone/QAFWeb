package com.praveen_flipkart_webautomation.flipkartTestSteps;

import org.testng.annotations.Test;

import com.praveen_flipkart_webautomation.flipkartPages.DetailproductviewTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.FlipKartAddToCartTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.FlipkartHomePageTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.ProductResultbySortingandfilterTestPage;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class FlipKartApplianceOrderVerification extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testAppliancesOrderVerification()
	{
	FlipkartHomePageTestPage homePage= new FlipkartHomePageTestPage();
	homePage.launchTestSite();
	homePage.validateHomepageTitle();
	homePage.selectProductByBrand("Appliances", "Smart & Ultra HD");
	ProductResultbySortingandfilterTestPage resultPage= new ProductResultbySortingandfilterTestPage();
	resultPage.verifyProductSearchResultPage();
	resultPage.getNumberOfProductWithoutFilter();
	resultPage.selectSortProductBy("Price -- High to Low");
	resultPage.selectFilterBy("Sony");
	resultPage.validateNumberOfProductAfterFilter();
	resultPage.selectProduct(1);
	resultPage.verifyFlipkartAssured();
	DetailproductviewTestPage productPage= new DetailproductviewTestPage();
	productPage.verifyProductDetailsPage();
	productPage.selectViewDetailofProduct();
	productPage.verifyDetailViewOfProduct("Flipkart Assured");
	productPage.addProductToCart();
	FlipKartAddToCartTestPage cart= new FlipKartAddToCartTestPage();
	cart.verifyAddtoCart();
	
	
	
	
	}

}
