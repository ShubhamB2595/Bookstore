package bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import bookstore.utilities.ExcelLibrary;

public class CheckoutPage {

	// Initialization of Web driver
	WebDriver driver;

	ExcelLibrary excelLibrary = new ExcelLibrary();
	Select select;

	// storing URL's from checkout page
	private String CHECKOUT_URL = "https://www.bookswagon.com/checkout-login";

	// Initialization of Web elements
	@FindBy(xpath = "//div[@class='checkout-head-new']")
	WebElement CHECKOUT_PAGE;
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement ACCOUNT_CONT_BTN;
	@FindBy(xpath = "//input[@id='ctl00_cpBody_txtNewRecipientName']")
	WebElement RNAME;
	@FindBy(xpath = "//textarea[@id='ctl00_cpBody_txtNewAddress']")
	WebElement ADDRESS;
	@FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewCountry']")
	WebElement COUNTRY;
	@FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewState']")
	WebElement STATE;
	@FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewCities']")
	WebElement CITY;
	@FindBy(xpath = "//input[@id='ctl00_cpBody_txtNewPincode']")
	WebElement PINCODE;
	@FindBy(xpath = "//input[@id='ctl00_cpBody_txtNewMobile']")
	WebElement MOBILE;
	@FindBy(xpath = "//input[@id='ctl00_cpBody_imgSaveNew']")
	WebElement ADDRESS_CONT_BTN;
	@FindBy(xpath = "//input[@id='ctl00_cpBody_ShoppingCart_lvCart_savecontinue']")
	WebElement ORDER_CONT_BTN;
//	@FindBy(xpath = "//input[@id='ctl00_cpBody_ShoppingCart_lvCart_savecontinue']")
//	WebElement e;

	// Constructor
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods
	public boolean isCheckoutPage() {
		return CHECKOUT_PAGE.isDisplayed();
	}

	public void clickAccContinueBtn() {
		ACCOUNT_CONT_BTN.click();
	}

	public void enterShippingAddress() {
		RNAME.sendKeys(excelLibrary.getCellData("AddressData", 0, 2));
		ADDRESS.sendKeys(excelLibrary.getCellData("AddressData", 1, 2));
		select = new Select(COUNTRY);
		select.selectByVisibleText(excelLibrary.getCellData("AddressData", 2, 2));
		select = new Select(STATE);
		select.selectByVisibleText(excelLibrary.getCellData("AddressData", 3, 2));
		select = new Select(CITY);
		select.selectByVisibleText(excelLibrary.getCellData("AddressData", 4, 2));
		PINCODE.sendKeys(excelLibrary.getCellData("AddressData", 5, 2));
		MOBILE.sendKeys(excelLibrary.getCellData("AddressData", 6, 2));

	}

	public void clickAddressSaveCont() {
		ADDRESS_CONT_BTN.click();
	}

	public void clickOrderSaveCont() {
		ORDER_CONT_BTN.click();
	}

	// getter setters
	public String getCHECKOUT_URL() {
		return CHECKOUT_URL;
	}

}
