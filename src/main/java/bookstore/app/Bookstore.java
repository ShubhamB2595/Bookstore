package bookstore.app;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bookstore.pages.HomePage;
import bookstore.pages.LoginPage;

public class Bookstore {

	static WebDriver driver;
	static LoginPage loginPage;
	static HomePage homepage;
	
	public static void main(String[] args) {

		driverSetup();
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
	//	loginPage.userLogin("shubhambhele95@gmail.com", "Shubham@2595");
		homepage.searchProduct("karma");
		System.out.println(homepage.getSEARCH_RESULT_URL());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
	
	public static void driverSetup() {
		
		System.setProperty("webdriver.chrome.driver", "I:\\Selenium\\BookStoreApp\\src\\main\\resources\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	}

}
