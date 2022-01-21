package bookstore.app;

import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bookstore.pages.CartPage;
import bookstore.pages.HomePage;
import bookstore.pages.LoginPage;

public class Bookstore {

	static WebDriver driver;
	static LoginPage loginPage;
	static HomePage homepage;
	static CartPage cartPage;
	static Robot robot;

	public static void main(String[] args) throws InterruptedException, AWTException {

		driverSetup();
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		cartPage = new CartPage(driver);
		robot = new Robot();
		loginPage.userLogin("shubhambhele95@gmail.com", "Shubham@2595");
//		
//		homepage.launchingWebpage();
//		
//		cartPage.visitMyCart();
		driver.get(cartPage.getMYCART_URL());
		Thread.sleep(6000);
//		homepage.searchProduct("karma");
//		System.out.println(homepage.getSEARCH_RESULT_URL());
//		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

	public static void driverSetup() {

		System.setProperty("webdriver.chrome.driver",
				"I:\\Selenium\\BookStoreApp\\src\\main\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}

}
