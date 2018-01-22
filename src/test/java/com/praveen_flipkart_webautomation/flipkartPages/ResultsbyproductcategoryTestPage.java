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

public class ResultsbyproductcategoryTestPage
		extends
			WebDriverBaseTestPage<WebDriverTestPage> {

	

	@FindBy(locator = "result.product.division")
	private List<ProductDivisionComponent> resultProductDivision;
	

	public List<ProductDivisionComponent> getResultProductDivision() {
		return resultProductDivision;
	}
	
	public void verifyProductResultPage()
	{
		Validator.verifyThat(resultProductDivision.size(), Matchers.greaterThan(0));
		resultProductDivision.get(0).getResultProductProductname().waitForVisible();
		for(ProductDivisionComponent prod: getResultProductDivision())
		{
			System.out.println(prod.getResultProductProductname());
			System.out.println(prod.getResultProductProductprice());
		}
	}
	
	public void selectProductInResultPage(int index)
	{
		FlipKartProductBean infoBean= new FlipKartProductBean();
		infoBean.setProductName(getResultProductDivision().get(index).getResultProductProductname().getText());
		infoBean.setProductPrice(getResultProductDivision().get(index).getResultProductProductprice().getText());
		HashMap<String, FlipKartProductBean> productInfo= new HashMap<String, FlipKartProductBean>();
		productInfo.put(infoBean.getProductName(), infoBean);
		getResultProductDivision().get(index).getResultProductProductname().click();
		FlipKartUtil.setProductItem(productInfo);
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

	

}
