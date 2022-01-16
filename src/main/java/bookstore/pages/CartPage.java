package bookstore.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	// Initialization of Web driver
	WebDriver driver;
	Robot robot;
	Actions action;
	
	// Initialization of Constant URLs
	private String LOGIN_URL = "https://www.bookswagon.com/login";
	private String USER_ACC_URL = "https://www.bookswagon.com/myaccount.aspx";
	private String AFTER_LOGIN_TITLE = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
	// Initialization of Web elements
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement EMAIL_TXT;
	@FindBy(xpath = "//div[@id='colorbox']")
	WebElement CART_POPUP;
	@FindBy(xpath = "//div[@id='cboxClose']")
	WebElement CLOSE_CART;
	@FindBy(xpath="//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/a[1]")
	WebElement MY_CART;
	@FindBy(xpath="//input[@id='BookCart_lvCart_imgPayment']")
	WebElement PLACE_ORDER_BTN;
	@FindBy(xpath = "//body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[6]/div[2]/a[1]")
	WebElement REMOVE;
	@FindBy(xpath = "//body/div[@id='colorbox']/div[@id='cboxWrapper']/div[2]/div[2]/div[1]/iframe[1]")
	WebElement IFRAME;
	@FindBy(xpath ="//body/div[@id='colorbox']/div[@id='cboxWrapper']/div[2]/div[2]/div[1]/iframe[1]")
	WebElement newFrame;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closeCartPopup() throws InterruptedException {
		
//		CART_POPUP.click();
//		Thread.sleep(4000);
		CLOSE_CART.click();
		Thread.sleep(4000);
	}
	
	public void visitMyCart() {
		
		MY_CART.click();
	}
	
	public void clickPlaceOrder() {
		driver.switchTo().frame(IFRAME);
		PLACE_ORDER_BTN.click();
	}
	
	public void removeFromCart() {
		
		REMOVE.click();
	}
}
