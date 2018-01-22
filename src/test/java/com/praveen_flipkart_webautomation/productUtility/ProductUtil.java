package com.praveen_flipkart_webautomation.productUtility;

import java.util.HashMap;

import com.praveen_flipkart_webautomation.databean.FlipKartProductBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

public  class ProductUtil {
	
	public static void setFlipkartProductItem(HashMap<String, FlipKartProductBean> itemdetails)
	{
		ConfigurationManager.getBundle().addProperty("flipkart.product.information", itemdetails );
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, FlipKartProductBean>  getFlipkartProductItem()
	{
		HashMap<String, FlipKartProductBean> productdetails;
		if(ConfigurationManager.getBundle().containsKey("flipkart.product.information"))
		{
			productdetails= (HashMap<String, FlipKartProductBean>) ConfigurationManager.getBundle().getProperty("flipkart.product.information");
		}
		else
		{
			productdetails= new HashMap<String, FlipKartProductBean>();
			ConfigurationManager.getBundle().addProperty("flipkart.product.information", productdetails);
		}
		
		return productdetails;
	}
	
	public static void switchWindow(QAFWebDriver driver)
	{
		for(String handle:driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
	}

}
