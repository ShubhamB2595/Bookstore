package bookstore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Initialization of Web driver
	WebDriver driver;
	// Initialization of Constant URLs
	private String HOMEPAGE_URL = "https://www.bookswagon.com/";
	private String SEARCH_RESULT_URL;
	private String SEARCH_BOOK_URL = "https://www.bookswagon.com/search-books/";
	private String ARRIVALS_URL = "https://www.bookswagon.com/view-books/0/new-arrivals";
	private String PREORDER_URL = "https://www.bookswagon.com/view-books/3/coming-soon-pre-order-now";
	private String SELLER_URL = "https://www.bookswagon.com/view-books/1/top-selling-books";
	private String TEXTBOOKS_URL = "https://www.bookswagon.com/view-books/4/textbook";
	private String WINNER_URL = "https://www.bookswagon.com/view-books/5/award-winners";
	private String AUTHOR_URL = "https://www.bookswagon.com/featured-authors";

	// Initialization of Web elements
	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
	WebElement SEARCH_TXT;
	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
	WebElement SEARCH_BTN;
	@FindBy(xpath = "//a[contains(text(),'New Arrivals') and @class='toplevel oneline']")
	WebElement NEW_ARRIVALS;
	@FindBy(xpath = "//a[contains(text(),'Pre-order')]")
	WebElement PRE_ORDER;
	@FindBy(xpath = "//a[contains(text(),'Bestsellers')]")
	WebElement BEST_SELLERS;
	@FindBy(xpath = "//a[contains(text(),'TextBooks')]")
	WebElement TEXT_BOOKS;
	@FindBy(xpath = "//a[contains(text(),'Award Winners')]")
	WebElement AWARD_WINNERS;
	@FindBy(xpath = "//a[contains(text(),'Featured Authors') and @class='toplevel oneline']")
	WebElement AUTHORS;
	@FindBy(xpath = "//a[contains(text(),'Books') and @href='#']")
	WebElement BOOKS;
	@FindBy(xpath = "//img[@id=\"ctl00_imglogo\"]")
	WebElement BOOKS_WAGON_LOGO;
	@FindBy(xpath = "//div[@class='cover']")
	List<WebElement> SEARCH_LIST;
	@FindBy(xpath = "")
	WebElement e;

	// Constructor
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// for lunching home page
	public void launchingHomepage() {
		driver.get(HOMEPAGE_URL);
	}

	// method for searching books
	public void searchProduct(String bookName) {
		setSEARCH_RESULT_URL(SEARCH_BOOK_URL + bookName);
		launchingHomepage();
		SEARCH_TXT.sendKeys(bookName);
		SEARCH_BTN.click();
	}
	
	public void searchAndSelectProduct(String pName, int pIndex) {
		SEARCH_TXT.sendKeys(pName);
		SEARCH_BTN.click();
		SEARCH_LIST.get(pIndex).click();
	}

	public void checkProduct(String product) {
		SEARCH_TXT.sendKeys(product);
		SEARCH_BTN.click();
		driver.findElement(By.xpath("//a[contains(text(),'" + product + "')]")).click();
	}

	// method for verifying logo
	public boolean logoIsDisplayed() {
		launchingHomepage();
		return BOOKS_WAGON_LOGO.isDisplayed();
	}

	// for verifying new arrivals page
	public String verifyNewArrivals() {
		NEW_ARRIVALS.click();
		return driver.getCurrentUrl();
	}

	// for verifying pre order page
	public String verifyPreOrder() {
		PRE_ORDER.click();
		return driver.getCurrentUrl();
	}

	// for verifying best seller page
	public String verifyBestSeller() {
		BEST_SELLERS.click();
		return driver.getCurrentUrl();
	}

	// for verifying text book page
	public String verifyTextBooks() {
		TEXT_BOOKS.click();
		return driver.getCurrentUrl();
	}

	// for verifying award winner page
	public String verifyAwardWinner() {
		AWARD_WINNERS.click();
		return driver.getCurrentUrl();
	}

	// for verifying feature author page
	public String verifyFeatureAuthor() {
		AUTHORS.click();
		return driver.getCurrentUrl();
	}

	// getters setters
	public String getHOMEPAGE_URL() {
		return HOMEPAGE_URL;
	}

	public void setHOMEPAGE_URL(String hOMEPAGE_URL) {
		HOMEPAGE_URL = hOMEPAGE_URL;
	}

	public String getSEARCH_RESULT_URL() {
		return SEARCH_RESULT_URL;
	}

	public void setSEARCH_RESULT_URL(String sEARCH_RESULT_URL) {
		SEARCH_RESULT_URL = sEARCH_RESULT_URL;
	}

	public String getSEARCH_BOOK_URL() {
		return SEARCH_BOOK_URL;
	}

	public void setSEARCH_BOOK_URL(String sEARCH_BOOK_URL) {
		SEARCH_BOOK_URL = sEARCH_BOOK_URL;
	}

	public String getARRIVALS_URL() {
		return ARRIVALS_URL;
	}

	public void setARRIVALS_URL(String aRRIVALS_URL) {
		ARRIVALS_URL = aRRIVALS_URL;
	}

	public String getPREORDER_URL() {
		return PREORDER_URL;
	}

	public void setPREORDER_URL(String pREORDER_URL) {
		PREORDER_URL = pREORDER_URL;
	}

	public String getSELLER_URL() {
		return SELLER_URL;
	}

	public void setSELLER_URL(String sELLER_URL) {
		SELLER_URL = sELLER_URL;
	}

	public String getTEXTBOOKS_URL() {
		return TEXTBOOKS_URL;
	}

	public void setTEXTBOOKS_URL(String tEXTBOOKS_URL) {
		TEXTBOOKS_URL = tEXTBOOKS_URL;
	}

	public String getWINNER_URL() {
		return WINNER_URL;
	}

	public void setWINNER_URL(String wINNER_URL) {
		WINNER_URL = wINNER_URL;
	}

	public String getAUTHOR_URL() {
		return AUTHOR_URL;
	}

	public void setAUTHOR_URL(String aUTHOR_URL) {
		AUTHOR_URL = aUTHOR_URL;
	}

}
