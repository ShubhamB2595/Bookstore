package bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Initialization of Web driver
	WebDriver driver;

	Actions action;

	// Initialization of Constant URLs
	private String LOGIN_URL = "https://www.bookswagon.com/login";
	private String USER_ACC_URL = "https://www.bookswagon.com/myaccount.aspx";
	private String FORGOT_URL = "https://www.bookswagon.com/forgetpassword";

	// Initialization of Web elements
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement EMAIL_TXT;
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement PASSWORD_TXT;
	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_btnLogin']")
	WebElement LOGIN_BTN;
	@FindBy(xpath = "//span[@id = 'ctl00_lblUser']")
	WebElement USER_BTN;
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement USER_LOGIN_BTN;
	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]")
	WebElement FORGOT_PASS_LINK;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_ForgotPassword_btnSubmit']")
	WebElement FORGOT_PASSWORD_BTN;
	@FindBy(xpath = "//input[@id = 'ctl00_phBody_ForgotPassword_txtEmail']")
	WebElement FORGOT_EMAIL_TXT;
	@FindBy(xpath = "//label[contains(text(),'Your email does not exist in our database.')]")
	WebElement WRONG_EMAIL;
	@FindBy(xpath = "//label[contains(text(),'Password has been sent to your email id.')]")
	WebElement EMAIL_SENT;
	@FindBy(xpath = "//a[@id = 'ctl00_lnkbtnLogout']")
	WebElement LOGOUT_BTN;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	// method for user login
	public void userLogin(String email, String password) {

		driver.get(LOGIN_URL);
		EMAIL_TXT.sendKeys(email);
		PASSWORD_TXT.sendKeys(password);
		LOGIN_BTN.click();
	}

	// for logging out the user
	public void userLogout() {
		action.moveToElement(USER_BTN).click(LOGOUT_BTN).perform();
	}

	// for checking user logout status
	public boolean checkLogoutStatus() {
		driver.get(LOGIN_URL);
		return USER_LOGIN_BTN.isDisplayed();
	}

	// for checking user login status
	public boolean checkLoginStatus() {
		driver.get(LOGIN_URL);
		return USER_BTN.isDisplayed();
	}

	// for checking forgot password page
	public void forgotPasswordPage() {
		driver.get(LOGIN_URL);
		FORGOT_PASS_LINK.click();
	}

	// for forgot password
	public void forgotPassword(String userEmail) {
		driver.get(FORGOT_URL);
		FORGOT_EMAIL_TXT.sendKeys(userEmail);
		FORGOT_PASSWORD_BTN.click();
	}

	// getters setters
	public String getLOGIN_URL() {
		return LOGIN_URL;
	}

	public String getUSER_ACC_URL() {
		return USER_ACC_URL;
	}

	public String getFORGOT_URL() {
		return FORGOT_URL;
	}

	public WebElement getWRONG_EMAIL() {
		return WRONG_EMAIL;
	}

	public WebElement getEMAIL_SENT() {
		return EMAIL_SENT;
	}

}
