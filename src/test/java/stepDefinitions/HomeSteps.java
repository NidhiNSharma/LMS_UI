package stepDefinitions;

import driverFactory.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import util.LoggerLoad;
import util.PicoDInjection;

public class HomeSteps {

	PicoDInjection picoObject;

	public HomeSteps(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}

	@Given("Admin is in Homepage")
	public void admin_is_in_homepage() {
		picoObject.homePage = new HomePage(BasePage.getDriver());
	}

	@When("Admin enter valid data in all field and  clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
		LoggerLoad.info("Admin is in Home Page");
	}

	@Then("Admin should see {string} as the title")
	public void admin_should_see_as_the_title(String string) throws InterruptedException {
		Thread.sleep(10);
		picoObject.homePage.clickOnHome();
		//LoggerLoad.info("Title is: " +picoObject.homePage.validateHeader());
		//Assert.assertEquals(picoObject.homePage.validateHeader(), " LMS - Learning Management System ");
		//LoggerLoad.info("Admin see a heading with text " + picoObject.programPage.validateHeader() + " on the page");
	    LoggerLoad.info("Admin is in Home Page" + picoObject.homePage.getHomePageTitle());
	}
}
