package stepDefinations;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

import org.junit.Assert;


public class Register {
	WebDriver driver;
	private HomePage homepage;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils ;
	
	
	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerPage = homepage.selectRegisterOption();

	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		commonUtils=  new CommonUtils();
		
		Map<String, String> dataMap =dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("LastName"));
		registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
		

	}
	
	@When("User enters the details into below fields for duplicate account")
	public void User_enters_the_details_into_below_fields_for_duplicate_account(DataTable dataTable) {

		
		Map<String, String> dataMap =dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("LastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		

	}

	@And("User selects Privacy policies")
	public void user_selects_privacy_policies() {
		registerPage.selectPrivacyPolicy();
	

	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccessPage = registerPage.clcikOnContinueButton();
		

	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
      Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());

	}
	

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.selectYesToNewsletterOption();
		

	}

	@Then("User account should get a proper warning messages about duplicate email")
	public void user_account_should_get_a_proper_warning_messages_about_duplicate_email() {
		
		Assert.assertTrue(registerPage.getWarningMessage().contains("Warning: E-Mail Address is already registered!"));

	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmail("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
		

	}

	@Then("User account should get a proper warning messages for every mandatory fields")
	public void user_account_should_get_a_proper_warning_messages_for_every_mandatory_fields() {
		
		Assert.assertTrue(registerPage.getWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));

		
	}
	

	
	

}
