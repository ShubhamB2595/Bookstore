package bookstore;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import bookstore.base.BaseClass;

public class BookstorePosTest extends BaseClass {

	@Test(priority = 0)
	public void verifyForgotPasswordPage() {
		loginPage.forgotPasswordPage();
		assertEquals(driver.getCurrentUrl(), loginPage.getFORGOT_URL());
	}

	@Test(priority = 1)
	public void verifyForgotPasswordWithValidEmail() {
		loginPage.forgotPassword(prop.getProperty("validEmail"));
		assertTrue(loginPage.getEMAIL_SENT().isDisplayed());

	}

	@Test(priority = 2)
	public void loginWithValidCreadentials() {
		test = extent.createTest("Login with Valid Credentials");
		test.log(Status.INFO, "Launching Login Page");
		test.log(Status.INFO, "Entering the credentials");
		loginPage.userLogin(prop.getProperty("validEmail"), prop.getProperty("validPass"));
		String actualPageURL = driver.getCurrentUrl();
//		assertEquals(actualPageURL, loginPage.getUSER_ACC_URL());
		if (actualPageURL.equalsIgnoreCase(loginPage.getUSER_ACC_URL()))
			test.log(Status.PASS, "Logged in Successfully");
		else
			test.log(Status.FAIL, "Logged in Failed");
	}

	@Test(priority = 3)
	public void verifyLoginStatus() {
		assertTrue(loginPage.checkLoginStatus());
	}

	@Test(priority = 4)
	public void verifyPersonalSettingPage() {
		accPage.visitPersonalSettingPage();
		assertEquals(driver.getCurrentUrl(), accPage.getACC_SETTING_URL());
	}

	@Test(priority = 5)
	public void verifyMyOrdersPage() {
		accPage.visitMyOrdersPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_ORDER_URL());
	}

	@Test(priority = 6)
	public void verifyMyWishlistPage() {
		accPage.visitMyWishlistPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_WISHLIST_URL());
	}

	@Test(priority = 7)
	public void verifyMyGiftPage() {
		accPage.visitMyGiftPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_GIFT_URL());
	}

	@Test(priority = 8)
	public void verifyMyAddressPage() {
		accPage.visitMyAddressPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_ADDRESS_URL());
	}

	@Test(priority = 9)
	public void verifyChangePasswordPage() {
		accPage.visitChangePasswordPage();
		assertEquals(driver.getCurrentUrl(), accPage.getCHANGE_PASS_URL());
	}

	@Test(priority = 10)
	public void verifyLogoIsDisplayed() {
		homePage.launchingHomepage();
		assertTrue(homePage.logoIsDisplayed());
	}

	@Test(priority = 11)
	public void verifyNewArriavalPage() {
		String actualPageURL = homePage.verifyNewArrivals();
		assertEquals(actualPageURL, homePage.getARRIVALS_URL());
	}

	@Test(priority = 12)
	public void verifyPreOrderPage() {
		String actualPageURL = homePage.verifyPreOrder();
		assertEquals(actualPageURL, homePage.getPREORDER_URL());
	}

	@Test(priority = 13)
	public void verifyBestSellerPage() {
		String actualPageURL = homePage.verifyBestSeller();
		assertEquals(actualPageURL, homePage.getSELLER_URL());
	}

	@Test(priority = 14)
	public void verifyTextBookPage() {
		String actualPageURL = homePage.verifyTextBooks();
		assertEquals(actualPageURL, homePage.getTEXTBOOKS_URL());
	}

	@Test(priority = 15)
	public void verifyAwardWinnerPage() {
		String actualPageURL = homePage.verifyAwardWinner();
		assertEquals(actualPageURL, homePage.getWINNER_URL());
	}

	@Test(priority = 16)
	public void verifyFeatureAuthorPage() {
		String actualPageURL = homePage.verifyFeatureAuthor();
		assertEquals(actualPageURL, homePage.getAUTHOR_URL());
	}

	@Test(priority = 17)
	public void searchingBooks() {
		homePage.searchProduct("karma");
		assertEquals(driver.getCurrentUrl(), homePage.getSEARCH_RESULT_URL());
	}

	@Test(priority = 18)
	public void addCart() throws Exception {
		homePage.searchProduct("Alone");
		cartPage.addToCart();
		Thread.sleep(2000);
		cartPage.closeCartPopup();
	}

	@Test(priority = 19)
	public void searchProductAndAddItToCart() throws Exception {
		homePage.checkProduct("Design the Home You Love");
		cartPage.addToCart();
		Thread.sleep(2000);
		cartPage.closeCartPopup();
	}

	@Test(priority = 20)
	public void verifyMyCartIsOpen() {
		cartPage.clickMyCart();
		cartPage.switchToFrame();
		assertTrue(cartPage.isCartOpen());
	}

	@Test(priority = 21)
	public void removeFirstItemFromCart() throws Exception {
		cartPage.removeFromCart();
		Thread.sleep(2000);
	}

	@Test(priority = 22)
	public void removeTotalCartItems() throws Exception {
		while (cartPage.getCartItems() > 0) {
			cartPage.removeFromCart();
			Thread.sleep(2000);
		}
		driver.switchTo().parentFrame();
		cartPage.closeCartPopup();
	}

	@Test(priority = 23)
	public void searchAllResult() {
		homePage.launchingHomepage();
		homePage.searchAndSelectProduct("APJ Kalam", 2);
		cartPage.addToCart();
	}

	@Test(priority = 24)
	public void changeBuyingQuantity() {
		cartPage.switchToFrame();
		cartPage.changeQuantity("2");
	}

	@Test(priority = 25)
	public void toggleCurrency() throws Exception {
		cartPage.changeCurrency("USD");
		Thread.sleep(2000);
		cartPage.changeCurrency("INR");
		Thread.sleep(2000);
	}

	@Test(priority = 26)
	public void CheckingPlacingOrder() {
		cartPage.clickPlaceOrder();
		driver.switchTo().parentFrame();
		assertTrue(checkoutPage.isCheckoutPage());
	}

	@Test(priority = 27)
	public void continueForPlacingOrder() {
		checkoutPage.clickAccContinueBtn();
		checkoutPage.enterShippingAddress();
		checkoutPage.clickAddressSaveCont();
		checkoutPage.clickOrderSaveCont();

	}

	@Test(priority = 28)
	public void userLogoutAction() {
		homePage.launchingHomepage();
		loginPage.userLogout();
		assertEquals(driver.getCurrentUrl(), loginPage.getLOGIN_URL());
	}

}
