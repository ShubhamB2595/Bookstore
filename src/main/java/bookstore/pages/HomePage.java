package bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Initialization of Web driver
	WebDriver driver;
	// Initialization of Constant URLs
	private String HOMEPAGE_URL = "https://www.bookswagon.com/";
	private String LOGIN_URL = "https://www.bookswagon.com/login";
	private String USER_ACC_URL = "https://www.bookswagon.com/myaccount.aspx";
	private String SEARCH_BOOK_URL = "https://www.bookswagon.com/search-books/";
	private String SEARCH_RESULT_URL;

	// Initialization of Web elements
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
	WebElement SEARCH_TXT;
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/input[1]")
	WebElement SEARCH_BTN;
	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	WebElement NEW_ARRIVALS;
	@FindBy(xpath = "//a[contains(text(),'Pre-order')]")
	WebElement PRE_ORDER;
	@FindBy(xpath = "//a[contains(text(),'Bestsellers')]")
	WebElement BEST_SELLERS;
	@FindBy(xpath = "//a[contains(text(),'TextBooks')]")
	WebElement TEXT_BOOKS;
	@FindBy(xpath = "//a[contains(text(),'Award Winners')]")
	WebElement AWARD_WINNERS;
	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[8]/a[1]")
	WebElement AUTHERS;
	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	WebElement BOOKS;
	@FindBy(xpath = "")
	WebElement q;
	@FindBy(xpath = "")
	WebElement a;
	@FindBy(xpath = "")
	WebElement e;

	// Constructor
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void launchingWebpage() {
		driver.get(HOMEPAGE_URL);
	}

	// method for searching books
	public void searchProduct(String bookName) {

		setSEARCH_RESULT_URL(SEARCH_BOOK_URL + bookName);
		launchingWebpage();
		SEARCH_TXT.sendKeys(bookName);
		SEARCH_BTN.click();
	}

	public String getSEARCH_RESULT_URL() {
		return SEARCH_RESULT_URL;
	}

	public void setSEARCH_RESULT_URL(String sEARCH_RESULT_URL) {
		SEARCH_RESULT_URL = sEARCH_RESULT_URL;
	}
}
