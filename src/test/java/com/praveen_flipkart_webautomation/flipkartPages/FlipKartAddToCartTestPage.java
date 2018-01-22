package com.praveen_flipkart_webautomation.flipkartPages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.praveen_flipkart_webautomation.databean.FlipKartProductBean;
import com.praveen_flipkart_webautomation.productUtility.ProductUtil;
import com.praveen_flipkart_webautomation.productdivision.ProductResultPageComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class FlipKartAddToCartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(locator = "product.result.division")
	private List<ProductResultPageComponent> productResultDivision;
	
	public List<ProductResultPageComponent> getProductResultDivision() {
		return productResultDivision;
	}
	
	
	public void verifyAddtoCart()
	{
		getProductResultDivision().get(0).getProductResultProductname().waitForVisible();
		Validator.verifyThat(getProductResultDivision().size(), Matchers.greaterThan(0));
		HashMap<String, FlipKartProductBean> prodInfo = ProductUtil.getFlipkartProductItem();
		for(String key: prodInfo.keySet())
		{
			FlipKartProductBean prodDetails = prodInfo.get(key);
			for(ProductResultPageComponent comp: getProductResultDivision())
			{
				if(comp.getProductResultProductname().getText().equals(prodDetails.getProductName()))
				{
					Validator.verifyThat(comp.getProductResultProductname().getText(), Matchers.containsString(prodDetails.getProductName()));
					Validator.verifyThat(comp.getProductResultProductprice().getText(), Matchers.containsString(prodDetails.getProductPrice()));
					
				}
			}
		}
	}

}
