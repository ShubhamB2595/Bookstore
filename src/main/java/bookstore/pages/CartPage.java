package bookstore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

	// Initialization of Web driver
	WebDriver driver;

	Actions action;
	Select select;

	// storing URL's from shopping cart page
	private String MYCART_URL = "https://www.bookswagon.com/shoppingcart.aspx";

	// Initialization of Web elements
	@FindBy(xpath = "//span[@class='cart-item-count']")
	WebElement MY_CART;
	@FindBy(xpath = "//div[@class='empty-shopping-cart']")
	WebElement EMPTY_CART;
	@FindBy(xpath = "//div[@id='colorbox']")
	WebElement CART_POPUP;
	@FindBy(xpath = "//div[@id='cboxClose']")
	WebElement CLOSE_CART;
	@FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
	WebElement PLACE_ORDER_BTN;
	@FindBy(xpath = "//h1[contains(text(),'My Shopping Cart')]")
	WebElement CART_TITLE;
	@FindBy(id = "BookCart_lvCart_ctrl0_imgDelete")
	WebElement REMOVE;
	@FindBy(xpath = "//body/div[@id='colorbox']/div[@id='cboxWrapper']/div[2]/div[2]/div[1]/iframe[1]")
	WebElement IFRAME;
	@FindBy(xpath = "//input[@value='Buy Now']")
	WebElement BUY_NOW_BTN;
//	@FindBy(xpath = "//div[@class = 'shopping-content']")
	By CART_ITEMS = By.xpath("//div[@class = 'shopping-content']");
	@FindBy(xpath = "//input[@id='BookCart_lvCart_ctrl0_txtQty']")
	WebElement QUANTITY_TXT;
	@FindBy(xpath = "//input[@id='BookCart_lvCart_ctrl0_imgUpdate']")
	WebElement QUANTITY_UPDATE;
	@FindBy(xpath = "//select[@id='ddlCurrency']")
	WebElement CURRENCY_DROPDW;

	// constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	public void clickMyCart() {
		MY_CART.click();
	}

	public boolean isCartOpen() {
		return CART_TITLE.isDisplayed();
	}

	public boolean isCartEmpty() {
		return EMPTY_CART.isDisplayed();
	}

	public void switchToFrame() {
		driver.switchTo().frame(IFRAME);
	}

	public boolean closeCartPopup() {
		CLOSE_CART.click();
		return true;
	}

	public void addToCart() {
		BUY_NOW_BTN.click();
	}

	public void clickPlaceOrder() {
		PLACE_ORDER_BTN.click();
	}

	public int getCartItems() {
		List<WebElement> totalItems = driver.findElements(CART_ITEMS);
		return totalItems.size();
	}

	public void removeFromCart() {
		REMOVE.click();
	}

	public String getQuantity() {
		System.out.println(QUANTITY_TXT.getAttribute("value"));
		return QUANTITY_TXT.getAttribute("value");
	}

	public void changeQuantity(String qty) {
		QUANTITY_TXT.clear();
		QUANTITY_TXT.sendKeys(qty);
		QUANTITY_UPDATE.click();
	}

	public void changeCurrency(String currency) {
		select = new Select(CURRENCY_DROPDW);
		select.selectByVisibleText(currency);
	}

	// getters setters
	public String getMYCART_URL() {
		return MYCART_URL;
	}
}
