
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.BasePage;
import util.ElementUtil;

public class HomePage {

	private static  WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//mat-toolbar/span[text()=' LMS - Learning Management System ']") 
	public WebElement hometoolbartitle;
	@FindBy(id="dashboard")
	public static WebElement homeButton;
	@FindBy(id="program")
	public static WebElement programButton;

	@FindBy(id="class")
	public static WebElement classButton;

	
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean isHomePageToolBarPresent() {
		
		ElementUtil.implicitPageWait(driver);
		System.out.println("home page URL in POM: " + driver.getCurrentUrl());
		return ElementUtil.waitForElementVisibility(driver, hometoolbartitle, 30L).isDisplayed();
		
   }
   public void clickOnHome() {
	   homeButton.click();
   }
	
   public void clickOnProgram() {
	   programButton.click();
   }
   //transitioning to program page from homepage
   public ProgramPage getProgrampageObject() {
	   ProgramPage programpage = new ProgramPage(driver);//this driver has a reference home page driver
	   return programpage;
   }


   public void clickOnClass() {
	   classButton.click();
   }
   //transitioning to Class page from homepage
   public ClassPage getClasspageObject() {
	   ClassPage classpage = new ClassPage(driver);//this driver has a reference home page driver
	   return classpage;
   
   }

}
   

