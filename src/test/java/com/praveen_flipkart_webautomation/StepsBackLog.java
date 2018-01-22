/**
 * 
 */
package com.praveen_flipkart_webautomation;

import com.praveen_flipkart_webautomation.flipkartPages.DetailproductviewTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.FlipKartAddToCartTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.FlipkartHomePageTestPage;
import com.praveen_flipkart_webautomation.flipkartPages.ProductResultbySortingandfilterTestPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

/**
 * @author Praveenkumar.dm
 */
public class StepsBackLog {
	FlipkartHomePageTestPage homePage = new FlipkartHomePageTestPage();
	ProductResultbySortingandfilterTestPage resultPage =
			new ProductResultbySortingandfilterTestPage();
	DetailproductviewTestPage productPage = new DetailproductviewTestPage();
	FlipKartAddToCartTestPage cart= new FlipKartAddToCartTestPage();

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user is on flipkart homepage")
	public void userIsOnFlipkartHomepage() {

		homePage.launchTestSite();
		homePage.validateHomepageTitle();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects product {0} from {1} category")
	public void userSelectsProductFromCategory(String subMenu, String mainMenu) {
		homePage.selectProductByBrand(mainMenu, subMenu);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user should see product results")
	public void userShouldSeeProductResults() {
		resultPage.verifyProductSearchResultPage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select sortby {0}")
	public void userSelectSortby(String sortBy) {
		resultPage.getNumberOfProductWithoutFilter();
		resultPage.selectSortProductBy(sortBy);

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select filterby {0} brand")
	public void userSelectFilterbyBrand(String filterOn) {
		resultPage.selectFilterBy(filterOn);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user should see only product results")
	public void userShouldSeeOnlyVuProductResults() {
		resultPage.validateNumberOfProductAfterFilter();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects {0} product from product list")
	public void userSelectsProductFromProductList(String index) {
		resultPage.selectProduct(Integer.parseInt(index));
		resultPage.verifyFlipkartAssured();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user should see product details matching correctly")
	public void userShouldSeeProductDetailsMatchingCorrectly() {
		productPage.verifyProductDetailsPage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects view details")
	public void userSelectsViewDetails() {
		productPage.selectViewDetailofProduct();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user should see {0}")
	public void userShouldSee(String flipAssured) {
		productPage.verifyDetailViewOfProduct(flipAssured);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects add to cart")
	public void userSelectsAddToCart() {
		productPage.addProductToCart();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "product has been added to the cart")
	public void productHasBeenAddedToTheCart() {
		
		cart.verifyAddtoCart();
	}

}
