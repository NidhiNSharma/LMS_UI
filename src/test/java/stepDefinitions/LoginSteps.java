
package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import util.ExcelReaderListMap;
import util.LoggerLoad;


import driverFactory.BasePage;
import pageObjects.LoginPage;
import util.PicoDInjection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps{
	
	   PicoDInjection picoObject;
	    
	   public LoginSteps(PicoDInjection picoObject){
	    	this.picoObject=picoObject;	 
	   }
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() throws InterruptedException {
		picoObject.loginPage= new LoginPage( BasePage.getDriver());		
		
	}
	@Given("The browser is open")
	public void the_browser_is_open() {
		System.out.println("browser is opened");
	}
	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() throws InterruptedException {
		picoObject.loginPage.navigateToAppUrl();
	}
	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		
		String loginUrl = picoObject.loginPage.getPageUrl();
		String loginTitle = picoObject.loginPage.getPageTitle();
		
		System.out.println("page Url is in setpdef:-"+picoObject.loginPage.getPageUrl());
		System.out.println("Page title is :-"+picoObject.loginPage.getPageTitle());
		
		Assert.assertTrue(loginUrl.contains("login"));
		Assert.assertEquals(loginTitle, "LMS");
	}

	@When("Admin enter valid username as {string} ,password as {string} and role as {string}")
	public void admin_enter_valid_username_as_password_as_and_role_as(String username, String pwd, String role) 
	{
			
		picoObject.loginPage.sendUserName(username);
		picoObject.loginPage.sendPwdName(pwd);;
		picoObject.loginPage.sendRoleAsAdmin();
	}

	@When("clicks login button")
	public void clicks_login_button() {
		
		picoObject.loginPage.clickLogin();
	}
	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() throws InterruptedException {
	   
		picoObject.homePage = picoObject.loginPage.getHomePageObject();	
	    String pageTitle =	picoObject.homePage.getHomePageTitle();
		Assert.assertEquals(pageTitle, "LMS");
		Assert.assertTrue(picoObject.homePage.isHomePageToolBarPresent());;
	}
	
	//Datadriven from Excel
	@When("Admin enter valid credentials from {string} and {int}")
	public void admin_enter_valid_credentials_from_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		LoggerLoad.info("User enters login credentials");
		List<Map<String, String>> testData = reader.getData(PicoDInjection.eXCEL, "Login");
		String User_name = testData.get(rowNumber).get("user"); // Column heading
		String Pass_word = testData.get(rowNumber).get("password"); // Column heading
		String Select_role= testData.get(rowNumber).get("role");//Column Heading
		picoObject.loginPage.sendUserName(User_name); 
		picoObject.loginPage.sendPwdName(Pass_word);
		picoObject.loginPage.sendRole(Select_role);
		LoggerLoad.info("Login credentials entered");

	}
	



}