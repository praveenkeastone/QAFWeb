package com.praveen_flipkart_webautomation.flipkartPages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.praveen_flipkart_webautomation.databean.FlipKartProductBean;
import com.praveen_flipkart_webautomation.productUtility.FlipKartUtil;
import com.praveen_flipkart_webautomation.productdivision.ProductDivisionComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class AddtoCartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(locator = "result.product.division")
	private List<ProductDivisionComponent> resultProductDivision;
	

	public List<ProductDivisionComponent> getResultProductDivision() {
		return resultProductDivision;
	}
	
	public void verifyProductInAddtoCart()
	{
		resultProductDivision.get(0).getResultProductProductname().waitForVisible();
		HashMap<String, FlipKartProductBean> productDetails = FlipKartUtil.getProductItem();
		
		for(String key: productDetails.keySet())
		{
			FlipKartProductBean details = productDetails.get(key);
		
		for(ProductDivisionComponent prod:getResultProductDivision())
		{
			Validator.verifyThat(prod.getResultProductProductname().getText(), Matchers.containsString(details.getProductName()));
			Validator.verifyThat(prod.getResultProductProductprice().getText(), Matchers.containsString(details.getProductPrice()));
		}
		}
	
	}

}
