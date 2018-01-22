package com.praveen_flipkart_webautomation.productdivision;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductResultPageComponent extends QAFWebComponent {
	

	public ProductResultPageComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "product.result.productname")
	private QAFWebElement productResultProductname;
	@FindBy(locator = "product.result.productprice")
	private QAFWebElement productResultProductprice;
	
	public QAFWebElement getProductResultProductname() {
		return productResultProductname;
	}

	public QAFWebElement getProductResultProductprice() {
		return productResultProductprice;
	}
	
}
