package bookstore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

//	@Test
//	public void loginWithValidCreadentials() {
//
//		loginPage.userLogin("shubhambhele95@gmail.com", "Shubham@2595");
//		String actualPageURL = driver.getCurrentUrl();
//		Assert.assertEquals(actualPageURL, loginPage.getUSER_ACC_URL());
//	}
//	
//	@Test
//	public void loginWithInValidCreadentials() {
//
//		loginPage.userLogin("shubhambhele95@gmail.com", "shhhhh2595");
//		String actualPageURL = driver.getCurrentUrl();
//		Assert.assertNotEquals(actualPageURL, loginPage.getUSER_ACC_URL());
//	}
	
	@Test
	public void searchingBooks() {
		
		homePage.searchProduct("karma");
		Assert.assertEquals(driver.getCurrentUrl(), homePage.getSEARCH_RESULT_URL());
	}

	@AfterTest
	public void tearDown() {

		//driver.quit();
		driver.close();
	}
}
