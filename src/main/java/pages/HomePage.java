package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils= new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	private WebElement searchButton;
	
	
	
	public void clickOnMyAccount() {
		
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchbox(String productText) {
		
		elementUtils.typeTextIntoElement(searchBoxField,productText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME );

	}
	
	public SearchResultPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		return new SearchResultPage(driver);
	}

}
