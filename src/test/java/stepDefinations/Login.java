package stepDefinations;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver; 
	private LoginPage loginpage;
	private AccountPage accountPage;
	private HomePage homepage;
	private CommonUtils commonUtils ;

	
	@Given("User has navigates to login page")
	public void User_has_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
		
		
	}
	
	@When("^User has entered valid email address (.+) into the email field$")
	public void User_has_entered_valid_email_address__into_the_email_field(String emailText){
		
		loginpage.enterEmailAddress(emailText);
		
		
	}
	
	@And("^User has entered valid password (.+) into password field$")
	public void user_has_entered_valid_password_into_password_field(String passwordText) {
		 
		loginpage.enterPassword(passwordText);

	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	
		accountPage = loginpage.clcikOnLoginButton();

	}

	@Then("User should get successsfully logged in")
	public void user_should_get_successsfully_logged_in() {
		
		Assert.assertTrue(accountPage.displayEditAccountIformationOption());
		
		

	}

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidEmailText) {
		
	    commonUtils = new CommonUtils();
		
		loginpage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
		

	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordtext) {
		
		loginpage.enterPassword(invalidPasswordtext);	
	}

	@Then("user should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {

		Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));

	}



	@When("user dont enter any email address  into email field")
	public void user_dont_enter_any_email_address_into_email_field() {
		
		loginpage.enterEmailAddress("");
		

	}

	@And("user dont enter any password into  password field")
	public void user_dont_enter_any_password_into_password_field() {
		loginpage.enterPassword("");
		

	}
	@Then("user should get a warning message")
	public void user_should_get_a_warning_message() {
		Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));


	}
	


}
