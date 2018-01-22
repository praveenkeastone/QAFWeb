package com.praveen_flipkart_webautomation.productdivision;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductDivisionComponent extends QAFWebComponent {

		public ProductDivisionComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

		@FindBy(locator = "result.product.productname")
		private QAFWebElement resultProductProductname;
		@FindBy(locator = "result.product.productprice")
		private QAFWebElement resultProductProductprice;
		
		public QAFWebElement getResultProductProductname() {
			return resultProductProductname;
		}

		public QAFWebElement getResultProductProductprice() {
			return resultProductProductprice;
		}

		
		
	}



