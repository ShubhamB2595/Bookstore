package bookstore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import bookstore.pages.CartPage;
import bookstore.pages.CheckoutPage;
import bookstore.pages.HomePage;
import bookstore.pages.LoginPage;
import bookstore.pages.MyAccPage;

public class BaseClass {

	public static WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static CartPage cartPage;
	public static CheckoutPage checkoutPage;
	public static MyAccPage accPage;

	public static ExtentReports extent;
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentTest test;

	public static Properties prop;

	@BeforeTest
	public void testSetup() {

		System.setProperty("webdriver.chrome.driver",
				"I:\\Selenium\\BookStoreApp\\src\\main\\resources\\chromedriver.exe");

		PropertyConfigurator.configure("I:\\Selenium\\BookStoreApp\\loggerFile\\log4j.properties");

		extent = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter("extentReport.html");
		extent.attachReporter(extentSparkReporter);
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("Report for BookSwaganStore");

		try {
			prop = new Properties();
			FileInputStream inputFile;
			inputFile = new FileInputStream(System.getProperty("user.dir") + "\\data.properties");
			prop.load(inputFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		accPage = new MyAccPage(driver);

	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		// driver.quit();
		driver.close();
		extent.flush();
	}

}
