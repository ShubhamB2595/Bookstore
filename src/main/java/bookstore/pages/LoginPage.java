package bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Initialization of Web driver
	WebDriver driver;
	// Initialization of Constant URLs
	private String LOGIN_URL = "https://www.bookswagon.com/login";
	private String USER_ACC_URL = "https://www.bookswagon.com/myaccount.aspx";
	private String AFTER_LOGIN_TITLE = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
	// Initialization of Web elements
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/input[1]")
	WebElement EMAIL_TXT;
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/input[1]")
	WebElement PASSWORD_TXT;
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/input[1]")
	WebElement LOGIN_BTN;
	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]")
	WebElement FORGOT_PASS;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// method for user login
	public void userLogin(String email, String password) {
		
		driver.get(LOGIN_URL);
		EMAIL_TXT.sendKeys(email);
		PASSWORD_TXT.sendKeys(password);
		LOGIN_BTN.click();
	}

	public String getLOGIN_URL() {
		return LOGIN_URL;
	}

	public String getUSER_ACC_URL() {
		return USER_ACC_URL;
	}

	public String getAFTER_LOGIN_TITLE() {
		return AFTER_LOGIN_TITLE;
	}

	
}
