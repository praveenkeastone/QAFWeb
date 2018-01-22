package com.praveen_flipkart_webautomation.productUtility;

import java.util.HashMap;

import com.praveen_flipkart_webautomation.databean.FlipKartProductBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

public class FlipKartUtil {
	
	public static void setProductItem(HashMap<String, FlipKartProductBean> productList)
	{
		ConfigurationManager.getBundle().addProperty("flipkartproduct.information", productList);
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, FlipKartProductBean> getProductItem()
	{
		HashMap<String, FlipKartProductBean> productDetails;
		if(ConfigurationManager.getBundle().containsKey("flipkartproduct.information"))
		{
			productDetails= (HashMap<String, FlipKartProductBean>) ConfigurationManager.getBundle().getProperty("flipkartproduct.information");
		}
		else
		{
			productDetails= new HashMap<String, FlipKartProductBean>();
			ConfigurationManager.getBundle().addProperty("flipkartproduct.information", productDetails);
		}
		
		return productDetails;
	}
	
	public static void switchToWindow(QAFWebDriver driver)
	{
		for(String handle: driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
	}

}
