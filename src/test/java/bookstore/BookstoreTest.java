package bookstore;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bookstore.pages.CartPage;
import bookstore.pages.CheckoutPage;
import bookstore.pages.HomePage;
import bookstore.pages.LoginPage;
import bookstore.pages.MyAccPage;

public class BookstoreTest {

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	MyAccPage accPage;

	Logger log = Logger.getLogger(BookstoreTest.class);

	Properties prop;
	
	
	@BeforeTest
	public void testSetup() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"I:\\Selenium\\BookStoreApp\\src\\main\\resources\\chromedriver.exe");

		PropertyConfigurator.configure("I:\\Selenium\\BookStoreApp\\loggerFile\\log4j.properties");

		prop = new Properties();
		FileInputStream inputFile = new FileInputStream(System.getProperty("user.dir")+ "\\data.properties");
		prop.load(inputFile);
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		accPage = new MyAccPage(driver);

	}

	@Test(priority = 0)
	public void loginWithInValidCreadentials() {
		loginPage.userLogin(prop.getProperty("validEmail"), prop.getProperty("invalidPass"));
		String actualPageURL = driver.getCurrentUrl();
		assertNotEquals(actualPageURL, loginPage.getUSER_ACC_URL());
	}

	@Test(priority = 1)
	public void verifyForgotPasswordPage() {
		loginPage.forgotPasswordPage();
		assertEquals(driver.getCurrentUrl(), loginPage.getFORGOT_URL());
	}

	@Test(priority = 2)
	public void verifyForgotPasswordWithValidEmail() {
		loginPage.forgotPassword(prop.getProperty("validEmail"));
		assertTrue(loginPage.getEMAIL_SENT().isDisplayed());

	}

	@Test(priority = 3)
	public void verifyForgotPasswordWithInValidEmail() {
		loginPage.forgotPassword(prop.getProperty("invalidEmail"));
		assertTrue(loginPage.getWRONG_EMAIL().isDisplayed());
	}

	@Test(priority = 4)
	public void loginWithValidCreadentials() {
		loginPage.userLogin(prop.getProperty("validEmail"), prop.getProperty("validPass"));
		String actualPageURL = driver.getCurrentUrl();
		assertEquals(actualPageURL, loginPage.getUSER_ACC_URL());
	}

	@Test(priority = 5)
	public void verifyLoginStatus() {
		assertTrue(loginPage.checkLoginStatus());
	}

	@Test(priority = 6)
	public void verifyPersonalSettingPage() {
		accPage.visitPersonalSettingPage();
		assertEquals(driver.getCurrentUrl(), accPage.getACC_SETTING_URL());
	}

	@Test(priority = 7)
	public void verifyMyOrdersPage() {
		accPage.visitMyOrdersPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_ORDER_URL());
	}

	@Test(priority = 8)
	public void verifyMyWishlistPage() {
		accPage.visitMyWishlistPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_WISHLIST_URL());
	}

	@Test(priority = 9)
	public void verifyMyGiftPage() {
		accPage.visitMyGiftPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_GIFT_URL());
	}

	@Test(priority = 10)
	public void verifyMyAddressPage() {
		accPage.visitMyAddressPage();
		assertEquals(driver.getCurrentUrl(), accPage.getMY_ADDRESS_URL());
	}

	@Test(priority = 11)
	public void verifyChangePasswordPage() {
		accPage.visitChangePasswordPage();
		assertEquals(driver.getCurrentUrl(), accPage.getCHANGE_PASS_URL());
	}

	@Test(priority = 12)
	public void verifyLogoIsDisplayed() {
		homePage.launchingHomepage();
		assertTrue(homePage.logoIsDisplayed());
	}

	@Test(priority = 13)
	public void verifyNewArriavalPage() {
		String actualPageURL = homePage.verifyNewArrivals();
		assertEquals(actualPageURL, homePage.getARRIVALS_URL());
	}

	@Test(priority = 14)
	public void verifyPreOrderPage() {
		String actualPageURL = homePage.verifyPreOrder();
		assertEquals(actualPageURL, homePage.getPREORDER_URL());
	}

	@Test(priority = 15)
	public void verifyBestSellerPage() {
		String actualPageURL = homePage.verifyBestSeller();
		assertEquals(actualPageURL, homePage.getSELLER_URL());
	}

	@Test(priority = 16)
	public void verifyTextBookPage() {
		String actualPageURL = homePage.verifyTextBooks();
		assertEquals(actualPageURL, homePage.getTEXTBOOKS_URL());
	}

	@Test(priority = 17)
	public void verifyAwardWinnerPage() {
		String actualPageURL = homePage.verifyAwardWinner();
		assertEquals(actualPageURL, homePage.getWINNER_URL());
	}

	@Test(priority = 18)
	public void verifyFeatureAuthorPage() {
		String actualPageURL = homePage.verifyFeatureAuthor();
		assertEquals(actualPageURL, homePage.getAUTHOR_URL());
	}

	@Test(priority = 19)
	public void searchingBooks() {
		homePage.searchProduct("karma");
		assertEquals(driver.getCurrentUrl(), homePage.getSEARCH_RESULT_URL());
	}

	@Test(priority = 20)
	public void addCart() throws Exception {
		homePage.searchProduct("Alone");
		cartPage.addToCart();
		Thread.sleep(2000);
		cartPage.closeCartPopup();
	}

	@Test(priority = 21)
	public void searchProductAndAddItToCart() throws Exception {
		homePage.checkProduct("Design the Home You Love");
		cartPage.addToCart();
		Thread.sleep(2000);
		cartPage.closeCartPopup();
	}

	@Test(priority = 22)
	public void verifyMyCartIsOpen() {
		cartPage.clickMyCart();
		cartPage.switchToFrame();
		assertTrue(cartPage.isCartOpen());
	}

	@Test(priority = 23)
	public void removeFirstItemFromCart() throws Exception {
		cartPage.removeFromCart();
		Thread.sleep(2000);
	}

	@Test(priority = 24)
	public void removeTotalCartItems() throws Exception {
		while (cartPage.getCartItems() > 0) {
			cartPage.removeFromCart();
			Thread.sleep(2000);
		}
		driver.switchTo().parentFrame();
		cartPage.closeCartPopup();
	}

	@Test(priority = 25)
	public void searchAllResult() {
		homePage.launchingHomepage();
		homePage.searchAndSelectProduct("APJ Kalam", 2);
		cartPage.addToCart();
	}

	@Test(priority = 26)
	public void changeBuyingQuantity() {
		cartPage.switchToFrame();
		cartPage.changeQuantity("2");
	}

	@Test(priority = 27)
	public void toggleCurrency() throws Exception {
		cartPage.changeCurrency("USD");
		Thread.sleep(2000);
		cartPage.changeCurrency("INR");
		Thread.sleep(2000);
	}

	@Test(priority = 28)
	public void CheckingPlacingOrder() {
		cartPage.clickPlaceOrder();
		driver.switchTo().parentFrame();
		assertTrue(checkoutPage.isCheckoutPage());
	}

	@Test(priority = 29)
	public void continueForPlacingOrder() {
		checkoutPage.clickAccContinueBtn();
		checkoutPage.enterShippingAddress();
		checkoutPage.clickAddressSaveCont();
		checkoutPage.clickOrderSaveCont();
		log.info("ordered placed");
	}

	@Test(priority = 30)
	public void userLogoutAction() {
		homePage.launchingHomepage();
		loginPage.userLogout();
		assertEquals(driver.getCurrentUrl(), loginPage.getLOGIN_URL());
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		// driver.quit();
		driver.close();
	}
}
