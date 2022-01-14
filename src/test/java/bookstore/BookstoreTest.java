package bookstore;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bookstore.pages.HomePage;
import bookstore.pages.LoginPage;

public class BookstoreTest {

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void testSetup() {

		System.setProperty("webdriver.chrome.driver", "I:\\Selenium\\BookStoreApp\\src\\main\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	@Test (priority = 0)
	public void loginWithInValidCreadentials() {
		loginPage.userLogin("shubhambhele95@gmail.com", "shhhhh2595");
		String actualPageURL = driver.getCurrentUrl();
		assertNotEquals(actualPageURL, loginPage.getUSER_ACC_URL());
	}
	@Test (priority = 1)
	public void loginWithValidCreadentials() {
		loginPage.userLogin("shubhambhele95@gmail.com", "Shubham@2595");
		String actualPageURL = driver.getCurrentUrl();
		assertEquals(actualPageURL, loginPage.getUSER_ACC_URL());
	}
	
	@Test (priority = 2)
	public void searchingBooks() {	
		homePage.searchProduct("karma");
		assertEquals(driver.getCurrentUrl(), homePage.getSEARCH_RESULT_URL());
	}
	
	@Test (priority = 3)
	public void verifyLogoIsDisplayed() {
		assertTrue(homePage.logoIsDisplayed());
	}

	@Test (priority = 4)
	public void verifyNewArriavalPage() {
		String actualPageURL = homePage.verifyNewArrivals();
		assertEquals(actualPageURL, homePage.getARRIVALS_URL());
	}
	
	@Test (priority = 5)
	public void verifyPreOrderPage() {
		String actualPageURL = homePage.verifyPreOrder();
		assertEquals(actualPageURL, homePage.getPREORDER_URL());
	}
	
	@Test (priority = 6)
	public void verifyBestSellerPage() {
		String actualPageURL = homePage.verifyBestSeller();
		assertEquals(actualPageURL, homePage.getSELLER_URL());
	}
	
	@Test (priority = 7)
	public void verifyTextBookPage() {
		String actualPageURL = homePage.verifyTextBooks();
		assertEquals(actualPageURL, homePage.getTEXTBOOKS_URL());
	}
	
	@Test (priority = 8)
	public void verifyAwardWinnerPage() {
		String actualPageURL = homePage.verifyAwardWinner();
		assertEquals(actualPageURL, homePage.getWINNER_URL());
	}
	
	@Test (priority = 9)
	public void verifyFeatureAuthorPage() {
		String actualPageURL = homePage.verifyFeatureAuthor();
		assertEquals(actualPageURL, homePage.getAUTHOR_URL());
	}
	
	@AfterTest
	public void tearDown() {

		//driver.quit();
		driver.close();
	}
}
