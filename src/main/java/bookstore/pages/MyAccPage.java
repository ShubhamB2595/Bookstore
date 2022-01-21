package bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccPage {

	WebDriver driver;

	private String ACC_URL = "https://www.bookswagon.com/myaccount.aspx";
	private String ACC_SETTING_URL = "https://www.bookswagon.com/accountsetting.aspx";
	private String MY_ORDER_URL = "https://www.bookswagon.com/orders.aspx";
	private String MY_WISHLIST_URL = "https://www.bookswagon.com/wishlist.aspx";
	private String MY_GIFT_URL = "https://www.bookswagon.com/mygiftcert.aspx";
	private String MY_ADDRESS_URL = "https://www.bookswagon.com/myaddress.aspx";
	private String CHANGE_PASS_URL = "https://www.bookswagon.com/changepassword.aspx";

	@FindBy(xpath = "(//a[contains(text(),'Personal Settings')])[2]")
	WebElement PERSONAL_SETTING;
	@FindBy(xpath = "//input[@id='ctl00_phBody_AccountSetting_fvCustomer_imgUpdate']")
	WebElement EDIT_BTN;
	@FindBy(xpath = "(//a[contains(text(),'My Orders')])[2]")
	WebElement MY_ORDERS;
	@FindBy(xpath = "(//a[contains(text(),'My Wishlist')])[2]")
	WebElement MY_WISHLIST;
	@FindBy(xpath = "(//a[contains(text(),'My Gift Certificate')])[2]")
	WebElement MY_GIFT;
	@FindBy(xpath = "(//a[contains(text(),'My Addresses')])[2]")
	WebElement MY_ADD;
	@FindBy(xpath = "(//a[contains(text(),'Change Password')])[2]")
	WebElement CHANGE_PASS;
	@FindBy(xpath = "(//a[contains(text(),'')])[2]")
	WebElement CERTIFICATE;

	// Constructor
	public MyAccPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods
	public void visitPersonalSettingPage() {
		PERSONAL_SETTING.click();
	}

	public void visitMyOrdersPage() {
		MY_ORDERS.click();
	}

	public void visitMyWishlistPage() {
		MY_WISHLIST.click();
	}

	public void visitMyGiftPage() {
		MY_GIFT.click();
	}

	public void visitMyAddressPage() {
		MY_ADD.click();
	}

	public void visitChangePasswordPage() {
		CHANGE_PASS.click();
	}

	// Getters Setters
	public String getACC_URL() {
		return ACC_URL;
	}

	public String getACC_SETTING_URL() {
		return ACC_SETTING_URL;
	}

	public String getMY_ORDER_URL() {
		return MY_ORDER_URL;
	}

	public String getMY_WISHLIST_URL() {
		return MY_WISHLIST_URL;
	}

	public String getMY_GIFT_URL() {
		return MY_GIFT_URL;
	}

	public String getMY_ADDRESS_URL() {
		return MY_ADDRESS_URL;
	}

	public String getCHANGE_PASS_URL() {
		return CHANGE_PASS_URL;
	}

}
