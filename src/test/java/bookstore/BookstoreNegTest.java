package bookstore;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import bookstore.base.BaseClass;

public class BookstoreNegTest extends BaseClass {
	
	@Test(priority = 0)
	public void loginWithInValidCreadentials() {
		test = extent.createTest("Login with InValid Credentials");
		loginPage.userLogin(prop.getProperty("validEmail"), prop.getProperty("invalidPass"));
		String actualPageURL = driver.getCurrentUrl();
		assertNotEquals(actualPageURL, loginPage.getUSER_ACC_URL());
	}

	@Test(priority = 1)
	public void verifyForgotPasswordWithInValidEmail() {
		loginPage.forgotPassword(prop.getProperty("invalidEmail"));
		assertTrue(loginPage.getWRONG_EMAIL().isDisplayed());
	}
}
