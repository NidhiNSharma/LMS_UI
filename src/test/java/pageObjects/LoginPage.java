
package pageObjects;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverFactory.BasePage;
import util.ConfigReader;
import util.ElementUtil;



public class LoginPage extends BasePage

{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "username")
	public WebElement loginusername;

	@FindBy(id = "password")
	public WebElement loginpwd;

	@FindBy(xpath = "//mat-select[@role='combobox']")
	public WebElement loginrole;

	@FindBy(xpath = "//mat-option/span[text()=' Admin ']")
	public WebElement loginrolevalue;
	@FindBy(xpath = "//mat-option//span")
	public List<WebElement> selectingRole;

	@FindBy(id = "login")
	public WebElement loginBtn;

	@FindBy(id = "logout")
	public WebElement homelogout;

	public void navigateToAppUrl() throws InterruptedException {


		String url = ConfigReader.getPropObject().getProperty("appUrl");
		driver.get(url);
		ElementUtil.implicitPageWait(driver);
		System.out.println("Application URL in POM: " + url);

		
		
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		//Thread.sleep(5000);
	}


	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void sendUserName(String uname) {
		ElementUtil.sendKeysIntoInput(driver, loginusername, uname, 20L);
	}

	public void sendPwdName(String password) {
		ElementUtil.sendKeysIntoInput(driver, loginpwd, password, 20L);
	}

	public void sendRoleAsAdmin() {

		ElementUtil.waitForElementClickablity(driver, loginrole, 20L).click();
		ElementUtil.waitForElementClickablity(driver, loginrolevalue, 20L).click();
	}

	public void sendRole(String role) throws InterruptedException {
		ElementUtil.waitForElementClickablity(driver, loginrole, 20L).click();
		for (WebElement e : selectingRole)// Admin,Staff,Student
		{
			//System.out.println(e.getText());
			//System.out.println("role :" + role);

			if (e.getText().contains(role) ){
				e.click();
			}

		}

	}

		
	public void clickLogin() {

		ElementUtil.waitForElementClickablity(driver, loginBtn, 10L).click();
		//btnLogin.click();
	}
	public void clickLogout() 
	  { 
		ElementUtil.waitForElementClickablity(driver, homelogout, 10L).click();
	  }	
	
	
	public HomePage getHomePageObject() {
		
//when ever user redirected to new page that method shld return new page object.	   
	   HomePage  homePage = new HomePage(driver);//this driver has a reference home page driver
	   return homePage;
	}
	
}
	
